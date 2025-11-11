package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DetectionRuntime
 */
@Serializable
data class DetectionRuntime(
    /**
     * Runtime
     */
    @SerialName("runtime")
    val runtime: String,

    /**
     * Function Entrypoint
     */
    @SerialName("entrypoint")
    val entrypoint: String,

    /**
     * Function install and build commands
     */
    @SerialName("commands")
    val commands: String,

    )

