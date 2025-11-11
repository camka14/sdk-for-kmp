package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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
     * Total aggregated number  of tables.
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
     * Aggregated number of tables per period.
     */
    @SerialName("tables")
    val tables: List<Metric>,

    /**
     * Aggregated number of documents per period.
     */
    @SerialName("documents")
    val documents: List<Metric>,

    /**
     * Aggregated number of rows per period.
     */
    @SerialName("rows")
    val rows: List<Metric>,

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

