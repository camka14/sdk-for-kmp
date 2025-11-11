package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Target list
 */
@Serializable
data class TargetList(
    /**
     * Total number of targets that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of targets.
     */
    @SerialName("targets")
    val targets: List<Target>,

    )

