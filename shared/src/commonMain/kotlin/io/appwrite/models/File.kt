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
 * File
 */
@Serializable
data class File(
    /**
     * File ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Bucket ID.
     */
    @SerialName("bucketId")
    val bucketId: String,

    /**
     * File creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * File update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * File permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("\$permissions")
    val permissions: List<String>,

    /**
     * File name.
     */
    @SerialName("name")
    val name: String,

    /**
     * File MD5 signature.
     */
    @SerialName("signature")
    val signature: String,

    /**
     * File mime type.
     */
    @SerialName("mimeType")
    val mimeType: String,

    /**
     * File original size in bytes.
     */
    @SerialName("sizeOriginal")
    val sizeOriginal: Long,

    /**
     * Total number of chunks available
     */
    @SerialName("chunksTotal")
    val chunksTotal: Long,

    /**
     * Total number of chunks uploaded
     */
    @SerialName("chunksUploaded")
    val chunksUploaded: Long,

)

