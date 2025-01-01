package io.appwrite.models

import io.appwrite.serializers.DocumentSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Document
 */
@Serializable(with = DocumentSerializer::class)
data class Document<T>(
    /**
     * Document ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Collection ID.
     */
    @SerialName("\$collectionId")
    val collectionId: String,

    /**
     * Database ID.
     */
    @SerialName("\$databaseId")
    val databaseId: String,

    /**
     * Document creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Document update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Document permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("\$permissions")
    val permissions: List<@Contextual Any>,

    /**
     * Additional properties
     */
    @SerialName("data")
    val data: T
) {
    companion object {
        operator fun invoke(
            id: String,
            collectionId: String,
            databaseId: String,
            createdAt: String,
            updatedAt: String,
            permissions: List<Any>,
            data: Map<String, Any>
        ) = Document(
            id,
            collectionId,
            databaseId,
            createdAt,
            updatedAt,
            permissions,
            data
        )
    }
}