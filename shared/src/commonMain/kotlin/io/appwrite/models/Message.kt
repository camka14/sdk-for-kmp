package io.appwrite.models

import io.appwrite.enums.MessageStatus
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Message
 */
@Serializable
data class Message(
    /**
     * Message ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Message creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Message update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Message provider type.
     */
    @SerialName("providerType")
    val providerType: String,

    /**
     * Topic IDs set as recipients.
     */
    @SerialName("topics")
    val topics: List<String>,

    /**
     * User IDs set as recipients.
     */
    @SerialName("users")
    val users: List<String>,

    /**
     * Target IDs set as recipients.
     */
    @SerialName("targets")
    val targets: List<String>,

    /**
     * The scheduled time for message.
     */
    @SerialName("scheduledAt")
    var scheduledAt: String?,

    /**
     * The time when the message was delivered.
     */
    @SerialName("deliveredAt")
    var deliveredAt: String?,

    /**
     * Delivery errors if any.
     */
    @SerialName("deliveryErrors")
    var deliveryErrors: List<String>?,

    /**
     * Number of recipients the message was delivered to.
     */
    @SerialName("deliveredTotal")
    val deliveredTotal: Long,

    /**
     * Data of the message.
     */
    @SerialName("data")
    @Contextual
    val data: Any,

    /**
     * Status of delivery.
     */
    @SerialName("status")
    val status: MessageStatus,

    )

