package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

/**
 * Team
 */
@Serializable
data class Team<T>(
    /**
     * Team ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Team creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Team update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Team name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Total number of team members.
     */
    @SerialName("total")
    val total: Long,

    /**
     * Team preferences as a key-value object
     */
    @SerialName("prefs")
    val prefs: Preferences<T>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "total" to total as Any,
        "prefs" to prefs.toMap() as Any,
    )

    companion object {
        operator fun invoke(
            id: String,
            createdAt: String,
            updatedAt: String,
            name: String,
            total: Long,
            prefs: Preferences<Map<String, Any>>,
        ) = Team<Map<String, Any>>(
            id,
            createdAt,
            updatedAt,
            name,
            total,
            prefs,
        )

        @Suppress("UNCHECKED_CAST")
        fun <T : Any> from(
            map: Map<String, Any>,
            nestedType: KClass<T>
        ) = Team(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            total = (map["total"] as Number).toLong(),
            prefs = Preferences.from(map = map["prefs"] as Map<String, Any>, nestedType),
        )
    }
}