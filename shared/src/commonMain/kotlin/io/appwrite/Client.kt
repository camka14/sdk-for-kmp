package io.appwrite

expect class Client: BaseClient<Client> {
    companion object {
        fun create(
            endpoint: String = "https://cloud.appwrite.io/v1",
            endpointRealtime: String? = null,
            selfSigned: Boolean = false
        ): Client
    }
}