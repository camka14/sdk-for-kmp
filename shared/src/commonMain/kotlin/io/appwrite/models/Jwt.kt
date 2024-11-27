package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * JWT
 */
@Serializable
data class Jwt(
    /**
     * JWT encoded string.
     */
    @SerialName("jwt")
    val jwt: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "jwt" to jwt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Jwt(
            jwt = map["jwt"] as String,
        )
    }
}