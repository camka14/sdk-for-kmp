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
 * Topic
 */
@Serializable
data class Topic(
    /**
     * Topic ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Topic creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Topic update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * The name of the topic.
     */
    @SerialName("name")
    val name: String,

    /**
     * Total count of email subscribers subscribed to the topic.
     */
    @SerialName("emailTotal")
    val emailTotal: Long,

    /**
     * Total count of SMS subscribers subscribed to the topic.
     */
    @SerialName("smsTotal")
    val smsTotal: Long,

    /**
     * Total count of push subscribers subscribed to the topic.
     */
    @SerialName("pushTotal")
    val pushTotal: Long,

    /**
     * Subscribe permissions.
     */
    @SerialName("subscribe")
    val subscribe: List<String>,

)

