package io.appwrite.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Collection
 */
@Serializable
data class Collection(
    /**
     * Collection ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Collection creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Collection update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Collection permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("\$permissions")
    val permissions: List<String>,

    /**
     * Database ID.
     */
    @SerialName("databaseId")
    val databaseId: String,

    /**
     * Collection name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Collection enabled. Can be &#039;enabled&#039; or &#039;disabled&#039;. When disabled, the collection is inaccessible to users, but remains accessible to Server SDKs using API keys.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Whether document-level permissions are enabled. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("documentSecurity")
    val documentSecurity: Boolean,

    /**
     * Collection attributes.
     */
    @SerialName("attributes")
    val attributes: List<@Contextual Any>,

    /**
     * Collection indexes.
     */
    @SerialName("indexes")
    val indexes: List<Index>,

    )

