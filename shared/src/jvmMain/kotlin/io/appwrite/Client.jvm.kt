package io.appwrite

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import java.util.Properties

actual class Client(
    endpoint: String = "https://cloud.appwrite.io/v1",
    endpointRealtime: String? = null,
    selfSigned: Boolean = false,
) : BaseClient<Client>(endpoint, endpointRealtime) {
    actual override val coroutineContext = Job() + Dispatchers.Default

    private val appVersion by lazy {
        try {
            val properties = Properties()
            properties.load(this.javaClass.getResourceAsStream("/version.properties"))
            return@lazy properties.getProperty("version", "unknown")
        } catch (e: Exception) {
            e.printStackTrace()
            return@lazy "unknown"
        }
    }

    init {
        httpClient = createHttpClient(selfSigned)
        headers = mutableMapOf(
            "content-type" to "application/json",
            "origin" to "appwrite-jvm://app",
            "user-agent" to "JVM/$appVersion, ${System.getProperty("java.version")}",
            "x-sdk-name" to "JVM",
            "x-sdk-platform" to "client",
            "x-sdk-language" to "kotlin",
            "x-sdk-version" to "6.0.0",
            "x-appwrite-response-format" to "1.6.0"
        )
    }

    actual fun setSelfSigned(value: Boolean): Client {
        httpClient = createHttpClient(value)
        return this
    }
}
