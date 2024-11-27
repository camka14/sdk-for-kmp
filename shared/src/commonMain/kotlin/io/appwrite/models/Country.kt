package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Country
 */
@Serializable
data class Country(
    /**
     * Country name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Country two-character ISO 3166-1 alpha code.
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
        ) = Country(
            name = map["name"] as String,
            code = map["code"] as String,
        )
    }
}