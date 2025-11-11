package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Function Templates List
 */
@Serializable
data class TemplateFunctionList(
    /**
     * Total number of templates that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of templates.
     */
    @SerialName("templates")
    val templates: List<TemplateFunction>,

    )

