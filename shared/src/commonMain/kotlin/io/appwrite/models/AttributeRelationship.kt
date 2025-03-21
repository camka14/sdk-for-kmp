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
import kotlinx.serialization.json.put

/**
 * AttributeRelationship
 */
@Serializable
data class AttributeRelationship(
    /**
     * Attribute Key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Attribute type.
     */
    @SerialName("type")
    val type: String,

    /**
     * Attribute status. Possible values: `available`, `processing`, `deleting`, `stuck`, or `failed`
     */
    @SerialName("status")
    val status: String,

    /**
     * Error message. Displays error generated on failure of creating or deleting an attribute.
     */
    @SerialName("error")
    val error: String,

    /**
     * Is attribute required?
     */
    @SerialName("required")
    val required: Boolean,

    /**
     * Is attribute an array?
     */
    @SerialName("array")
    var array: Boolean?,

    /**
     * Attribute creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Attribute update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * The ID of the related collection.
     */
    @SerialName("relatedCollection")
    val relatedCollection: String,

    /**
     * The type of the relationship.
     */
    @SerialName("relationType")
    val relationType: String,

    /**
     * Is the relationship two-way?
     */
    @SerialName("twoWay")
    val twoWay: Boolean,

    /**
     * The key of the two-way relationship.
     */
    @SerialName("twoWayKey")
    val twoWayKey: String,

    /**
     * How deleting the parent document will propagate to child documents.
     */
    @SerialName("onDelete")
    val onDelete: String,

    /**
     * Whether this is the parent or child side of the relationship
     */
    @SerialName("side")
    val side: String,

)

