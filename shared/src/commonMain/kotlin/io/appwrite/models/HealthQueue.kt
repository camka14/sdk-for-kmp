package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Health Queue
 */
@Serializable
data class HealthQueue(
    /**
     * Amount of actions in the queue.
     */
    @SerialName("size")
    val size: Long,

    )

