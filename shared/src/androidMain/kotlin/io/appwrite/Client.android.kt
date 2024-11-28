package io.appwrite

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

actual class Client : BaseClient<Client>() {
    override val coroutineContext = Job() + Dispatchers.Default

    actual companion object: PlatformConfiguration {
        private var androidContext: Context? = null

        override fun androidContext(context: Any) {
            androidContext = context as Context
        }

        actual fun create(
            endpoint: String,
            endpointRealtime: String?,
            selfSigned: Boolean
        ): Client {
            checkNotNull(androidContext) { "Android Context must be set using androidContext() before creating client" }
            return Client()
                .setEndpoint(endpoint)
                .setEndpointRealtime(endpointRealtime ?: endpoint)
                .setHttpClient(createHttpClient(
                androidContext!!
            ))
        }
    }
}