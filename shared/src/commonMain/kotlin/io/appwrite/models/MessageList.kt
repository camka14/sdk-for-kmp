package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Message list
 */
@Serializable
data class MessageList(
    /**
     * Total number of messages that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of messages.
     */
    @SerialName("messages")
    val messages: List<Message>,

    )

