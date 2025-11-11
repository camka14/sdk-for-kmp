package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Metric
 */
@Serializable
data class Metric(
    /**
     * The value of this metric at the timestamp.
     */
    @SerialName("value")
    val value: Long,

    /**
     * The date at which this metric was aggregated in ISO 8601 format.
     */
    @SerialName("date")
    val date: String,

    )

