package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Sessions List
 */
@Serializable
data class SessionList(
    /**
     * Total number of sessions documents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of sessions.
     */
    @SerialName("sessions")
    val sessions: List<Session>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "sessions" to sessions.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = SessionList(
            total = (map["total"] as Number).toLong(),
            sessions = (map["sessions"] as List<Map<String, Any>>).map { Session.from(map = it) },
        )
    }
}