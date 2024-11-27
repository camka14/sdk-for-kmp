package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * MFA Challenge
 */
@Serializable
data class MfaChallenge(
    /**
     * Token ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Token creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * User ID.
     */
    @SerialName("userId")
    val userId: String,

    /**
     * Token expiration date in ISO 8601 format.
     */
    @SerialName("expire")
    val expire: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "userId" to userId as Any,
        "expire" to expire as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MfaChallenge(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            userId = map["userId"] as String,
            expire = map["expire"] as String,
        )
    }
}