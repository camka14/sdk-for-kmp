package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Topic
 */
@Serializable
data class Topic(
    /**
     * Topic ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Topic creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Topic update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * The name of the topic.
     */
    @SerialName("name")
    val name: String,

    /**
     * Total count of email subscribers subscribed to the topic.
     */
    @SerialName("emailTotal")
    val emailTotal: Long,

    /**
     * Total count of SMS subscribers subscribed to the topic.
     */
    @SerialName("smsTotal")
    val smsTotal: Long,

    /**
     * Total count of push subscribers subscribed to the topic.
     */
    @SerialName("pushTotal")
    val pushTotal: Long,

    /**
     * Subscribe permissions.
     */
    @SerialName("subscribe")
    val subscribe: List<String>,

    )

