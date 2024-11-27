package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Continent
 */
@Serializable
data class Continent(
    /**
     * Continent name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Continent two letter code.
     */
    @SerialName("code")
    val code: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "code" to code as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Continent(
            name = map["name"] as String,
            code = map["code"] as String,
        )
    }
}