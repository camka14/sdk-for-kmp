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
 * Runtime
 */
@Serializable
data class Runtime(
    /**
     * Runtime ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Parent runtime key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Runtime Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Runtime version.
     */
    @SerialName("version")
    val version: String,

    /**
     * Base Docker image used to build the runtime.
     */
    @SerialName("base")
    val base: String,

    /**
     * Image name of Docker Hub.
     */
    @SerialName("image")
    val image: String,

    /**
     * Name of the logo image.
     */
    @SerialName("logo")
    val logo: String,

    /**
     * List of supported architectures.
     */
    @SerialName("supports")
    val supports: List<String>,

)

