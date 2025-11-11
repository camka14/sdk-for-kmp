package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Topic list
 */
@Serializable
data class TopicList(
    /**
     * Total number of topics that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of topics.
     */
    @SerialName("topics")
    val topics: List<Topic>,

    )

