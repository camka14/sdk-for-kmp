package io.appwrite.models

import io.appwrite.enums.ColumnStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ColumnEnum
 */
@Serializable
data class ColumnEnum(
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
     * Array of elements in enumerated type.
     */
    @SerialName("elements")
    val elements: List<String>,

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

