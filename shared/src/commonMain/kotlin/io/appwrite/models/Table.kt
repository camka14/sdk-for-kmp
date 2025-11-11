package io.appwrite.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Table
 */
@Serializable
data class Table(
    /**
     * Table ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Table creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Table update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Table permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("\$permissions")
    val permissions: List<String>,

    /**
     * Database ID.
     */
    @SerialName("databaseId")
    val databaseId: String,

    /**
     * Table name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Table enabled. Can be &#039;enabled&#039; or &#039;disabled&#039;. When disabled, the table is inaccessible to users, but remains accessible to Server SDKs using API keys.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Whether row-level permissions are enabled. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("rowSecurity")
    val rowSecurity: Boolean,

    /**
     * Table columns.
     */
    @SerialName("columns")
    val columns: List<@Contextual Any>,

    /**
     * Table indexes.
     */
    @SerialName("indexes")
    val indexes: List<ColumnIndex>,

    )

