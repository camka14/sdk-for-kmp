package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Identities List
 */
@Serializable
data class IdentityList(
    /**
     * Total number of identities that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of identities.
     */
    @SerialName("identities")
    val identities: List<Identity>,

    )

