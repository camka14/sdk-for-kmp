package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Collections List
 */
@Serializable
data class CollectionList(
    /**
     * Total number of collections that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of collections.
     */
    @SerialName("collections")
    val collections: List<Collection>,

    )

