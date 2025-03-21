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
import kotlinx.serialization.json.put

/**
 * Function
 */
@Serializable
data class Function(
    /**
     * Function ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Function creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Function update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Execution permissions.
     */
    @SerialName("execute")
    val execute: List<String>,

    /**
     * Function name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Function enabled.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Is the function deployed with the latest configuration? This is set to false if you&#039;ve changed an environment variables, entrypoint, commands, or other settings that needs redeploy to be applied. When the value is false, redeploy the function to update it with the latest configuration.
     */
    @SerialName("live")
    val live: Boolean,

    /**
     * Whether executions will be logged. When set to false, executions will not be logged, but will reduce resource used by your Appwrite project.
     */
    @SerialName("logging")
    val logging: Boolean,

    /**
     * Function execution runtime.
     */
    @SerialName("runtime")
    val runtime: String,

    /**
     * Function&#039;s active deployment ID.
     */
    @SerialName("deployment")
    val deployment: String,

    /**
     * Allowed permission scopes.
     */
    @SerialName("scopes")
    val scopes: List<String>,

    /**
     * Function variables.
     */
    @SerialName("vars")
    val vars: List<Variable>,

    /**
     * Function trigger events.
     */
    @SerialName("events")
    val events: List<String>,

    /**
     * Function execution schedule in CRON format.
     */
    @SerialName("schedule")
    val schedule: String,

    /**
     * Function execution timeout in seconds.
     */
    @SerialName("timeout")
    val timeout: Long,

    /**
     * The entrypoint file used to execute the deployment.
     */
    @SerialName("entrypoint")
    val entrypoint: String,

    /**
     * The build command used to build the deployment.
     */
    @SerialName("commands")
    val commands: String,

    /**
     * Version of Open Runtimes used for the function.
     */
    @SerialName("version")
    val version: String,

    /**
     * Function VCS (Version Control System) installation id.
     */
    @SerialName("installationId")
    val installationId: String,

    /**
     * VCS (Version Control System) Repository ID
     */
    @SerialName("providerRepositoryId")
    val providerRepositoryId: String,

    /**
     * VCS (Version Control System) branch name
     */
    @SerialName("providerBranch")
    val providerBranch: String,

    /**
     * Path to function in VCS (Version Control System) repository
     */
    @SerialName("providerRootDirectory")
    val providerRootDirectory: String,

    /**
     * Is VCS (Version Control System) connection is in silent mode? When in silence mode, no comments will be posted on the repository pull or merge requests
     */
    @SerialName("providerSilentMode")
    val providerSilentMode: Boolean,

    /**
     * Machine specification for builds and executions.
     */
    @SerialName("specification")
    val specification: String,

)

