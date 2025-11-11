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
 * DetectionFramework
 */
@Serializable
data class DetectionFramework(
    /**
     * Framework
     */
    @SerialName("framework")
    val framework: String,

    /**
     * Site Install Command
     */
    @SerialName("installCommand")
    val installCommand: String,

    /**
     * Site Build Command
     */
    @SerialName("buildCommand")
    val buildCommand: String,

    /**
     * Site Output Directory
     */
    @SerialName("outputDirectory")
    val outputDirectory: String,

)

