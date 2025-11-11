package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * API Keys List
 */
@Serializable
data class KeyList(
    /**
     * Total number of keys that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of keys.
     */
    @SerialName("keys")
    val keys: List<Key>,

    )

