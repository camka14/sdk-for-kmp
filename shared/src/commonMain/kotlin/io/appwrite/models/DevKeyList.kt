package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Dev Keys List
 */
@Serializable
data class DevKeyList(
    /**
     * Total number of devKeys that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of devKeys.
     */
    @SerialName("devKeys")
    val devKeys: List<DevKey>,

    )

