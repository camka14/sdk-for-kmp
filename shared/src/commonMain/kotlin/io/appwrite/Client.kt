package io.appwrite

import kotlin.coroutines.CoroutineContext

expect class Client : BaseClient<Client> {
    fun setSelfSigned(value: Boolean): Client
    override val coroutineContext: CoroutineContext
}
