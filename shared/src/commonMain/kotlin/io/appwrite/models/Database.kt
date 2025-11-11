package io.appwrite.models

import io.appwrite.enums.DatabaseType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Database
 */
@Serializable
data class Database(
    /**
     * Database ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Database name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Database creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Database update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * If database is enabled. Can be &#039;enabled&#039; or &#039;disabled&#039;. When disabled, the database is inaccessible to users, but remains accessible to Server SDKs using API keys.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Database type.
     */
    @SerialName("type")
    val type: DatabaseType,

    )

