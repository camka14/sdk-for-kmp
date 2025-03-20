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
 * Token
 */
@Serializable
data class Token(
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
     * Token secret key. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerialName("secret")
    val secret: String,

    /**
     * Token expiration date in ISO 8601 format.
     */
    @SerialName("expire")
    val expire: String,

    /**
     * Security phrase of a token. Empty if security phrase was not requested when creating a token. It includes randomly generated phrase which is also sent in the external resource such as email.
     */
    @SerialName("phrase")
    val phrase: String,

)

