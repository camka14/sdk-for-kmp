package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Provider list
 */
@Serializable
data class ProviderList(
    /**
     * Total number of providers that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of providers.
     */
    @SerialName("providers")
    val providers: List<Provider>,

    )

