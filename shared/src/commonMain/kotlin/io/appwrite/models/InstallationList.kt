package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Installations List
 */
@Serializable
data class InstallationList(
    /**
     * Total number of installations that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of installations.
     */
    @SerialName("installations")
    val installations: List<Installation>,

    )

