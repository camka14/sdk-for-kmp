package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

/**
 * Teams List
 */
@Serializable
data class TeamList<T>(
    /**
     * Total number of teams documents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of teams.
     */
    @SerialName("teams")
    val teams: List<Team<T>>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "teams" to teams.map { it.toMap() } as Any,
    )

    companion object {
        operator fun invoke(
            total: Long,
            teams: List<Team<Map<String, Any>>>,
        ) = TeamList<Map<String, Any>>(
            total,
            teams,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T : Any> from(
            map: Map<String, Any>,
            nestedType: KClass<T>
        ) = TeamList<T>(
            total = (map["total"] as Number).toLong(),
            teams = (map["teams"] as List<Map<String, Any>>).map { Team.from(map = it, nestedType) },
        )
    }
}