package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Webhook
 */
@Serializable
data class Webhook(
    /**
     * Webhook ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Webhook creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Webhook update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Webhook name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Webhook URL endpoint.
     */
    @SerialName("url")
    val url: String,

    /**
     * Webhook trigger events.
     */
    @SerialName("events")
    val events: List<String>,

    /**
     * Indicated if SSL / TLS Certificate verification is enabled.
     */
    @SerialName("security")
    val security: Boolean,

    /**
     * HTTP basic authentication username.
     */
    @SerialName("httpUser")
    val httpUser: String,

    /**
     * HTTP basic authentication password.
     */
    @SerialName("httpPass")
    val httpPass: String,

    /**
     * Signature key which can be used to validated incoming
     */
    @SerialName("signatureKey")
    val signatureKey: String,

    /**
     * Indicates if this webhook is enabled.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Webhook error logs from the most recent failure.
     */
    @SerialName("logs")
    val logs: String,

    /**
     * Number of consecutive failed webhook attempts.
     */
    @SerialName("attempts")
    val attempts: Long,

    )

