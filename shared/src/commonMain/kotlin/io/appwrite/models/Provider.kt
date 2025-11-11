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
 * Provider
 */
@Serializable
data class Provider(
    /**
     * Provider ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Provider creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Provider update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * The name for the provider instance.
     */
    @SerialName("name")
    val name: String,

    /**
     * The name of the provider service.
     */
    @SerialName("provider")
    val provider: String,

    /**
     * Is provider enabled?
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Type of provider.
     */
    @SerialName("type")
    val type: String,

    /**
     * Provider credentials.
     */
    @SerialName("credentials")
    @Contextual
    val credentials: Any,

    /**
     * Provider options.
     */
    @SerialName("options")
    @Contextual
    var options: Any?,

)

