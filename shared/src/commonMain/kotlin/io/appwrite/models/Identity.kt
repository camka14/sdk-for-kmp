package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Identity
 */
@Serializable
data class Identity(
    /**
     * Identity ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Identity creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Identity update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * User ID.
     */
    @SerialName("userId")
    val userId: String,

    /**
     * Identity Provider.
     */
    @SerialName("provider")
    val provider: String,

    /**
     * ID of the User in the Identity Provider.
     */
    @SerialName("providerUid")
    val providerUid: String,

    /**
     * Email of the User in the Identity Provider.
     */
    @SerialName("providerEmail")
    val providerEmail: String,

    /**
     * Identity Provider Access Token.
     */
    @SerialName("providerAccessToken")
    val providerAccessToken: String,

    /**
     * The date of when the access token expires in ISO 8601 format.
     */
    @SerialName("providerAccessTokenExpiry")
    val providerAccessTokenExpiry: String,

    /**
     * Identity Provider Refresh Token.
     */
    @SerialName("providerRefreshToken")
    val providerRefreshToken: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "userId" to userId as Any,
        "provider" to provider as Any,
        "providerUid" to providerUid as Any,
        "providerEmail" to providerEmail as Any,
        "providerAccessToken" to providerAccessToken as Any,
        "providerAccessTokenExpiry" to providerAccessTokenExpiry as Any,
        "providerRefreshToken" to providerRefreshToken as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Identity(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            userId = map["userId"] as String,
            provider = map["provider"] as String,
            providerUid = map["providerUid"] as String,
            providerEmail = map["providerEmail"] as String,
            providerAccessToken = map["providerAccessToken"] as String,
            providerAccessTokenExpiry = map["providerAccessTokenExpiry"] as String,
            providerRefreshToken = map["providerRefreshToken"] as String,
        )
    }
}