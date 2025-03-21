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
 * UsageDatabases
 */
@Serializable
data class UsageDatabases(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of databases.
     */
    @SerialName("databasesTotal")
    val databasesTotal: Long,

    /**
     * Total aggregated number  of collections.
     */
    @SerialName("collectionsTotal")
    val collectionsTotal: Long,

    /**
     * Total aggregated number of documents.
     */
    @SerialName("documentsTotal")
    val documentsTotal: Long,

    /**
     * Total aggregated number of total databases storage in bytes.
     */
    @SerialName("storageTotal")
    val storageTotal: Long,

    /**
     * Total number of databases reads.
     */
    @SerialName("databasesReadsTotal")
    val databasesReadsTotal: Long,

    /**
     * Total number of databases writes.
     */
    @SerialName("databasesWritesTotal")
    val databasesWritesTotal: Long,

    /**
     * Aggregated number of databases per period.
     */
    @SerialName("databases")
    val databases: List<Metric>,

    /**
     * Aggregated number of collections per period.
     */
    @SerialName("collections")
    val collections: List<Metric>,

    /**
     * Aggregated number of documents per period.
     */
    @SerialName("documents")
    val documents: List<Metric>,

    /**
     * An array of the aggregated number of databases storage in bytes per period.
     */
    @SerialName("storage")
    val storage: List<Metric>,

    /**
     * An array of aggregated number of database reads.
     */
    @SerialName("databasesReads")
    val databasesReads: List<Metric>,

    /**
     * An array of aggregated number of database writes.
     */
    @SerialName("databasesWrites")
    val databasesWrites: List<Metric>,

)

