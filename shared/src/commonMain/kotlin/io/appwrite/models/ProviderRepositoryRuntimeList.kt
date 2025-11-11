package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Runtime Provider Repositories List
 */
@Serializable
data class ProviderRepositoryRuntimeList(
    /**
     * Total number of runtimeProviderRepositories that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of runtimeProviderRepositories.
     */
    @SerialName("runtimeProviderRepositories")
    val runtimeProviderRepositories: List<ProviderRepositoryRuntime>,

    )

