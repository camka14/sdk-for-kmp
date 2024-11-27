package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * AlgoScryptModified
 */
@Serializable
data class AlgoScryptModified(
    /**
     * Algo type.
     */
    @SerialName("type")
    val type: String,

    /**
     * Salt used to compute hash.
     */
    @SerialName("salt")
    val salt: String,

    /**
     * Separator used to compute hash.
     */
    @SerialName("saltSeparator")
    val saltSeparator: String,

    /**
     * Key used to compute hash.
     */
    @SerialName("signerKey")
    val signerKey: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "type" to type as Any,
        "salt" to salt as Any,
        "saltSeparator" to saltSeparator as Any,
        "signerKey" to signerKey as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AlgoScryptModified(
            type = map["type"] as String,
            salt = map["salt"] as String,
            saltSeparator = map["saltSeparator"] as String,
            signerKey = map["signerKey"] as String,
        )
    }
}