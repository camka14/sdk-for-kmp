package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Site Templates List
 */
@Serializable
data class TemplateSiteList(
    /**
     * Total number of templates that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of templates.
     */
    @SerialName("templates")
    val templates: List<TemplateSite>,

    )

