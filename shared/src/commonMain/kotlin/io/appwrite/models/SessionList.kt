package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sessions List
 */
@Serializable
data class SessionList(
    /**
     * Total number of sessions that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of sessions.
     */
    @SerialName("sessions")
    val sessions: List<Session>,

    )

