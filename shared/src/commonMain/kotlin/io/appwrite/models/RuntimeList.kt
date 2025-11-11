package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Runtimes List
 */
@Serializable
data class RuntimeList(
    /**
     * Total number of runtimes that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of runtimes.
     */
    @SerialName("runtimes")
    val runtimes: List<Runtime>,

    )

