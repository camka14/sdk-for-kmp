package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Language
 */
@Serializable
data class Language(
    /**
     * Language name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Language two-character ISO 639-1 codes.
     */
    @SerialName("code")
    val code: String,

    /**
     * Language native name.
     */
    @SerialName("nativeName")
    val nativeName: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "name" to name as Any,
        "code" to code as Any,
        "nativeName" to nativeName as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Language(
            name = map["name"] as String,
            code = map["code"] as String,
            nativeName = map["nativeName"] as String,
        )
    }
}