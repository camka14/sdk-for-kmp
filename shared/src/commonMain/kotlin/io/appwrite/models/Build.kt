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
 * Build
 */
@Serializable
data class Build(
    /**
     * Build ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * The deployment that created this build.
     */
    @SerialName("deploymentId")
    val deploymentId: String,

    /**
     * The build status. There are a few different types and each one means something different. \nFailed - The deployment build has failed. More details can usually be found in buildStderr\nReady - The deployment build was successful and the deployment is ready to be deployed\nProcessing - The deployment is currently waiting to have a build triggered\nBuilding - The deployment is currently being built
     */
    @SerialName("status")
    val status: String,

    /**
     * The stdout of the build.
     */
    @SerialName("stdout")
    val stdout: String,

    /**
     * The stderr of the build.
     */
    @SerialName("stderr")
    val stderr: String,

    /**
     * The deployment creation date in ISO 8601 format.
     */
    @SerialName("startTime")
    val startTime: String,

    /**
     * The time the build was finished in ISO 8601 format.
     */
    @SerialName("endTime")
    val endTime: String,

    /**
     * The build duration in seconds.
     */
    @SerialName("duration")
    val duration: Long,

    /**
     * The code size in bytes.
     */
    @SerialName("size")
    val size: Long,

)

