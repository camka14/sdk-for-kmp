package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Buckets List
 */
@Serializable
data class BucketList(
    /**
     * Total number of buckets that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of buckets.
     */
    @SerialName("buckets")
    val buckets: List<Bucket>,

    )

