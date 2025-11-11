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
 * UsageBuckets
 */
@Serializable
data class UsageBuckets(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of bucket files.
     */
    @SerialName("filesTotal")
    val filesTotal: Long,

    /**
     * Total aggregated number of bucket files storage (in bytes).
     */
    @SerialName("filesStorageTotal")
    val filesStorageTotal: Long,

    /**
     * Aggregated  number of bucket files per period.
     */
    @SerialName("files")
    val files: List<Metric>,

    /**
     * Aggregated  number of bucket storage files (in bytes) per period.
     */
    @SerialName("storage")
    val storage: List<Metric>,

    /**
     * Aggregated number of files transformations per period.
     */
    @SerialName("imageTransformations")
    val imageTransformations: List<Metric>,

    /**
     * Total aggregated number of files transformations.
     */
    @SerialName("imageTransformationsTotal")
    val imageTransformationsTotal: Long,

)

