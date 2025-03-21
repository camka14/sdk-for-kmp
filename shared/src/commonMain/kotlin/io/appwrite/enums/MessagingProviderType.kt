package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MessagingProviderType(val value: String) {
    @SerialName("email")
    EMAIL("email"),
    @SerialName("sms")
    SMS("sms"),
    @SerialName("push")
    PUSH("push");

    override fun toString() = value
}
