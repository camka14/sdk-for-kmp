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
 * Health Certificate
 */
@Serializable
data class HealthCertificate(
    /**
     * Certificate name
     */
    @SerialName("name")
    val name: String,

    /**
     * Subject SN
     */
    @SerialName("subjectSN")
    val subjectSN: String,

    /**
     * Issuer organisation
     */
    @SerialName("issuerOrganisation")
    val issuerOrganisation: String,

    /**
     * Valid from
     */
    @SerialName("validFrom")
    val validFrom: String,

    /**
     * Valid to
     */
    @SerialName("validTo")
    val validTo: String,

    /**
     * Signature type SN
     */
    @SerialName("signatureTypeSN")
    val signatureTypeSN: String,

)

