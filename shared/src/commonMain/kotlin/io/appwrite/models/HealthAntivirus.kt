package io.appwrite.models

import io.appwrite.enums.HealthAntivirusStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Health Antivirus
 */
@Serializable
data class HealthAntivirus(
    /**
     * Antivirus version.
     */
    @SerialName("version")
    val version: String,

    /**
     * Antivirus status. Possible values are: `disabled`, `offline`, `online`
     */
    @SerialName("status")
    val status: HealthAntivirusStatus,

    )

