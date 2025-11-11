package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MessagePriority(val value: String) {
    @SerialName("normal")
    NORMAL("normal"),

    @SerialName("high")
    HIGH("high");

    override fun toString() = value
}
