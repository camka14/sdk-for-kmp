package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * MFA Recovery Codes
 */
@Serializable
data class MfaRecoveryCodes(
    /**
     * Recovery codes.
     */
    @SerialName("recoveryCodes")
    val recoveryCodes: List<Any>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "recoveryCodes" to recoveryCodes as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaRecoveryCodes(
            recoveryCodes = map["recoveryCodes"] as List<Any>,
        )
    }
}