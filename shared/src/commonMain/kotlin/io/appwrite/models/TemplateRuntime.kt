package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Template Runtime
 */
@Serializable
data class TemplateRuntime(
    /**
     * Runtime Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * The build command used to build the deployment.
     */
    @SerialName("commands")
    val commands: String,

    /**
     * The entrypoint file used to execute the deployment.
     */
    @SerialName("entrypoint")
    val entrypoint: String,

    /**
     * Path to function in VCS (Version Control System) repository
     */
    @SerialName("providerRootDirectory")
    val providerRootDirectory: String,

    )

