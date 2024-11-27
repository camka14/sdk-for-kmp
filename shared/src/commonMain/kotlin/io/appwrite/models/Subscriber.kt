package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Subscriber
 */
@Serializable
data class Subscriber(
    /**
     * Subscriber ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Subscriber creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Subscriber update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Target ID.
     */
    @SerialName("targetId")
    val targetId: String,

    /**
     * Target.
     */
    @SerialName("target")
    val target: Target,

    /**
     * Topic ID.
     */
    @SerialName("userId")
    val userId: String,

    /**
     * User Name.
     */
    @SerialName("userName")
    val userName: String,

    /**
     * Topic ID.
     */
    @SerialName("topicId")
    val topicId: String,

    /**
     * The target provider type. Can be one of the following: `email`, `sms` or `push`.
     */
    @SerialName("providerType")
    val providerType: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "targetId" to targetId as Any,
        "target" to target.toMap() as Any,
        "userId" to userId as Any,
        "userName" to userName as Any,
        "topicId" to topicId as Any,
        "providerType" to providerType as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Subscriber(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            targetId = map["targetId"] as String,
            target = Target.from(map = map["target"] as Map<String, Any>),
            userId = map["userId"] as String,
            userName = map["userName"] as String,
            topicId = map["topicId"] as String,
            providerType = map["providerType"] as String,
        )
    }
}