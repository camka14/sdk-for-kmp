package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Health Time
 */
@Serializable
data class HealthTime(
    /**
     * Current unix timestamp on trustful remote server.
     */
    @SerialName("remoteTime")
    val remoteTime: Long,

    /**
     * Current unix timestamp of local server where Appwrite runs.
     */
    @SerialName("localTime")
    val localTime: Long,

    /**
     * Difference of unix remote and local timestamps in milliseconds.
     */
    @SerialName("diff")
    val diff: Long,

    )

