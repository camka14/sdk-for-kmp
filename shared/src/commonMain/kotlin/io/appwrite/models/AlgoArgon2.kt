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
 * AlgoArgon2
 */
@Serializable
data class AlgoArgon2(
    /**
     * Algo type.
     */
    @SerialName("type")
    val type: String,

    /**
     * Memory used to compute hash.
     */
    @SerialName("memoryCost")
    val memoryCost: Long,

    /**
     * Amount of time consumed to compute hash
     */
    @SerialName("timeCost")
    val timeCost: Long,

    /**
     * Number of threads used to compute hash.
     */
    @SerialName("threads")
    val threads: Long,

)

