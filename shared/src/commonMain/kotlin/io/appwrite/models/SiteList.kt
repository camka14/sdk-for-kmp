package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sites List
 */
@Serializable
data class SiteList(
    /**
     * Total number of sites that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of sites.
     */
    @SerialName("sites")
    val sites: List<Site>,

    )

