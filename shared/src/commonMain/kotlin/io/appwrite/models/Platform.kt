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
 * Platform
 */
@Serializable
data class Platform(
    /**
     * Platform ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Platform creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Platform update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Platform name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Platform type. Possible values are: web, flutter-web, flutter-ios, flutter-android, ios, android, and unity.
     */
    @SerialName("type")
    val type: String,

    /**
     * Platform Key. iOS bundle ID or Android package name.  Empty string for other platforms.
     */
    @SerialName("key")
    val key: String,

    /**
     * App store or Google Play store ID.
     */
    @SerialName("store")
    val store: String,

    /**
     * Web app hostname. Empty string for other platforms.
     */
    @SerialName("hostname")
    val hostname: String,

    /**
     * HTTP basic authentication username.
     */
    @SerialName("httpUser")
    val httpUser: String,

    /**
     * HTTP basic authentication password.
     */
    @SerialName("httpPass")
    val httpPass: String,

)

