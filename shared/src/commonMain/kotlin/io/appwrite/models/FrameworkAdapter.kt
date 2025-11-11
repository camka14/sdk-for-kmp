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
 * Framework Adapter
 */
@Serializable
data class FrameworkAdapter(
    /**
     * Adapter key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Default command to download dependencies.
     */
    @SerialName("installCommand")
    val installCommand: String,

    /**
     * Default command to build site into output directory.
     */
    @SerialName("buildCommand")
    val buildCommand: String,

    /**
     * Default output directory of build.
     */
    @SerialName("outputDirectory")
    val outputDirectory: String,

    /**
     * Name of fallback file to use instead of 404 page. If null, Appwrite 404 page will be displayed.
     */
    @SerialName("fallbackFile")
    val fallbackFile: String,

)

