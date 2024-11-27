package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass


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
    val documents: List<Document<T>>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "documents" to documents.map { it.toMap() } as Any,
    )

    companion object {
        operator fun invoke(
            total: Long,
            documents: List<Document<Map<String, Any>>>,
        ) = DocumentList<Map<String, Any>>(
            total,
            documents,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T : Any> from(
            map: Map<String, Any>,
            nestedType: KClass<T>
        ) = DocumentList<T>(
            total = (map["total"] as Number).toLong(),
            documents = (map["documents"] as List<Map<String, Any>>).map { Document.from(map = it, nestedType) },
        )
    }
}