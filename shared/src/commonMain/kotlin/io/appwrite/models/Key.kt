package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Key
 */
@Serializable
data class Key(
    /**
     * Key ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Key creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Key update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Key name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Key expiration date in ISO 8601 format.
     */
    @SerialName("expire")
    val expire: String,

    /**
     * Allowed permission scopes.
     */
    @SerialName("scopes")
    val scopes: List<String>,

    /**
     * Secret key.
     */
    @SerialName("secret")
    val secret: String,

    /**
     * Most recent access date in ISO 8601 format. This attribute is only updated again after 24 hours.
     */
    @SerialName("accessedAt")
    val accessedAt: String,

    /**
     * List of SDK user agents that used this key.
     */
    @SerialName("sdks")
    val sdks: List<String>,

    )

