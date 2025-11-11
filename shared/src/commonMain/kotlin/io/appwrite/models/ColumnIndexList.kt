package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Column Indexes List
 */
@Serializable
data class ColumnIndexList(
    /**
     * Total number of indexes that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of indexes.
     */
    @SerialName("indexes")
    val indexes: List<ColumnIndex>,

    )

