package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Framework Provider Repositories List
 */
@Serializable
data class ProviderRepositoryFrameworkList(
    /**
     * Total number of frameworkProviderRepositories that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of frameworkProviderRepositories.
     */
    @SerialName("frameworkProviderRepositories")
    val frameworkProviderRepositories: List<ProviderRepositoryFramework>,

    )

