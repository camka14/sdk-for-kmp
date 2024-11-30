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
    companion object {
        operator fun invoke(
            total: Long,
            teams: List<Team<Map<String, Any>>>,
        ) = TeamList(
            total,
            teams,
        )
    }
}