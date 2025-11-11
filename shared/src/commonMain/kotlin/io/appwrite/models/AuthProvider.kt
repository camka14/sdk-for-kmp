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
 * AuthProvider
 */
@Serializable
data class AuthProvider(
    /**
     * Auth Provider.
     */
    @SerialName("key")
    val key: String,

    /**
     * Auth Provider name.
     */
    @SerialName("name")
    val name: String,

    /**
     * OAuth 2.0 application ID.
     */
    @SerialName("appId")
    val appId: String,

    /**
     * OAuth 2.0 application secret. Might be JSON string if provider requires extra configuration.
     */
    @SerialName("secret")
    val secret: String,

    /**
     * Auth Provider is active and can be used to create session.
     */
    @SerialName("enabled")
    val enabled: Boolean,

)

