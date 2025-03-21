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
 * EmailTemplate
 */
@Serializable
data class EmailTemplate(
    /**
     * Template type
     */
    @SerialName("type")
    val type: String,

    /**
     * Template locale
     */
    @SerialName("locale")
    val locale: String,

    /**
     * Template message
     */
    @SerialName("message")
    val message: String,

    /**
     * Name of the sender
     */
    @SerialName("senderName")
    val senderName: String,

    /**
     * Email of the sender
     */
    @SerialName("senderEmail")
    val senderEmail: String,

    /**
     * Reply to email address
     */
    @SerialName("replyTo")
    val replyTo: String,

    /**
     * Email subject
     */
    @SerialName("subject")
    val subject: String,

)

