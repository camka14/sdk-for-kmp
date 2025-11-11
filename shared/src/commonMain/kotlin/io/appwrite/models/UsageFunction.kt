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
 * UsageFunction
 */
@Serializable
data class UsageFunction(
    /**
     * The time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of function deployments.
     */
    @SerialName("deploymentsTotal")
    val deploymentsTotal: Long,

    /**
     * Total aggregated sum of function deployments storage.
     */
    @SerialName("deploymentsStorageTotal")
    val deploymentsStorageTotal: Long,

    /**
     * Total aggregated number of function builds.
     */
    @SerialName("buildsTotal")
    val buildsTotal: Long,

    /**
     * Total aggregated number of successful function builds.
     */
    @SerialName("buildsSuccessTotal")
    val buildsSuccessTotal: Long,

    /**
     * Total aggregated number of failed function builds.
     */
    @SerialName("buildsFailedTotal")
    val buildsFailedTotal: Long,

    /**
     * total aggregated sum of function builds storage.
     */
    @SerialName("buildsStorageTotal")
    val buildsStorageTotal: Long,

    /**
     * Total aggregated sum of function builds compute time.
     */
    @SerialName("buildsTimeTotal")
    val buildsTimeTotal: Long,

    /**
     * Average builds compute time.
     */
    @SerialName("buildsTimeAverage")
    val buildsTimeAverage: Long,

    /**
     * Total aggregated sum of function builds mbSeconds.
     */
    @SerialName("buildsMbSecondsTotal")
    val buildsMbSecondsTotal: Long,

    /**
     * Total  aggregated number of function executions.
     */
    @SerialName("executionsTotal")
    val executionsTotal: Long,

    /**
     * Total aggregated sum of function  executions compute time.
     */
    @SerialName("executionsTimeTotal")
    val executionsTimeTotal: Long,

    /**
     * Total aggregated sum of function executions mbSeconds.
     */
    @SerialName("executionsMbSecondsTotal")
    val executionsMbSecondsTotal: Long,

    /**
     * Aggregated number of function deployments per period.
     */
    @SerialName("deployments")
    val deployments: List<Metric>,

    /**
     * Aggregated number of  function deployments storage per period.
     */
    @SerialName("deploymentsStorage")
    val deploymentsStorage: List<Metric>,

    /**
     * Aggregated number of function builds per period.
     */
    @SerialName("builds")
    val builds: List<Metric>,

    /**
     * Aggregated sum of function builds storage per period.
     */
    @SerialName("buildsStorage")
    val buildsStorage: List<Metric>,

    /**
     * Aggregated sum of function builds compute time per period.
     */
    @SerialName("buildsTime")
    val buildsTime: List<Metric>,

    /**
     * Aggregated number of function builds mbSeconds per period.
     */
    @SerialName("buildsMbSeconds")
    val buildsMbSeconds: List<Metric>,

    /**
     * Aggregated number of function executions per period.
     */
    @SerialName("executions")
    val executions: List<Metric>,

    /**
     * Aggregated number of function executions compute time per period.
     */
    @SerialName("executionsTime")
    val executionsTime: List<Metric>,

    /**
     * Aggregated number of function mbSeconds per period.
     */
    @SerialName("executionsMbSeconds")
    val executionsMbSeconds: List<Metric>,

    /**
     * Aggregated number of successful builds per period.
     */
    @SerialName("buildsSuccess")
    val buildsSuccess: List<Metric>,

    /**
     * Aggregated number of failed builds per period.
     */
    @SerialName("buildsFailed")
    val buildsFailed: List<Metric>,

)

