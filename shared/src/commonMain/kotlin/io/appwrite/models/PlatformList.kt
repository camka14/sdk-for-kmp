package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Platforms List
 */
@Serializable
data class PlatformList(
    /**
     * Total number of platforms that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of platforms.
     */
    @SerialName("platforms")
    val platforms: List<Platform>,

    )

