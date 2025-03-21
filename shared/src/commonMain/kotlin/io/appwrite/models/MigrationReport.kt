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
 * Migration Report
 */
@Serializable
data class MigrationReport(
    /**
     * Number of users to be migrated.
     */
    @SerialName("user")
    val user: Long,

    /**
     * Number of teams to be migrated.
     */
    @SerialName("team")
    val team: Long,

    /**
     * Number of databases to be migrated.
     */
    @SerialName("database")
    val database: Long,

    /**
     * Number of documents to be migrated.
     */
    @SerialName("document")
    val document: Long,

    /**
     * Number of files to be migrated.
     */
    @SerialName("file")
    val file: Long,

    /**
     * Number of buckets to be migrated.
     */
    @SerialName("bucket")
    val bucket: Long,

    /**
     * Number of functions to be migrated.
     */
    @SerialName("function")
    val function: Long,

    /**
     * Size of files to be migrated in mb.
     */
    @SerialName("size")
    val size: Long,

    /**
     * Version of the Appwrite instance to be migrated.
     */
    @SerialName("version")
    val version: String,

)

