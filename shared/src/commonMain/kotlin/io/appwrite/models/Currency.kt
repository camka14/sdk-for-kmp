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
 * Currency
 */
@Serializable
data class Currency(
    /**
     * Currency symbol.
     */
    @SerialName("symbol")
    val symbol: String,

    /**
     * Currency name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Currency native symbol.
     */
    @SerialName("symbolNative")
    val symbolNative: String,

    /**
     * Number of decimal digits.
     */
    @SerialName("decimalDigits")
    val decimalDigits: Long,

    /**
     * Currency digit rounding.
     */
    @SerialName("rounding")
    val rounding: Double,

    /**
     * Currency code in [ISO 4217-1](http://en.wikipedia.org/wiki/ISO_4217) three-character format.
     */
    @SerialName("code")
    val code: String,

    /**
     * Currency plural name
     */
    @SerialName("namePlural")
    val namePlural: String,

)

