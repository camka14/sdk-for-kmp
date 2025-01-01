package io.appwrite.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Documents List
 */
@Serializable
data class DocumentList<T>(
    /**
     * Total number of documents documents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of documents.
     */
    @SerialName("documents")
    @Contextual
    val documents: List<Document<T>>,
) {
    companion object {
        operator fun <T> invoke(
            total: Long,
            documents: List<Document<T>>
        ) = DocumentList(
            total,
            documents
        )
    }
}
