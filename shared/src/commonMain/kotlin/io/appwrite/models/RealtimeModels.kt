package io.appwrite.models

import io.appwrite.serializers.DocumentSerializer
import io.appwrite.serializers.StringCollectionSerializer
import io.ktor.utils.io.core.Closeable
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

data class RealtimeSubscription(
    private val close: () -> Unit
) : Closeable {
    override fun close() = close.invoke()
}

data class RealtimeCallback(
    val channels: Collection<String>,
    val payloadClass: KClass<*>,
    val payloadSerializer: KSerializer<*>? = null,
    val callback: (RealtimeResponseEvent<*>) -> Unit
)

@Serializable
open class RealtimeResponse(
    val type: String,
    @Contextual
    val data: Any
)

@Serializable
data class RealtimeResponseEvent<T>(
    @Serializable(with = StringCollectionSerializer::class)
    val events: Collection<String>,
    @Serializable(with = StringCollectionSerializer::class)
    val channels: Collection<String>,
    val timestamp: String,
    @Serializable(with = DocumentSerializer::class)
    var payload: Document<T>
)

enum class RealtimeCode(val value: Int) {
    POLICY_VIOLATION(1008),
    NORMAL_CLOSURE(1000),
    UNKNOWN_ERROR(-1)
}