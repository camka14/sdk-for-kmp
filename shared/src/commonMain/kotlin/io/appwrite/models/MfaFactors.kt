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
 * MFAFactors
 */
@Serializable
data class MfaFactors(
    /**
     * Can TOTP be used for MFA challenge for this account.
     */
    @SerialName("totp")
    val totp: Boolean,

    /**
     * Can phone (SMS) be used for MFA challenge for this account.
     */
    @SerialName("phone")
    val phone: Boolean,

    /**
     * Can email be used for MFA challenge for this account.
     */
    @SerialName("email")
    val email: Boolean,

    /**
     * Can recovery code be used for MFA challenge for this account.
     */
    @SerialName("recoveryCode")
    val recoveryCode: Boolean,

)

