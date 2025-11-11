package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Framework Adapter
 */
@Serializable
data class FrameworkAdapter(
    /**
     * Adapter key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Default command to download dependencies.
     */
    @SerialName("installCommand")
    val installCommand: String,

    /**
     * Default command to build site into output directory.
     */
    @SerialName("buildCommand")
    val buildCommand: String,

    /**
     * Default output directory of build.
     */
    @SerialName("outputDirectory")
    val outputDirectory: String,

    /**
     * Name of fallback file to use instead of 404 page. If null, Appwrite 404 page will be displayed.
     */
    @SerialName("fallbackFile")
    val fallbackFile: String,

    )

