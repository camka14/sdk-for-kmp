package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

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

