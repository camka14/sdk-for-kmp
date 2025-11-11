package io.appwrite.models

import io.appwrite.enums.AttributeStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * AttributeString
 */
@Serializable
data class AttributeString(
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
    val status: AttributeStatus,

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
     * Attribute size.
     */
    @SerialName("size")
    val size: Long,

    /**
     * Default value for attribute when not provided. Cannot be set when attribute is required.
     */
    @SerialName("default")
    var default: String?,

    /**
     * Defines whether this attribute is encrypted or not.
     */
    @SerialName("encrypt")
    var encrypt: Boolean?,

    )

