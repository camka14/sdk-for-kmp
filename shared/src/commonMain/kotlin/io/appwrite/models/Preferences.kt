package io.appwrite.models

import io.appwrite.extensions.jsonCast
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.reflect.KClass

/**
 * Preferences
 */
@Serializable
data class Preferences<T>(
    /**
     * Additional properties
     */
    @SerialName("data")
    val data: T
) {
    fun toMap(): Map<String, Any> = mapOf(
        "data" to data!!.jsonCast(to = Map::class)
    )

    companion object {
        operator fun invoke(
            data: Map<String, Any>
        ) = Preferences<Map<String, Any>>(
            data
        )

        @Suppress("UNCHECKED_CAST")
        fun <T : Any> from(
            map: Map<String, Any>,
            nestedType: KClass<T>
        ) = Preferences<T>(
            data = map.jsonCast(to = nestedType)
        )
    }
}