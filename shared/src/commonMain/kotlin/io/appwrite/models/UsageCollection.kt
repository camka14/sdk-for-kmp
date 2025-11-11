package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * UsageCollection
 */
@Serializable
data class UsageCollection(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of of documents.
     */
    @SerialName("documentsTotal")
    val documentsTotal: Long,

    /**
     * Aggregated  number of documents per period.
     */
    @SerialName("documents")
    val documents: List<Metric>,

    )

