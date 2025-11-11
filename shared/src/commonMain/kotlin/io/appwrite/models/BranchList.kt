package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Branches List
 */
@Serializable
data class BranchList(
    /**
     * Total number of branches that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of branches.
     */
    @SerialName("branches")
    val branches: List<Branch>,

    )

