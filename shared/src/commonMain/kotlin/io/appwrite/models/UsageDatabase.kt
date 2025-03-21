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
 * UsageDatabase
 */
@Serializable
data class UsageDatabase(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of collections.
     */
    @SerialName("collectionsTotal")
    val collectionsTotal: Long,

    /**
     * Total aggregated number of documents.
     */
    @SerialName("documentsTotal")
    val documentsTotal: Long,

    /**
     * Total aggregated number of total storage used in bytes.
     */
    @SerialName("storageTotal")
    val storageTotal: Long,

    /**
     * Total number of databases reads.
     */
    @SerialName("databaseReadsTotal")
    val databaseReadsTotal: Long,

    /**
     * Total number of databases writes.
     */
    @SerialName("databaseWritesTotal")
    val databaseWritesTotal: Long,

    /**
     * Aggregated  number of collections per period.
     */
    @SerialName("collections")
    val collections: List<Metric>,

    /**
     * Aggregated  number of documents per period.
     */
    @SerialName("documents")
    val documents: List<Metric>,

    /**
     * Aggregated storage used in bytes per period.
     */
    @SerialName("storage")
    val storage: List<Metric>,

    /**
     * An array of aggregated number of database reads.
     */
    @SerialName("databaseReads")
    val databaseReads: List<Metric>,

    /**
     * An array of aggregated number of database writes.
     */
    @SerialName("databaseWrites")
    val databaseWrites: List<Metric>,

)

