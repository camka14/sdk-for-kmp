package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Target
 */
@Serializable
data class Target(
    /**
     * Target ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Target creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Target update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Target Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * User ID.
     */
    @SerialName("userId")
    val userId: String,

    /**
     * Provider ID.
     */
    @SerialName("providerId")
    var providerId: String?,

    /**
     * The target provider type. Can be one of the following: `email`, `sms` or `push`.
     */
    @SerialName("providerType")
    val providerType: String,

    /**
     * The target identifier.
     */
    @SerialName("identifier")
    val identifier: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "name" to name as Any,
        "userId" to userId as Any,
        "providerId" to providerId as Any,
        "providerType" to providerType as Any,
        "identifier" to identifier as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Target(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            name = map["name"] as String,
            userId = map["userId"] as String,
            providerId = map["providerId"] as? String?,
            providerType = map["providerType"] as String,
            identifier = map["identifier"] as String,
        )
    }
}