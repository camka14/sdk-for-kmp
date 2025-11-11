package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * UsageTable
 */
@Serializable
data class UsageTable(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of of rows.
     */
    @SerialName("rowsTotal")
    val rowsTotal: Long,

    /**
     * Aggregated  number of rows per period.
     */
    @SerialName("rows")
    val rows: List<Metric>,

    )

