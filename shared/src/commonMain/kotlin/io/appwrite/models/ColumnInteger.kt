package io.appwrite.models

import io.appwrite.enums.ColumnStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ColumnInteger
 */
@Serializable
data class ColumnInteger(
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
     * Minimum value to enforce for new documents.
     */
    @SerialName("min")
    var min: Long?,

    /**
     * Maximum value to enforce for new documents.
     */
    @SerialName("max")
    var max: Long?,

    /**
     * Default value for column when not provided. Cannot be set when column is required.
     */
    @SerialName("default")
    var default: Long?,

    )

