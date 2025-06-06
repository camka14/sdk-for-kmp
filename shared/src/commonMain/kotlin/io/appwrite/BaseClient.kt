package io.appwrite

import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.addToJsonObject
import io.appwrite.extensions.getSerializer
import io.appwrite.extensions.json
import io.appwrite.models.InputFile
import io.appwrite.models.UploadProgress
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.forms.formData
import io.ktor.client.request.forms.submitFormWithBinaryData
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.request
import io.ktor.client.request.setBody
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.HttpHeaders
import io.ktor.http.HttpMethod
import io.ktor.http.contentType
import io.ktor.http.isSuccess
import io.ktor.http.quote
import kotlinx.atomicfu.locks.SynchronizedObject
import kotlinx.atomicfu.locks.synchronized
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.io.Buffer
import kotlinx.io.buffered
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.io.readByteArray
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.int
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

@Suppress("UNCHECKED_CAST")
abstract class BaseClient<This : BaseClient<This>>(
    var endpoint: String = "https://cloud.appwrite.io/v1",
    var endpointRealtime: String? = null,
    private var selfSigned: Boolean = false
) : CoroutineScope {
    companion object {
        internal const val CHUNK_SIZE: Long = 5 * 1024 * 1024 // 5MB
    }

    private val mutex = SynchronizedObject()
    private val job = Job()
    internal lateinit var httpClient: HttpClient

    internal lateinit var headers: MutableMap<String, String>
    internal val config = mutableMapOf<String, String>()


    /**
     * Set Project
     *
     * Your project ID
     *
     * @param {string} project
     *
     * @return this
     */
    fun setProject(value: String): This {
        config["project"] = value
        addHeader("x-appwrite-project", value)
        return this as This
    }

    /**
     * Set Key
     *
     * Your secret API key
     *
     * @param {string} key
     *
     * @return this
     */
    fun setKey(value: String): This {
        config["key"] = value
        addHeader("x-appwrite-key", value)
        return this as This
    }

    /**
     * Set JWT
     *
     * Your secret JSON Web Token
     *
     * @param {string} jwt
     *
     * @return this
     */
    fun setJWT(value: String): This {
        config["jWT"] = value
        addHeader("x-appwrite-jwt", value)
        return this as This
    }

    /**
     * Set Locale
     *
     * @param {string} locale
     *
     * @return this
     */
    fun setLocale(value: String): This {
        config["locale"] = value
        addHeader("x-appwrite-locale", value)
        return this as This
    }

    /**
     * Set Mode
     *
     * @param {string} mode
     *
     * @return this
     */
    fun setMode(value: String): This {
        config["mode"] = value
        addHeader("x-appwrite-mode", value)
        return this as This
    }

    /**
     * Set the API endpoint URL
     *
     * @param endpoint The API endpoint URL
     * @return [This]
     */
    fun setEndpoint(endpoint: String): This {
        require(endpoint.startsWith("http://") || endpoint.startsWith("https://")) {
            "Invalid endpoint URL: $endpoint"
        }
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

    fun addHeader(key: String, value: String): This {
        headers[key] = value
        return this as This
    }

    /**
     * Sends a "ping" request to Appwrite to verify connectivity.
     *
     * @return String
     */
    suspend fun ping(): String {
        val apiPath = "/ping"
        val apiParams = mutableMapOf<String, Any?>()
        val apiHeaders = mutableMapOf("content-type" to "application/json")

        return call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = String::class
        )
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
            combinedHeaders.forEach { (key, value) ->
                header(key, value)
            }
            if (method.uppercase() == "GET") {
                filteredParams.forEach { (key, value) ->
                    when (value) {
                        is List<*> -> value.forEach { item ->
                            parameter("${key}[]", item.toString())
                        }

                        else -> parameter(key, value.toString())
                    }
                }
            } else {
                contentType(ContentType.Application.Json)
                val jsonObject = buildJsonObject {
                    filteredParams.forEach { (key, value) ->
                        addToJsonObject(key, value)
                    }
                }
                setBody(jsonObject)
            }
        }.let { response ->
            handleResponse(response, responseType, serializer)
        }
    }

     /**
     * Handle large file uploads by splitting into chunks
     *
     * @param path The upload endpoint path
     * @param headers The request headers
     * @param params The upload parameters
     * @param input The InputFile to upload
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
        input: InputFile,
        responseType: KClass<T>,
        serializer: KSerializer<T>,
        paramName: String,
        idParamName: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null
    ): T {
        val filteredParams = params.filterValues { it != null }
        val combinedHeaders = (headers + this.headers).toMutableMap()

        val size: Long = when (input.sourceType) {
            "path", "file" -> {
                SystemFileSystem.metadataOrNull(Path(input.path))?.size ?: 0L
            }

            "bytes" -> {
                input.data.size.toLong()
            }

            else -> throw UnsupportedOperationException()
        }
        val data = when (input.sourceType) {
            "file", "path" -> SystemFileSystem.source(Path(input.path)).buffered()
            "bytes" -> input.data
            else -> throw UnsupportedOperationException()
        }

        if (size < CHUNK_SIZE) {
            return httpClient.submitFormWithBinaryData(
                url = endpoint + path,
                formData = formData {
                    filteredParams.forEach { (key, value) ->
                        when (value) {
                            is List<*> -> value.forEach { item ->
                                append("${key}[]", item.toString())
                            }

                            else -> append(key, value.toString())
                        }
                    }
                    append(
                        paramName,
                        Buffer().apply {
                            write(data, size)
                        },
                        Headers.build {
                            append(HttpHeaders.ContentType, input.mimeType)
                            append(
                                HttpHeaders.ContentDisposition,
                                "filename=${input.filename.quote()}"
                            )
                        }
                    )
                }
            ) {
                combinedHeaders.forEach { (key, value) ->
                    header(key, value)
                }
            }.let { response ->
                handleResponse(response, responseType, serializer)
            }
        }

        var offset = 0L
        var chunksUploaded = 0L

        if (idParamName?.isNotEmpty() == true) {
            // Make a request to check if a file already exists
            try {
                val current = call(
                    method = "GET",
                    path = "$path/${params[idParamName]}",
                    headers = headers,
                    params = emptyMap(),
                    responseType = Map::class,
                )
                chunksUploaded = current["chunksUploaded"] as Long
                offset = chunksUploaded * CHUNK_SIZE
            } catch (e: Exception) {
                // Swallow exception
            }
        }

        var result: Map<*, *> = mapOf<String, Any>()
        while (offset < size) {
            val bytesToRead = if (size - offset < CHUNK_SIZE) {
                (size - offset).toInt()
            } else {
                CHUNK_SIZE.toInt()
            }
            val chunk = data.readByteArray(bytesToRead)

            httpClient.submitFormWithBinaryData(
                url = endpoint + path,
                formData = formData {
                    filteredParams.forEach { (key, value) ->
                        when (value) {
                            is List<*> -> value.forEach { item ->
                                append("${key}[]", item.toString())
                            }

                            else -> append(key, value.toString())
                        }
                    }
                    append(
                        paramName,
                        chunk,
                        Headers.build {
                            append(HttpHeaders.ContentType, input.mimeType)
                            append(
                                HttpHeaders.ContentDisposition,
                                "filename=${input.filename.quote()}"
                            )
                        }
                    )
                }
            ) {
                header(
                    HttpHeaders.ContentRange,
                    "bytes $offset-${((offset + CHUNK_SIZE) - 1).coerceAtMost(size - 1)}/$size"
                )
                combinedHeaders.forEach { (key, value) ->
                    header(key, value)
                }
                if (chunksUploaded != 0L) {
                    header("x-appwrite-id", result["\$id"].toString().removeSurrounding("\""))
                }
            }.let { response ->
                result = handleResponse(response, Map::class, getSerializer(Map::class))
                offset += bytesToRead
                chunksUploaded++
                onProgress?.invoke(
                    UploadProgress(
                        id = result["\$id"].toString(),
                        progress = offset.coerceAtMost(size).toDouble() / size * 100,
                        sizeUploaded = offset.coerceAtMost(size),
                        chunksTotal = result["chunksTotal"].toString().toInt(),
                        chunksUploaded = result["chunksUploaded"].toString().toInt(),
                    )
                )
            }
        }
        return json.decodeFromString(
            serializer,
            json.encodeToString(getSerializer(Map::class), result)
        )
    }

    @OptIn(InternalSerializationApi::class)
    private suspend fun <T : Any> handleResponse(
        response: HttpResponse,
        responseType: KClass<T>,
        serializer: KSerializer<T>? = null
    ): T {
        return when {
            !response.status.isSuccess() -> {
                val body = response.bodyAsText()

                if (response.contentType()?.match(ContentType.Application.Json) == true) {
                    val map = json.decodeFromString<Map<String, JsonElement>>(body)
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
                    when {
                        body.isEmpty() -> when (responseType) {
                            String::class -> "" as T
                            Boolean::class -> true as T
                            else -> throw AppwriteException(
                                "Empty response body",
                                response.status.value
                            )
                        }

                        responseType == String::class -> body as T
                        else -> try {
                            serializer?.let { json.decodeFromString(it, body) }
                                ?: json.decodeFromString(responseType.serializer(), body)
                        } catch (e: Exception) {
                            throw AppwriteException(
                                "Failed to parse JSON response: ${e.message}",
                                response.status.value,
                                response = body
                            )
                        }
                    }
                }
            }
        }
    }
}
