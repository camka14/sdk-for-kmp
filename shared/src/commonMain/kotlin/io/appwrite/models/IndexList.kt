package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Indexes List
 */
@Serializable
data class IndexList(
    /**
     * Total number of indexes that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of indexes.
     */
    @SerialName("indexes")
    val indexes: List<Index>,

    )

