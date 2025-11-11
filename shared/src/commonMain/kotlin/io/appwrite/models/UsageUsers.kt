package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * UsageUsers
 */
@Serializable
data class UsageUsers(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of statistics of users.
     */
    @SerialName("usersTotal")
    val usersTotal: Long,

    /**
     * Total aggregated number of active sessions.
     */
    @SerialName("sessionsTotal")
    val sessionsTotal: Long,

    /**
     * Aggregated number of users per period.
     */
    @SerialName("users")
    val users: List<Metric>,

    /**
     * Aggregated number of active sessions  per period.
     */
    @SerialName("sessions")
    val sessions: List<Metric>,

    )

