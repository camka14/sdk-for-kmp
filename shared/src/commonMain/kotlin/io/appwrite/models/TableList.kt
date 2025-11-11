package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Tables List
 */
@Serializable
data class TableList(
    /**
     * Total number of tables that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of tables.
     */
    @SerialName("tables")
    val tables: List<Table>,

    )

