package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class MessageStatus(val value: String) {
    @SerialName("draft")
    DRAFT("draft"),
    @SerialName("processing")
    PROCESSING("processing"),
    @SerialName("scheduled")
    SCHEDULED("scheduled"),
    @SerialName("sent")
    SENT("sent"),
    @SerialName("failed")
    FAILED("failed");

    override fun toString() = value
}
