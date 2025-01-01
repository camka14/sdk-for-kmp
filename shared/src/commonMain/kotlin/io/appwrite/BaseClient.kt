package io.appwrite

import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.json
import io.appwrite.fileOperations.readFileBytes
import io.appwrite.fileOperations.readFileChunk
import io.appwrite.fileOperations.readFileSize
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
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.int
import kotlinx.serialization.json.put
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
abstract class BaseClient<This : BaseClient<This>>(
    var endpoint: String,
    var endpointRealtime: String?
) : CoroutineScope {
    companion object {
        internal const val CHUNK_SIZE = 5 * 1024 * 1024 // 5MB
    }

    private val mutex = SynchronizedObject()
    private val job = Job()
    internal lateinit var httpClient: HttpClient

    internal lateinit var headers: MutableMap<String, String>
    internal val config = mutableMapOf<String, String>()

    /**
     * Set the HTTP client instance for making API requests
     *
     * @param value The HTTP client instance
     * @return [This]
     */
    fun setHttpClient(value: HttpClient): This {
        httpClient = value
        return this as This
    }

    /**
     * Set the project ID for authentication
     *
     * @param value The project ID
     * @return [This]
     */
    fun setProject(value: String): This = synchronized(mutex) {
        config["project"] = value
        addHeader("x-appwrite-project", value)
        this as This
    }

    /**
     * Set the JWT token for authentication
     *
     * @param value The JWT token
     * @return [This]
     */
    fun setJWT(value: String): This = synchronized(mutex) {
        config["jWT"] = value
        addHeader("x-appwrite-jwt", value)
        this as This
    }

    /**
     * Set the locale for internationalization
     *
     * @param value The locale string
     * @return [This]
     */
    fun setLocale(value: String): This = synchronized(mutex) {
        config["locale"] = value
        addHeader("x-appwrite-locale", value)
        this as This
    }

    /**
     * Set the session token for authentication
     *
     * @param value The session token
     * @return [This]
     */
    fun setSession(value: String): This = synchronized(mutex) {
        config["session"] = value
        addHeader("x-appwrite-session", value)
        this as This
    }

    /**
     * Set the API endpoint URL
     *
     * @param endpoint The API endpoint URL
     * @return [This]
     */
    fun setEndpoint(endpoint: String): This {
        this.endpoint = endpoint
        if (this.endpointRealtime == null && endpoint.startsWith("http")) {
            this.endpointRealtime = endpoint.replaceFirst("http", "ws")
        }
        return this as This
    }

    /**
     * Set the websocket endpoint URL for realtime connections
     *
     * @param endpoint The websocket endpoint URL
     * @return [This]
     */
    fun setEndpointRealtime(endpoint: String): This {
        this.endpointRealtime = endpoint
        return this as This
    }

    private fun addHeader(key: String, value: String): This {
        headers[key] = value
        return this as This
    }

    /**
     * Send the HTTP request
     *
     * @param method The HTTP method
     * @param path The API path
     * @param headers The request headers
     * @param params The request parameters
     * @param responseType The expected response type
     * @param serializer Optional custom serializer
     *
     * @return [T]
     */
    @OptIn(InternalSerializationApi::class)
    @Throws(Throwable::class)
    suspend fun <T : Any> call(
        method: String,
        path: String,
        headers: Map<String, String> = mapOf(),
        params: Map<String, Any?> = mapOf(),
        responseType: KClass<T>,
        serializer: KSerializer<T>? = null
    ): T {
        val filteredParams = params.filterValues { it != null }

        val combinedHeaders = headers + this.headers

        return httpClient.request(endpoint + path) {
            this.method = HttpMethod.parse(method)

            // Add headers
            combinedHeaders.forEach { (key, value) ->
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
                    val jsonObject = buildJsonObject {
                        filteredParams.forEach { (key, value) ->
                            when (value) {
                                is String -> put(key, value)
                                is Number -> put(key, value)
                                is Boolean -> put(key, value)
                                null -> put(key, JsonNull)
                            }
                        }
                    }
                    setBody(jsonObject)
                }
            }
        }.let { response ->
            when {
                !response.status.isSuccess() -> {
                    val body = response.bodyAsText()
                    println(body)
                    if (response.contentType()?.match(ContentType.Application.Json) == true) {
                        val map = Json.decodeFromString<Map<String, JsonElement>>(body)
                        throw AppwriteException(
                            (map["message"] as? JsonPrimitive)?.content ?: "",
                            (map["code"] as? JsonPrimitive)?.int ?: 0,
                            (map["type"] as? JsonPrimitive)?.content ?: "",
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
                        serializer?.let {
                            json.decodeFromString(serializer, body)
                        } ?: run {
                            json.decodeFromString(responseType.serializer(), body)
                        }
                    }
                }
            }
        }
    }

    /**
     * Handle large file uploads by splitting into chunks
     *
     * @param path The upload endpoint path
     * @param headers The request headers
     * @param params The upload parameters
     * @param responseType The expected response type
     * @param serializer The response serializer
     * @param paramName The file parameter name
     * @param idParamName Optional ID parameter name
     * @param onProgress Optional progress callback
     *
     * @return [T]
     */
    @Throws(Throwable::class)
    suspend fun <T : Any> chunkedUpload(
        path: String,
        headers: MutableMap<String, String>,
        params: MutableMap<String, Any?>,
        responseType: KClass<T>,
        serializer: KSerializer<T>,
        paramName: String,
        idParamName: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null,
    ): T {
        val input = params[paramName] as InputFile
        val size: Long = when (input.sourceType) {
            "path", "file" -> readFileSize(input.path)
            "bytes" -> (input.data).size.toLong()
            else -> throw UnsupportedOperationException()
        }

        if (size < CHUNK_SIZE) {
            val data = when (input.sourceType) {
                "file", "path" -> readFileBytes(input.path, 0, size)
                "bytes" -> input.data
                else -> throw UnsupportedOperationException()
            }
            params[paramName] = data
            headers["content-type"] = "multipart/form-data"
            headers["content-disposition"] =
                "form-data; name=\"$paramName\"; filename=\"${input.filename}\""

            return call(
                method = "POST",
                path = path,
                headers = headers,
                params = params,
                responseType = responseType,
                serializer = serializer
            )
        }

        val buffer = ByteArray(CHUNK_SIZE)
        var offset = 0L
        var result: T? = null

        if (idParamName?.isNotEmpty() == true && params[idParamName] != "unique()") {
            result = call(
                method = "GET",
                path = "$path/${params[idParamName]}",
                headers = headers,
                params = emptyMap(),
                responseType = responseType,
                serializer = serializer
            )
            val chunksUploaded = (result as? Map<*, *>)?.get("chunksUploaded") as? Number
            offset = (chunksUploaded?.toLong() ?: 0) * CHUNK_SIZE
        }

        while (offset < size) {
            val chunkSize = minOf(CHUNK_SIZE.toLong(), size - offset)

            when (input.sourceType) {
                "file", "path" -> {
                    readFileChunk(input.path, offset, buffer, chunkSize.toInt())
                }

                "bytes" -> {
                    val end = (offset + chunkSize).toInt()
                    (input.data).copyInto(
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
            headers["content-disposition"] =
                "form-data; name=\"$paramName\"; filename=\"${input.filename}\""
            headers["content-range"] = "bytes $offset-${(offset + chunkSize - 1)}/$size"

            result = call(
                method = "POST",
                path = path,
                headers = headers,
                params = params,
                responseType = responseType,
                serializer = serializer
            )

            offset += chunkSize

            val resultMap = result as? Map<*, *>
            headers["x-appwrite-id"] = resultMap?.get("\$id").toString()

            onProgress?.invoke(
                UploadProgress(
                    id = resultMap?.get("\$id").toString(),
                    progress = offset.coerceAtMost(size).toDouble() / size * 100,
                    sizeUploaded = offset.coerceAtMost(size),
                    chunksTotal = (resultMap?.get("chunksTotal") as? Number)?.toInt() ?: 0,
                    chunksUploaded = (resultMap?.get("chunksUploaded") as? Number)?.toInt() ?: 0
                )
            )
        }

        return result ?: throw AppwriteException("Upload failed")
    }
}