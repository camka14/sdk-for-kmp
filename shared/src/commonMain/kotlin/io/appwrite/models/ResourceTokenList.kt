package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Resource Tokens List
 */
@Serializable
data class ResourceTokenList(
    /**
     * Total number of tokens that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of tokens.
     */
    @SerialName("tokens")
    val tokens: List<ResourceToken>,

    )

