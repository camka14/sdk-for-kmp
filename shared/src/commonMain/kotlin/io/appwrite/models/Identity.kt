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
import kotlinx.serialization.json.long
import kotlinx.serialization.json.put

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

)

