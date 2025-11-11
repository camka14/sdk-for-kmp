package io.appwrite.models

import io.appwrite.extensions.jsonCast
import io.appwrite.extensions.json
import io.appwrite.enums.ColumnStatus
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
 * ColumnEmail
 */
@Serializable
data class ColumnEmail(
    /**
     * Column Key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Column type.
     */
    @SerialName("type")
    val type: String,

    /**
     * Column status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     */
    @SerialName("status")
    val status: ColumnStatus,

    /**
     * Error message. Displays error generated on failure of creating or deleting an column.
     */
    @SerialName("error")
    val error: String,

    /**
     * Is column required?
     */
    @SerialName("required")
    val required: Boolean,

    /**
     * Is column an array?
     */
    @SerialName("array")
    var array: Boolean?,

    /**
     * Column creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Column update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * String format.
     */
    @SerialName("format")
    val format: String,

    /**
     * Default value for column when not provided. Cannot be set when column is required.
     */
    @SerialName("default")
    var default: String?,

)

