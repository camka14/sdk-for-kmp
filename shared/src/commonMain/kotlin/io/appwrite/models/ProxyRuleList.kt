package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Rule List
 */
@Serializable
data class ProxyRuleList(
    /**
     * Total number of rules that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of rules.
     */
    @SerialName("rules")
    val rules: List<ProxyRule>,

    )

