package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Metric Breakdown
 */
@Serializable
data class MetricBreakdown(
    /**
     * Resource ID.
     */
    @SerialName("resourceId")
    var resourceId: String?,

    /**
     * Resource name.
     */
    @SerialName("name")
    val name: String,

    /**
     * The value of this metric at the timestamp.
     */
    @SerialName("value")
    val value: Long,

    /**
     * The estimated value of this metric at the end of the period.
     */
    @SerialName("estimate")
    var estimate: Double?,

    )

