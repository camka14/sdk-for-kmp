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
 * UsageFunctions
 */
@Serializable
data class UsageFunctions(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of functions.
     */
    @SerialName("functionsTotal")
    val functionsTotal: Long,

    /**
     * Total aggregated number of functions deployments.
     */
    @SerialName("deploymentsTotal")
    val deploymentsTotal: Long,

    /**
     * Total aggregated sum of functions deployment storage.
     */
    @SerialName("deploymentsStorageTotal")
    val deploymentsStorageTotal: Long,

    /**
     * Total aggregated number of functions build.
     */
    @SerialName("buildsTotal")
    val buildsTotal: Long,

    /**
     * total aggregated sum of functions build storage.
     */
    @SerialName("buildsStorageTotal")
    val buildsStorageTotal: Long,

    /**
     * Total aggregated sum of functions build compute time.
     */
    @SerialName("buildsTimeTotal")
    val buildsTimeTotal: Long,

    /**
     * Total aggregated sum of functions build mbSeconds.
     */
    @SerialName("buildsMbSecondsTotal")
    val buildsMbSecondsTotal: Long,

    /**
     * Total  aggregated number of functions execution.
     */
    @SerialName("executionsTotal")
    val executionsTotal: Long,

    /**
     * Total aggregated sum of functions  execution compute time.
     */
    @SerialName("executionsTimeTotal")
    val executionsTimeTotal: Long,

    /**
     * Total aggregated sum of functions execution mbSeconds.
     */
    @SerialName("executionsMbSecondsTotal")
    val executionsMbSecondsTotal: Long,

    /**
     * Aggregated number of functions per period.
     */
    @SerialName("functions")
    val functions: List<Metric>,

    /**
     * Aggregated number of functions deployment per period.
     */
    @SerialName("deployments")
    val deployments: List<Metric>,

    /**
     * Aggregated number of  functions deployment storage per period.
     */
    @SerialName("deploymentsStorage")
    val deploymentsStorage: List<Metric>,

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
     * Aggregated number of functions build per period.
     */
    @SerialName("builds")
    val builds: List<Metric>,

    /**
     * Aggregated sum of functions build storage per period.
     */
    @SerialName("buildsStorage")
    val buildsStorage: List<Metric>,

    /**
     * Aggregated sum of  functions build compute time per period.
     */
    @SerialName("buildsTime")
    val buildsTime: List<Metric>,

    /**
     * Aggregated sum of functions build mbSeconds per period.
     */
    @SerialName("buildsMbSeconds")
    val buildsMbSeconds: List<Metric>,

    /**
     * Aggregated number of  functions execution per period.
     */
    @SerialName("executions")
    val executions: List<Metric>,

    /**
     * Aggregated number of functions execution compute time per period.
     */
    @SerialName("executionsTime")
    val executionsTime: List<Metric>,

    /**
     * Aggregated number of functions mbSeconds per period.
     */
    @SerialName("executionsMbSeconds")
    val executionsMbSeconds: List<Metric>,

    /**
     * Aggregated number of successful function builds per period.
     */
    @SerialName("buildsSuccess")
    val buildsSuccess: List<Metric>,

    /**
     * Aggregated number of failed function builds per period.
     */
    @SerialName("buildsFailed")
    val buildsFailed: List<Metric>,

)

