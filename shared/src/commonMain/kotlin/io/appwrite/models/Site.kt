package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Site
 */
@Serializable
data class Site(
    /**
     * Site ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Site creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Site update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Site name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Site enabled.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Is the site deployed with the latest configuration? This is set to false if you&#039;ve changed an environment variables, entrypoint, commands, or other settings that needs redeploy to be applied. When the value is false, redeploy the site to update it with the latest configuration.
     */
    @SerialName("live")
    val live: Boolean,

    /**
     * When disabled, request logs will exclude logs and errors, and site responses will be slightly faster.
     */
    @SerialName("logging")
    val logging: Boolean,

    /**
     * Site framework.
     */
    @SerialName("framework")
    val framework: String,

    /**
     * Site&#039;s active deployment ID.
     */
    @SerialName("deploymentId")
    val deploymentId: String,

    /**
     * Active deployment creation date in ISO 8601 format.
     */
    @SerialName("deploymentCreatedAt")
    val deploymentCreatedAt: String,

    /**
     * Screenshot of active deployment with light theme preference file ID.
     */
    @SerialName("deploymentScreenshotLight")
    val deploymentScreenshotLight: String,

    /**
     * Screenshot of active deployment with dark theme preference file ID.
     */
    @SerialName("deploymentScreenshotDark")
    val deploymentScreenshotDark: String,

    /**
     * Site&#039;s latest deployment ID.
     */
    @SerialName("latestDeploymentId")
    val latestDeploymentId: String,

    /**
     * Latest deployment creation date in ISO 8601 format.
     */
    @SerialName("latestDeploymentCreatedAt")
    val latestDeploymentCreatedAt: String,

    /**
     * Status of latest deployment. Possible values are &quot;waiting&quot;, &quot;processing&quot;, &quot;building&quot;, &quot;ready&quot;, and &quot;failed&quot;.
     */
    @SerialName("latestDeploymentStatus")
    val latestDeploymentStatus: String,

    /**
     * Site variables.
     */
    @SerialName("vars")
    val vars: List<Variable>,

    /**
     * Site request timeout in seconds.
     */
    @SerialName("timeout")
    val timeout: Long,

    /**
     * The install command used to install the site dependencies.
     */
    @SerialName("installCommand")
    val installCommand: String,

    /**
     * The build command used to build the site.
     */
    @SerialName("buildCommand")
    val buildCommand: String,

    /**
     * The directory where the site build output is located.
     */
    @SerialName("outputDirectory")
    val outputDirectory: String,

    /**
     * Site VCS (Version Control System) installation id.
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
     * Path to site in VCS (Version Control System) repository
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

    /**
     * Site build runtime.
     */
    @SerialName("buildRuntime")
    val buildRuntime: String,

    /**
     * Site framework adapter.
     */
    @SerialName("adapter")
    val adapter: String,

    /**
     * Name of fallback file to use instead of 404 page. If null, Appwrite 404 page will be displayed.
     */
    @SerialName("fallbackFile")
    val fallbackFile: String,

    )

