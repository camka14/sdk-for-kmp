package io.appwrite

import io.appwrite.cookies.IosCookieStorage
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import platform.Foundation.NSBundle
import platform.UIKit.UIDevice

actual class Client(
    endpoint: String = "https://cloud.appwrite.io/v1",
    endpointRealtime: String? = null,
    selfSigned: Boolean = false,
) : BaseClient<Client>(endpoint, endpointRealtime) {
    actual override val coroutineContext = Job() + Dispatchers.Default

    private val appVersion: String by lazy {
        NSBundle.mainBundle.infoDictionary?.get("CFBundleShortVersionString") as? String ?: ""
    }

    private val bundleId: String by lazy {
        NSBundle.mainBundle.bundleIdentifier ?: ""
    }

    val iosCookieStorage = IosCookieStorage()

    init {
        httpClient = createHttpClient(selfSigned, iosCookieStorage)
        val appName =
            NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleDisplayName") as String?
                ?: NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleName") as? String
                ?: ""
        val version =
            NSBundle.mainBundle.objectForInfoDictionaryKey("CFBundleShortVersionString") as String?
                ?: ""

        headers = mutableMapOf(
            "content-type" to "application/json",
            "x-sdk-name" to "NAME",
            "x-sdk-platform" to "",
            "x-sdk-language" to "kmp",
            "x-sdk-version" to "0.0.0",
            "user-agent" to "${appName}/${version} ios",
            "origin" to "appwrite-ios://${appName}",
            "x-appwrite-response-format" to "1.8.0"
        )
    }

    actual fun setSelfSigned(value: Boolean): Client {
        httpClient = createHttpClient(value, iosCookieStorage)
        return this
    }
}
