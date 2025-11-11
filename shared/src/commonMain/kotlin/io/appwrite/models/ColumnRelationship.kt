package io.appwrite.models

import io.appwrite.enums.ColumnStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ColumnRelationship
 */
@Serializable
data class ColumnRelationship(
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
     * The ID of the related table.
     */
    @SerialName("relatedTable")
    val relatedTable: String,

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

