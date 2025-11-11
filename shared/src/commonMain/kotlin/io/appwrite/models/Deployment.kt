package io.appwrite.models

import io.appwrite.extensions.jsonCast
import io.appwrite.extensions.json
import io.appwrite.enums.DeploymentStatus
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
import kotlinx.serialization.json.long
import kotlinx.serialization.json.put

/**
 * Deployment
 */
@Serializable
data class Deployment(
    /**
     * Deployment ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Deployment creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Deployment update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Type of deployment.
     */
    @SerialName("type")
    val type: String,

    /**
     * Resource ID.
     */
    @SerialName("resourceId")
    val resourceId: String,

    /**
     * Resource type.
     */
    @SerialName("resourceType")
    val resourceType: String,

    /**
     * The entrypoint file to use to execute the deployment code.
     */
    @SerialName("entrypoint")
    val entrypoint: String,

    /**
     * The code size in bytes.
     */
    @SerialName("sourceSize")
    val sourceSize: Long,

    /**
     * The build output size in bytes.
     */
    @SerialName("buildSize")
    val buildSize: Long,

    /**
     * The total size in bytes (source and build output).
     */
    @SerialName("totalSize")
    val totalSize: Long,

    /**
     * The current build ID.
     */
    @SerialName("buildId")
    val buildId: String,

    /**
     * Whether the deployment should be automatically activated.
     */
    @SerialName("activate")
    val activate: Boolean,

    /**
     * Screenshot with light theme preference file ID.
     */
    @SerialName("screenshotLight")
    val screenshotLight: String,

    /**
     * Screenshot with dark theme preference file ID.
     */
    @SerialName("screenshotDark")
    val screenshotDark: String,

    /**
     * The deployment status. Possible values are &quot;waiting&quot;, &quot;processing&quot;, &quot;building&quot;, &quot;ready&quot;, and &quot;failed&quot;.
     */
    @SerialName("status")
    val status: DeploymentStatus,

    /**
     * The build logs.
     */
    @SerialName("buildLogs")
    val buildLogs: String,

    /**
     * The current build time in seconds.
     */
    @SerialName("buildDuration")
    val buildDuration: Long,

    /**
     * The name of the vcs provider repository
     */
    @SerialName("providerRepositoryName")
    val providerRepositoryName: String,

    /**
     * The name of the vcs provider repository owner
     */
    @SerialName("providerRepositoryOwner")
    val providerRepositoryOwner: String,

    /**
     * The url of the vcs provider repository
     */
    @SerialName("providerRepositoryUrl")
    val providerRepositoryUrl: String,

    /**
     * The commit hash of the vcs commit
     */
    @SerialName("providerCommitHash")
    val providerCommitHash: String,

    /**
     * The url of vcs commit author
     */
    @SerialName("providerCommitAuthorUrl")
    val providerCommitAuthorUrl: String,

    /**
     * The name of vcs commit author
     */
    @SerialName("providerCommitAuthor")
    val providerCommitAuthor: String,

    /**
     * The commit message
     */
    @SerialName("providerCommitMessage")
    val providerCommitMessage: String,

    /**
     * The url of the vcs commit
     */
    @SerialName("providerCommitUrl")
    val providerCommitUrl: String,

    /**
     * The branch of the vcs repository
     */
    @SerialName("providerBranch")
    val providerBranch: String,

    /**
     * The branch of the vcs repository
     */
    @SerialName("providerBranchUrl")
    val providerBranchUrl: String,

)

