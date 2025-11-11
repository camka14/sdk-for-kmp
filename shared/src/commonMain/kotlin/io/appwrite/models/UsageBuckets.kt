package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * UsageBuckets
 */
@Serializable
data class UsageBuckets(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of bucket files.
     */
    @SerialName("filesTotal")
    val filesTotal: Long,

    /**
     * Total aggregated number of bucket files storage (in bytes).
     */
    @SerialName("filesStorageTotal")
    val filesStorageTotal: Long,

    /**
     * Aggregated  number of bucket files per period.
     */
    @SerialName("files")
    val files: List<Metric>,

    /**
     * Aggregated  number of bucket storage files (in bytes) per period.
     */
    @SerialName("storage")
    val storage: List<Metric>,

    /**
     * Aggregated number of files transformations per period.
     */
    @SerialName("imageTransformations")
    val imageTransformations: List<Metric>,

    /**
     * Total aggregated number of files transformations.
     */
    @SerialName("imageTransformationsTotal")
    val imageTransformationsTotal: Long,

    )

