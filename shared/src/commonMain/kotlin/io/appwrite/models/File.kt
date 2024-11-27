package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


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
    val permissions: List<Any>,

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

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "bucketId" to bucketId as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "\$permissions" to permissions as Any,
        "name" to name as Any,
        "signature" to signature as Any,
        "mimeType" to mimeType as Any,
        "sizeOriginal" to sizeOriginal as Any,
        "chunksTotal" to chunksTotal as Any,
        "chunksUploaded" to chunksUploaded as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = File(
            id = map["\$id"] as String,
            bucketId = map["bucketId"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            permissions = map["\$permissions"] as List<Any>,
            name = map["name"] as String,
            signature = map["signature"] as String,
            mimeType = map["mimeType"] as String,
            sizeOriginal = (map["sizeOriginal"] as Number).toLong(),
            chunksTotal = (map["chunksTotal"] as Number).toLong(),
            chunksUploaded = (map["chunksUploaded"] as Number).toLong(),
        )
    }
}