package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Subscriber list
 */
@Serializable
data class SubscriberList(
    /**
     * Total number of subscribers that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of subscribers.
     */
    @SerialName("subscribers")
    val subscribers: List<Subscriber>,

    )

