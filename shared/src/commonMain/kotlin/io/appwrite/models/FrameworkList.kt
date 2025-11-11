package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Frameworks List
 */
@Serializable
data class FrameworkList(
    /**
     * Total number of frameworks that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of frameworks.
     */
    @SerialName("frameworks")
    val frameworks: List<Framework>,

    )

