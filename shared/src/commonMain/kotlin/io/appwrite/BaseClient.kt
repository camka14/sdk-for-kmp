package io.appwrite

import io.appwrite.FileOperations.readFileBytes
import io.appwrite.FileOperations.readFileChunk
import io.appwrite.FileOperations.readFileSize
import io.appwrite.exceptions.AppwriteException
import io.appwrite.models.InputFile
import io.appwrite.models.UploadProgress
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.MultiPartFormDataContent
import io.ktor.client.request.forms.formData
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.serialization.json.Json
import kotlin.coroutines.cancellation.CancellationException
import kotlin.reflect.KClass

abstract class BaseClient<This: BaseClient<This>>(
) : CoroutineScope {
    companion object {
        internal const val CHUNK_SIZE = 5*1024*1024 // 5MB
    }

    private val mutex = SynchronizedObject()
    private val job = Job()
    open var endpoint: String = "https://cloud.appwrite.io/v1"
    open var endpointRealtime: String? = null
    internal lateinit var httpClient: HttpClient

    internal val headers = mutableMapOf(
        "content-type" to "application/json",
        "x-sdk-name" to "KMP",
        "x-sdk-platform" to "client",
        "x-sdk-language" to "kotlin",
        "x-sdk-version" to "6.0.0",
        "x-appwrite-response-format" to "1.6.0"
    )
    internal val config = mutableMapOf<String, String>()
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    @Suppress("UNCHECKED_CAST")
    fun setHttpClient(value: HttpClient): This {
        httpClient = value
        return this as This
    }

    @Suppress("UNCHECKED_CAST")
    fun setProject(value: String): This = synchronized(mutex) {
        config["project"] = value
        addHeader("x-appwrite-project", value)
        this as This
    }

    @Suppress("UNCHECKED_CAST")
    fun setJWT(value: String): This = synchronized(mutex) {
        config["jWT"] = value
        addHeader("x-appwrite-jwt", value)
        this as This
    }

    @Suppress("UNCHECKED_CAST")
    fun setLocale(value: String): This = synchronized(mutex) {
        config["locale"] = value
        addHeader("x-appwrite-locale", value)
        this as This
    }

    @Suppress("UNCHECKED_CAST")
    fun setSession(value: String): This = synchronized(mutex) {
        config["session"] = value
        addHeader("x-appwrite-session", value)
        this as This
    }

    @Suppress("UNCHECKED_CAST")
    fun setEndpoint(endpoint: String): This {
        this.endpoint = endpoint
        if (this.endpointRealtime == null && endpoint.startsWith("http")) {
            this.endpointRealtime = endpoint.replaceFirst("http", "ws")
        }
        return this as This
    }

    @Suppress("UNCHECKED_CAST")
    fun setEndpointRealtime(endpoint: String): This {
        this.endpointRealtime = endpoint
        return this as This
    }

    @Suppress("UNCHECKED_CAST")
    private fun addHeader(key: String, value: String): This {
        headers[key] = value
        return this as This
    }

    /**
     * Send the HTTP request
     *
     * @param method
     * @param path
     * @param headers
     * @param params
     *
     * @return [T]
     */
    @Throws(AppwriteException::class, CancellationException::class)
    suspend fun <T : Any> call(
        method: String,
        path: String,
        headers: Map<String, String> = mapOf(),
        params: Map<String, Any?> = mapOf(),
        responseType: KClass<T>,
        converter: ((Any) -> T)? = null
    ): T {
        val filteredParams = params.filterValues { it != null }

        return httpClient.request(endpoint + path) {
            this.method = HttpMethod.parse(method)

            // Add headers
            headers.forEach { (key, value) ->
                header(key, value)
            }

            if (method == "GET") {
                filteredParams.forEach { (key, value) ->
                    when (value) {
                        is List<*> -> {
                            value.forEach { item ->
                                parameter("${key}[]", item.toString())
                            }
                        }
                        else -> parameter(key, value.toString())
                    }
                }
            } else {
                if (headers["content-type"] == "multipart/form-data") {
                    setBody(MultiPartFormDataContent(
                        formData {
                            filteredParams.forEach { (key, value) ->
                                when {
                                    key == "file" -> {
                                        // Handle file upload
                                        val part = value as ByteArray
                                        append(key, part)
                                    }
                                    value is List<*> -> {
                                        value.forEach { item ->
                                            append("${key}[]", item.toString())
                                        }
                                    }
                                    else -> append(key, value.toString())
                                }
                            }
                        }
                    ))
                } else {
                    contentType(ContentType.Application.Json)
                    setBody(filteredParams)
                }
            }
        }.let { response ->
            when {
                !response.status.isSuccess() -> {
                    val body = response.bodyAsText()
                    if (response.contentType()?.match(ContentType.Application.Json) == true) {
                        val map = Json.decodeFromString<Map<String, Any>>(body)
                        throw AppwriteException(
                            map["message"] as? String ?: "",
                            (map["code"] as Number).toInt(),
                            map["type"] as? String ?: "",
                            body
                        )
                    } else {
                        throw AppwriteException(body, response.status.value)
                    }
                }
                responseType == Boolean::class -> true as T
                responseType == ByteArray::class -> response.body<ByteArray>() as T
                else -> {
                    val body = response.bodyAsText()
                    if (body.isEmpty()) {
                        true as T
                    } else {
                        val map = Json.decodeFromString<Any>(body)
                        converter?.invoke(map) ?: map as T
                    }
                }
            }
        }
    }

    @Throws(AppwriteException::class, CancellationException::class)
    suspend fun <T : Any> chunkedUpload(
        path: String,
        headers: MutableMap<String, String>,
        params: MutableMap<String, Any?>,
        responseType: KClass<T>,
        converter: ((Any) -> T),
        paramName: String,
        idParamName: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null,
    ): T {
        val input = params[paramName] as InputFile
        val size: Long = when(input.sourceType) {
            "path", "file" -> {
                readFileSize(input.path)
            }
            "bytes" -> {
                (input.data).size.toLong()
            }
            else -> throw UnsupportedOperationException()
        }

        if (size < CHUNK_SIZE) {
            val data = when(input.sourceType) {
                "file", "path" -> {
                    readFileBytes(input.path, 0, size)
                }
                "bytes" -> input.data
                else -> throw UnsupportedOperationException()
            }
            params[paramName] = data
            headers["content-type"] = "multipart/form-data"
            headers["content-disposition"] = "form-data; name=\"$paramName\"; filename=\"${input.filename}\""

            return call(
                method = "POST",
                path = path,
                headers = headers,
                params = params,
                responseType = responseType,
                converter = converter
            )
        }

        val buffer = ByteArray(CHUNK_SIZE)
        var offset = 0L
        var result: Map<*, *>? = null

        if (idParamName?.isNotEmpty() == true && params[idParamName] != "unique()") {
            val current = call(
                method = "GET",
                path = "$path/${params[idParamName]}",
                headers = headers,
                params = emptyMap(),
                responseType = Map::class,
            )
            val chunksUploaded = (current["chunksUploaded"] as Number).toLong()
            offset = chunksUploaded * CHUNK_SIZE
        }

        while (offset < size) {
            val chunkSize = minOf(CHUNK_SIZE.toLong(), size - offset)

            when(input.sourceType) {
                "file", "path" -> {
                    readFileChunk(input.path, offset, buffer, chunkSize.toInt())
                }
                "bytes" -> {
                    val end = (offset + chunkSize).toInt()
                    (input.data as ByteArray).copyInto(
                        buffer,
                        destinationOffset = 0,
                        startIndex = offset.toInt(),
                        endIndex = end
                    )
                }
                else -> throw UnsupportedOperationException()
            }

            params[paramName] = buffer.copyOf(chunkSize.toInt())
            headers["content-type"] = "multipart/form-data"
            headers["content-disposition"] = "form-data; name=\"$paramName\"; filename=\"${input.filename}\""
            headers["content-range"] = "bytes $offset-${(offset + chunkSize - 1)}/$size"

            result = call(
                method = "POST",
                path = path,
                headers = headers,
                params = params,
                responseType = Map::class
            )

            offset += chunkSize
            headers["x-appwrite-id"] = result["\$id"].toString()
            onProgress?.invoke(
                UploadProgress(
                    id = result["\$id"].toString(),
                    progress = offset.coerceAtMost(size).toDouble() / size * 100,
                    sizeUploaded = offset.coerceAtMost(size),
                    chunksTotal = (result["chunksTotal"] as Number).toInt(),
                    chunksUploaded = (result["chunksUploaded"] as Number).toInt()
                )
            )
        }

        return converter(result as Map<String, Any>)
    }
}
