package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Template Framework
 */
@Serializable
data class TemplateFramework(
    /**
     * Parent framework key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Framework Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * The install command used to install the dependencies.
     */
    @SerialName("installCommand")
    val installCommand: String,

    /**
     * The build command used to build the deployment.
     */
    @SerialName("buildCommand")
    val buildCommand: String,

    /**
     * The output directory to store the build output.
     */
    @SerialName("outputDirectory")
    val outputDirectory: String,

    /**
     * Path to site in VCS (Version Control System) repository
     */
    @SerialName("providerRootDirectory")
    val providerRootDirectory: String,

    /**
     * Runtime used during build step of template.
     */
    @SerialName("buildRuntime")
    val buildRuntime: String,

    /**
     * Site framework runtime
     */
    @SerialName("adapter")
    val adapter: String,

    /**
     * Fallback file for SPA. Only relevant for static serve runtime.
     */
    @SerialName("fallbackFile")
    val fallbackFile: String,

    )

