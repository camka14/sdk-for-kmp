package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Specifications List
 */
@Serializable
data class SpecificationList(
    /**
     * Total number of specifications that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of specifications.
     */
    @SerialName("specifications")
    val specifications: List<Specification>,

    )

