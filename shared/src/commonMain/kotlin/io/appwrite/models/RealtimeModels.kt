package io.appwrite.models

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
    val channels: kotlin.collections.Collection<String>,
    val payloadClass: KClass<*>,
    val payloadSerializer: KSerializer<*>,
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
    val events: kotlin.collections.Collection<String>,
    @Serializable(with = StringCollectionSerializer::class)
    val channels: kotlin.collections.Collection<String>,
    val timestamp: String,
    var payload: T
)

enum class RealtimeCode(val value: Int) {
    POLICY_VIOLATION(1008),
    NORMAL_CLOSURE(1000),
    UNKNOWN_ERROR(-1)
}
