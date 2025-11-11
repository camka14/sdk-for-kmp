package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Webhooks List
 */
@Serializable
data class WebhookList(
    /**
     * Total number of webhooks that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of webhooks.
     */
    @SerialName("webhooks")
    val webhooks: List<Webhook>,

    )

