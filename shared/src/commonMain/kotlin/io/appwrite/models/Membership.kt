package io.appwrite.models

import io.appwrite.extensions.jsonCast
import io.appwrite.extensions.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put

/**
 * Membership
 */
@Serializable
data class Membership(
    /**
     * Membership ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Membership creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Membership update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * User ID.
     */
    @SerialName("userId")
    val userId: String,

    /**
     * User name. Hide this attribute by toggling membership privacy in the Console.
     */
    @SerialName("userName")
    val userName: String,

    /**
     * User email address. Hide this attribute by toggling membership privacy in the Console.
     */
    @SerialName("userEmail")
    val userEmail: String,

    /**
     * Team ID.
     */
    @SerialName("teamId")
    val teamId: String,

    /**
     * Team name.
     */
    @SerialName("teamName")
    val teamName: String,

    /**
     * Date, the user has been invited to join the team in ISO 8601 format.
     */
    @SerialName("invited")
    val invited: String,

    /**
     * Date, the user has accepted the invitation to join the team in ISO 8601 format.
     */
    @SerialName("joined")
    val joined: String,

    /**
     * User confirmation status, true if the user has joined the team or false otherwise.
     */
    @SerialName("confirm")
    val confirm: Boolean,

    /**
     * Multi factor authentication status, true if the user has MFA enabled or false otherwise. Hide this attribute by toggling membership privacy in the Console.
     */
    @SerialName("mfa")
    val mfa: Boolean,

    /**
     * User list of roles
     */
    @SerialName("roles")
    val roles: List<String>,

)

