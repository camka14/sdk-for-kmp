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
 * Template Framework
 */
@Serializable
data class TemplateFramework(
    /**
     * Parent framework key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Framework Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * The install command used to install the dependencies.
     */
    @SerialName("installCommand")
    val installCommand: String,

    /**
     * The build command used to build the deployment.
     */
    @SerialName("buildCommand")
    val buildCommand: String,

    /**
     * The output directory to store the build output.
     */
    @SerialName("outputDirectory")
    val outputDirectory: String,

    /**
     * Path to site in VCS (Version Control System) repository
     */
    @SerialName("providerRootDirectory")
    val providerRootDirectory: String,

    /**
     * Runtime used during build step of template.
     */
    @SerialName("buildRuntime")
    val buildRuntime: String,

    /**
     * Site framework runtime
     */
    @SerialName("adapter")
    val adapter: String,

    /**
     * Fallback file for SPA. Only relevant for static serve runtime.
     */
    @SerialName("fallbackFile")
    val fallbackFile: String,

)

