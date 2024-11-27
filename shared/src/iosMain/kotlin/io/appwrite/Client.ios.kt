package io.appwrite

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

actual class Client private constructor() : BaseClient<Client>() {
    override val coroutineContext = Job() + Dispatchers.Default

    actual companion object : PlatformConfiguration {
        override fun androidContext(context: Any) {
            // No-op on iOS
        }

        actual fun create(
            endpoint: String,
            endpointRealtime: String?,
            selfSigned: Boolean
        ): Client {
            return Client()
                .setEndpoint(endpoint)
                .setEndpointRealtime(endpointRealtime ?: endpoint)
                .setHttpClient(createHttpClient())
        }
    }
}