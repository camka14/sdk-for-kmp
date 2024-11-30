package io.appwrite

expect class Client: BaseClient<Client> {
    fun setSelfSigned(value: Boolean): Client
}
