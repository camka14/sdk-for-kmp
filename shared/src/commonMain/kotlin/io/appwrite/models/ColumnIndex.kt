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
 * Index
 */
@Serializable
data class ColumnIndex(
    /**
     * Index ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Index creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Index update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Index Key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Index type.
     */
    @SerialName("type")
    val type: String,

    /**
     * Index status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     */
    @SerialName("status")
    val status: String,

    /**
     * Error message. Displays error generated on failure of creating or deleting an index.
     */
    @SerialName("error")
    val error: String,

    /**
     * Index columns.
     */
    @SerialName("columns")
    val columns: List<String>,

    /**
     * Index columns length.
     */
    @SerialName("lengths")
    val lengths: List<Long>,

    /**
     * Index orders.
     */
    @SerialName("orders")
    var orders: List<String>?,

)

