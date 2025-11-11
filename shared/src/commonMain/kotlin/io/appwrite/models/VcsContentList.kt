package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * VCS Content List
 */
@Serializable
data class VcsContentList(
    /**
     * Total number of contents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of contents.
     */
    @SerialName("contents")
    val contents: List<VcsContent>,

    )

