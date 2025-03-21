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
 * Metric Breakdown
 */
@Serializable
data class MetricBreakdown(
    /**
     * Resource ID.
     */
    @SerialName("resourceId")
    var resourceId: String?,

    /**
     * Resource name.
     */
    @SerialName("name")
    val name: String,

    /**
     * The value of this metric at the timestamp.
     */
    @SerialName("value")
    val value: Long,

    /**
     * The estimated value of this metric at the end of the period.
     */
    @SerialName("estimate")
    var estimate: Double?,

)

