package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Deployments List
 */
@Serializable
data class DeploymentList(
    /**
     * Total number of deployments that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of deployments.
     */
    @SerialName("deployments")
    val deployments: List<Deployment>,

    )

