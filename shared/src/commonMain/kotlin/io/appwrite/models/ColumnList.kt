package io.appwrite.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Columns List
 */
@Serializable
data class ColumnList(
    /**
     * Total number of columns in the given table.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of columns.
     */
    @SerialName("columns")
    val columns: List<@Contextual Any>,

    )

