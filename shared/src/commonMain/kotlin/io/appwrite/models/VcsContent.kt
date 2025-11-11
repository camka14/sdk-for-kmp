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
 * VcsContents
 */
@Serializable
data class VcsContent(
    /**
     * Content size in bytes. Only files have size, and for directories, 0 is returned.
     */
    @SerialName("size")
    var size: Long?,

    /**
     * If a content is a directory. Directories can be used to check nested contents.
     */
    @SerialName("isDirectory")
    var isDirectory: Boolean?,

    /**
     * Name of directory or file.
     */
    @SerialName("name")
    val name: String,

)

