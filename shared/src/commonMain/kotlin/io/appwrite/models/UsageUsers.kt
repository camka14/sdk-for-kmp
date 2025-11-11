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
 * UsageUsers
 */
@Serializable
data class UsageUsers(
    /**
     * Time range of the usage stats.
     */
    @SerialName("range")
    val range: String,

    /**
     * Total aggregated number of statistics of users.
     */
    @SerialName("usersTotal")
    val usersTotal: Long,

    /**
     * Total aggregated number of active sessions.
     */
    @SerialName("sessionsTotal")
    val sessionsTotal: Long,

    /**
     * Aggregated number of users per period.
     */
    @SerialName("users")
    val users: List<Metric>,

    /**
     * Aggregated number of active sessions  per period.
     */
    @SerialName("sessions")
    val sessions: List<Metric>,

)

