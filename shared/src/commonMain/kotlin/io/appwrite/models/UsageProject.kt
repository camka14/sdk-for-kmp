package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * UsageProject
 */
@Serializable
data class UsageProject(
    /**
     * Total aggregated number of function executions.
     */
    @SerialName("executionsTotal")
    val executionsTotal: Long,

    /**
     * Total aggregated  number of documents.
     */
    @SerialName("documentsTotal")
    val documentsTotal: Long,

    /**
     * Total aggregated  number of rows.
     */
    @SerialName("rowsTotal")
    val rowsTotal: Long,

    /**
     * Total aggregated number of databases.
     */
    @SerialName("databasesTotal")
    val databasesTotal: Long,

    /**
     * Total aggregated sum of databases storage size (in bytes).
     */
    @SerialName("databasesStorageTotal")
    val databasesStorageTotal: Long,

    /**
     * Total aggregated number of users.
     */
    @SerialName("usersTotal")
    val usersTotal: Long,

    /**
     * Total aggregated sum of files storage size (in bytes).
     */
    @SerialName("filesStorageTotal")
    val filesStorageTotal: Long,

    /**
     * Total aggregated sum of functions storage size (in bytes).
     */
    @SerialName("functionsStorageTotal")
    val functionsStorageTotal: Long,

    /**
     * Total aggregated sum of builds storage size (in bytes).
     */
    @SerialName("buildsStorageTotal")
    val buildsStorageTotal: Long,

    /**
     * Total aggregated sum of deployments storage size (in bytes).
     */
    @SerialName("deploymentsStorageTotal")
    val deploymentsStorageTotal: Long,

    /**
     * Total aggregated number of buckets.
     */
    @SerialName("bucketsTotal")
    val bucketsTotal: Long,

    /**
     * Total aggregated number of function executions mbSeconds.
     */
    @SerialName("executionsMbSecondsTotal")
    val executionsMbSecondsTotal: Long,

    /**
     * Total aggregated number of function builds mbSeconds.
     */
    @SerialName("buildsMbSecondsTotal")
    val buildsMbSecondsTotal: Long,

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
     * Aggregated  number of requests per period.
     */
    @SerialName("requests")
    val requests: List<Metric>,

    /**
     * Aggregated number of consumed bandwidth per period.
     */
    @SerialName("network")
    val network: List<Metric>,

    /**
     * Aggregated number of users per period.
     */
    @SerialName("users")
    val users: List<Metric>,

    /**
     * Aggregated number of executions per period.
     */
    @SerialName("executions")
    val executions: List<Metric>,

    /**
     * Aggregated breakdown in totals of executions by functions.
     */
    @SerialName("executionsBreakdown")
    val executionsBreakdown: List<MetricBreakdown>,

    /**
     * Aggregated breakdown in totals of usage by buckets.
     */
    @SerialName("bucketsBreakdown")
    val bucketsBreakdown: List<MetricBreakdown>,

    /**
     * An array of the aggregated breakdown of storage usage by databases.
     */
    @SerialName("databasesStorageBreakdown")
    val databasesStorageBreakdown: List<MetricBreakdown>,

    /**
     * Aggregated breakdown in totals of execution mbSeconds by functions.
     */
    @SerialName("executionsMbSecondsBreakdown")
    val executionsMbSecondsBreakdown: List<MetricBreakdown>,

    /**
     * Aggregated breakdown in totals of build mbSeconds by functions.
     */
    @SerialName("buildsMbSecondsBreakdown")
    val buildsMbSecondsBreakdown: List<MetricBreakdown>,

    /**
     * Aggregated breakdown in totals of functions storage size (in bytes).
     */
    @SerialName("functionsStorageBreakdown")
    val functionsStorageBreakdown: List<MetricBreakdown>,

    /**
     * Total aggregated number of phone auth.
     */
    @SerialName("authPhoneTotal")
    val authPhoneTotal: Long,

    /**
     * Estimated total aggregated cost of phone auth.
     */
    @SerialName("authPhoneEstimate")
    val authPhoneEstimate: Double,

    /**
     * Aggregated breakdown in totals of phone auth by country.
     */
    @SerialName("authPhoneCountryBreakdown")
    val authPhoneCountryBreakdown: List<MetricBreakdown>,

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

    /**
     * An array of aggregated number of image transformations.
     */
    @SerialName("imageTransformations")
    val imageTransformations: List<Metric>,

    /**
     * Total aggregated number of image transformations.
     */
    @SerialName("imageTransformationsTotal")
    val imageTransformationsTotal: Long,

    )

