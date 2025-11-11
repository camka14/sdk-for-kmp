package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
     * Total aggregated number of tables.
     */
    @SerialName("tablesTotal")
    val tablesTotal: Long,

    /**
     * Total aggregated number of documents.
     */
    @SerialName("documentsTotal")
    val documentsTotal: Long,

    /**
     * Total aggregated number of rows.
     */
    @SerialName("rowsTotal")
    val rowsTotal: Long,

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
     * Aggregated  number of tables per period.
     */
    @SerialName("tables")
    val tables: List<Metric>,

    /**
     * Aggregated  number of documents per period.
     */
    @SerialName("documents")
    val documents: List<Metric>,

    /**
     * Aggregated  number of rows per period.
     */
    @SerialName("rows")
    val rows: List<Metric>,

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

