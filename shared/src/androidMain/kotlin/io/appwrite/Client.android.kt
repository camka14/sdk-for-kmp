package io.appwrite

import android.content.Context
import android.content.pm.PackageManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

actual class Client(
    private val context: Context,
    endpoint: String = "https://cloud.appwrite.io/v1",
    endpointRealtime: String? = null,
    selfSigned: Boolean = false
) : BaseClient<Client>(endpoint, endpointRealtime) {
    override val coroutineContext = Job() + Dispatchers.Default

    private val appVersion by lazy {
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            return@lazy pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            return@lazy ""
        }
    }

    init {
        httpClient = createHttpClient(context, selfSigned)
        headers = mutableMapOf(
            "content-type" to "application/json",
            "origin" to "appwrite-android://${context.packageName}",
            "user-agent" to "${context.packageName}/${appVersion}, ${System.getProperty("http.agent")}",
            "x-sdk-name" to "Android",
            "x-sdk-platform" to "client",
            "x-sdk-language" to "android",
            "x-sdk-version" to "6.0.0",
            "x-appwrite-response-format" to "1.6.0"
        )
    }

    actual fun setSelfSigned(value: Boolean): Client {
        httpClient = createHttpClient(context, value)
        return this
    }
}