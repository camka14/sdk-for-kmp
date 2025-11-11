package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * StorageUsage
 */
@Serializable
data class UsageStorage(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of buckets
     */
    @SerialName("bucketsTotal")
    val bucketsTotal: Long,

    /**
     * Total aggregated number of files.
     */
    @SerialName("filesTotal")
    val filesTotal: Long,

    /**
     * Total aggregated number of files storage (in bytes).
     */
    @SerialName("filesStorageTotal")
    val filesStorageTotal: Long,

    /**
     * Aggregated number of buckets per period.
     */
    @SerialName("buckets")
    val buckets: List<Metric>,

    /**
     * Aggregated number of files per period.
     */
    @SerialName("files")
    val files: List<Metric>,

    /**
     * Aggregated number of files storage (in bytes) per period .
     */
    @SerialName("storage")
    val storage: List<Metric>,

    )

