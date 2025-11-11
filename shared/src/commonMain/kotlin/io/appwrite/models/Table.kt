package io.appwrite.models

import io.appwrite.extensions.jsonCast
import io.appwrite.extensions.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long
import kotlinx.serialization.json.put

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

