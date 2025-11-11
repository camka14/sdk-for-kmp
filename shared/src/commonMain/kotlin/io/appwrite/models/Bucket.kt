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
 * Bucket
 */
@Serializable
data class Bucket(
    /**
     * Bucket ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Bucket creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Bucket update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Bucket permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("\$permissions")
    val permissions: List<String>,

    /**
     * Whether file-level security is enabled. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("fileSecurity")
    val fileSecurity: Boolean,

    /**
     * Bucket name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Bucket enabled.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Maximum file size supported.
     */
    @SerialName("maximumFileSize")
    val maximumFileSize: Long,

    /**
     * Allowed file extensions.
     */
    @SerialName("allowedFileExtensions")
    val allowedFileExtensions: List<String>,

    /**
     * Compression algorithm choosen for compression. Will be one of none, [gzip](https://en.wikipedia.org/wiki/Gzip), or [zstd](https://en.wikipedia.org/wiki/Zstd).
     */
    @SerialName("compression")
    val compression: String,

    /**
     * Bucket is encrypted.
     */
    @SerialName("encryption")
    val encryption: Boolean,

    /**
     * Virus scanning is enabled.
     */
    @SerialName("antivirus")
    val antivirus: Boolean,

)

