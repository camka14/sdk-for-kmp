package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * MFAType
 */
@Serializable
data class MfaType(
    /**
     * Secret token used for TOTP factor.
     */
    @SerialName("secret")
    val secret: String,

    /**
     * URI for authenticator apps.
     */
    @SerialName("uri")
    val uri: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "secret" to secret as Any,
        "uri" to uri as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaType(
            secret = map["secret"] as String,
            uri = map["uri"] as String,
        )
    }
}