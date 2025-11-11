package io.appwrite.models

import io.appwrite.enums.HealthCheckStatus
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Health Status
 */
@Serializable
data class HealthStatus(
    /**
     * Name of the service.
     */
    @SerialName("name")
    val name: String,

    /**
     * Duration in milliseconds how long the health check took.
     */
    @SerialName("ping")
    val ping: Long,

    /**
     * Service status. Possible values are: `pass`, `fail`
     */
    @SerialName("status")
    val status: HealthCheckStatus,

    )

