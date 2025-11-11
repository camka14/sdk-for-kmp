package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Databases List
 */
@Serializable
data class DatabaseList(
    /**
     * Total number of databases that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of databases.
     */
    @SerialName("databases")
    val databases: List<Database>,

    )

