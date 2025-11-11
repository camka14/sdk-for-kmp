package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * DetectionFramework
 */
@Serializable
data class DetectionFramework(
    /**
     * Framework
     */
    @SerialName("framework")
    val framework: String,

    /**
     * Site Install Command
     */
    @SerialName("installCommand")
    val installCommand: String,

    /**
     * Site Build Command
     */
    @SerialName("buildCommand")
    val buildCommand: String,

    /**
     * Site Output Directory
     */
    @SerialName("outputDirectory")
    val outputDirectory: String,

    )

