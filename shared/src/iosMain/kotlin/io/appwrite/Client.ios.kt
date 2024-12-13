package io.appwrite

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

    init {
        httpClient = createHttpClient(selfSigned)
        headers = mutableMapOf(
            "content-type" to "application/json",
            "x-sdk-name" to "Apple",
            "x-sdk-platform" to "client",
            "x-sdk-language" to "apple",
            "x-sdk-version" to "7.0.0",
            "x-appwrite-response-format" to "1.6.0",
            "origin" to "appwrite-ios://$bundleId",
            "user-agent" to "$bundleId/$appVersion ${UIDevice.currentDevice.systemName()} ${UIDevice.currentDevice.systemVersion}"
        )
    }

    actual fun setSelfSigned(value: Boolean): Client {
        httpClient = createHttpClient(value)
        return this
    }
}
