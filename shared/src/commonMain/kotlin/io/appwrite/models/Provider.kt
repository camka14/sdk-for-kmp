package io.appwrite.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Provider
 */
@Serializable
data class Provider(
    /**
     * Provider ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Provider creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Provider update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * The name for the provider instance.
     */
    @SerialName("name")
    val name: String,

    /**
     * The name of the provider service.
     */
    @SerialName("provider")
    val provider: String,

    /**
     * Is provider enabled?
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Type of provider.
     */
    @SerialName("type")
    val type: String,

    /**
     * Provider credentials.
     */
    @SerialName("credentials")
    @Contextual
    val credentials: Any,

    /**
     * Provider options.
     */
    @SerialName("options")
    @Contextual
    var options: Any?,

    )

