package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.*
import io.appwrite.serializers.*
import io.appwrite.webInterface.UrlParser
import kotlinx.serialization.KSerializer
import kotlin.jvm.JvmOverloads
import kotlin.reflect.KClass
import kotlinx.serialization.serializer
import io.ktor.client.plugins.cookies.cookies
import io.ktor.client.request.cookie
import io.ktor.client.request.get
import io.ktor.http.Cookie

/**
 * The Sites Service allows you view, create and manage your web applications.
 **/
class Sites(client: Client) : Service(client) {
        /**
     * List sites
     *
     * Get a list of all the project&#039;s sites. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, framework, deploymentId, buildCommand, installCommand, outputDirectory, installationId
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.SiteList {
        val apiPath = "/sites"


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.SiteList::class,
            serializer = io.appwrite.models.SiteList.serializer()
        )
    }

            /**
     * Create site
     *
     * Create a new site.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Site name. Max length: 128 chars.
     * @param framework Sites framework.
     * @param buildRuntime Runtime to use during build step.
     * @param enabled Is site enabled? When set to 'disabled', users cannot access the site but Server SDKs with and API key can still access the site. No data is lost when this is toggled.
     * @param logging When disabled, request logs will exclude logs and errors, and site responses will be slightly faster.
     * @param timeout Maximum request time in seconds.
     * @param installCommand Install Command.
     * @param buildCommand Build Command.
     * @param outputDirectory Output Directory for site.
     * @param adapter Framework adapter defining rendering strategy. Allowed values are: static, ssr
     * @param installationId Appwrite Installation ID for VCS (Version Control System) deployment.
     * @param fallbackFile Fallback file for single page application sites.
     * @param providerRepositoryId Repository ID of the repo linked to the site.
     * @param providerBranch Production branch for the repo linked to the site.
     * @param providerSilentMode Is the VCS (Version Control System) connection in silent mode for the repo linked to the site? In silent mode, comments will not be made on commits and pull requests.
     * @param providerRootDirectory Path to site code in the linked repo.
     * @param specification Framework specification for the site and builds.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun create(
        siteId: String,
        name: String,
        framework: io.appwrite.enums.Framework,
        buildRuntime: io.appwrite.enums.BuildRuntime,
        enabled: Boolean? = null,
        logging: Boolean? = null,
        timeout: Long? = null,
        installCommand: String? = null,
        buildCommand: String? = null,
        outputDirectory: String? = null,
        adapter: io.appwrite.enums.Adapter? = null,
        installationId: String? = null,
        fallbackFile: String? = null,
        providerRepositoryId: String? = null,
        providerBranch: String? = null,
        providerSilentMode: Boolean? = null,
        providerRootDirectory: String? = null,
        specification: String? = null,
    ): io.appwrite.models.Site {
        val apiPath = "/sites"


        val apiParams = mutableMapOf<String, Any?>(
            "siteId" to siteId,
            "name" to name,
            "framework" to framework,
            "enabled" to enabled,
            "logging" to logging,
            "timeout" to timeout,
            "installCommand" to installCommand,
            "buildCommand" to buildCommand,
            "outputDirectory" to outputDirectory,
            "buildRuntime" to buildRuntime,
            "adapter" to adapter,
            "installationId" to installationId,
            "fallbackFile" to fallbackFile,
            "providerRepositoryId" to providerRepositoryId,
            "providerBranch" to providerBranch,
            "providerSilentMode" to providerSilentMode,
            "providerRootDirectory" to providerRootDirectory,
            "specification" to specification,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Site::class,
            serializer = io.appwrite.models.Site.serializer()
        )
    }

            /**
     * List frameworks
     *
     * Get a list of all frameworks that are currently available on the server instance.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listFrameworks(
    ): io.appwrite.models.FrameworkList {
        val apiPath = "/sites/frameworks"


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.FrameworkList::class,
            serializer = io.appwrite.models.FrameworkList.serializer()
        )
    }

            /**
     * List specifications
     *
     * List allowed site specifications for this instance.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listSpecifications(
    ): io.appwrite.models.SpecificationList {
        val apiPath = "/sites/specifications"


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.SpecificationList::class,
            serializer = io.appwrite.models.SpecificationList.serializer()
        )
    }

            /**
     * List templates
     *
     * List available site templates. You can use template details in [createSite](/docs/references/cloud/server-nodejs/sites#create) method.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param frameworks List of frameworks allowed for filtering site templates. Maximum of 100 frameworks are allowed.
     * @param useCases List of use cases allowed for filtering site templates. Maximum of 100 use cases are allowed.
     * @param limit Limit the number of templates returned in the response. Default limit is 25, and maximum limit is 5000.
     * @param offset Offset the list of returned templates. Maximum offset is 5000.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listTemplates(
        frameworks: List<String>? = null,
        useCases: List<String>? = null,
        limit: Long? = null,
        offset: Long? = null,
    ): io.appwrite.models.TemplateSiteList {
        val apiPath = "/sites/templates"


        val apiParams = mutableMapOf<String, Any?>(
            "frameworks" to frameworks,
            "useCases" to useCases,
            "limit" to limit,
            "offset" to offset,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TemplateSiteList::class,
            serializer = io.appwrite.models.TemplateSiteList.serializer()
        )
    }

            /**
     * Get site template
     *
     * Get a site template using ID. You can use template details in [createSite](/docs/references/cloud/server-nodejs/sites#create) method.
     *
    @Throws(Throwable::class)
     * @param templateId Template ID.
     */
    @Throws(Throwable::class)
    suspend fun getTemplate(
        templateId: String,
    ): io.appwrite.models.TemplateSite {
        val apiPath = "/sites/templates/{templateId}"
            .replace("{templateId}", templateId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TemplateSite::class,
            serializer = io.appwrite.models.TemplateSite.serializer()
        )
    }

            /**
     * Get sites usage
     *
     * Get usage metrics and statistics for all sites in the project. View statistics including total deployments, builds, logs, storage usage, and compute time. The response includes both current totals and historical data for each metric. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listUsage(
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageSites {
        val apiPath = "/sites/usage"


        val apiParams = mutableMapOf<String, Any?>(
            "range" to range,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.UsageSites::class,
            serializer = io.appwrite.models.UsageSites.serializer()
        )
    }

            /**
     * Get site
     *
     * Get a site by its unique ID.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     */
    @Throws(Throwable::class)
    suspend fun get(
        siteId: String,
    ): io.appwrite.models.Site {
        val apiPath = "/sites/{siteId}"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Site::class,
            serializer = io.appwrite.models.Site.serializer()
        )
    }

            /**
     * Update site
     *
     * Update site by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param name Site name. Max length: 128 chars.
     * @param framework Sites framework.
     * @param enabled Is site enabled? When set to 'disabled', users cannot access the site but Server SDKs with and API key can still access the site. No data is lost when this is toggled.
     * @param logging When disabled, request logs will exclude logs and errors, and site responses will be slightly faster.
     * @param timeout Maximum request time in seconds.
     * @param installCommand Install Command.
     * @param buildCommand Build Command.
     * @param outputDirectory Output Directory for site.
     * @param buildRuntime Runtime to use during build step.
     * @param adapter Framework adapter defining rendering strategy. Allowed values are: static, ssr
     * @param fallbackFile Fallback file for single page application sites.
     * @param installationId Appwrite Installation ID for VCS (Version Control System) deployment.
     * @param providerRepositoryId Repository ID of the repo linked to the site.
     * @param providerBranch Production branch for the repo linked to the site.
     * @param providerSilentMode Is the VCS (Version Control System) connection in silent mode for the repo linked to the site? In silent mode, comments will not be made on commits and pull requests.
     * @param providerRootDirectory Path to site code in the linked repo.
     * @param specification Framework specification for the site and builds.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun update(
        siteId: String,
        name: String,
        framework: io.appwrite.enums.Framework,
        enabled: Boolean? = null,
        logging: Boolean? = null,
        timeout: Long? = null,
        installCommand: String? = null,
        buildCommand: String? = null,
        outputDirectory: String? = null,
        buildRuntime: io.appwrite.enums.BuildRuntime? = null,
        adapter: io.appwrite.enums.Adapter? = null,
        fallbackFile: String? = null,
        installationId: String? = null,
        providerRepositoryId: String? = null,
        providerBranch: String? = null,
        providerSilentMode: Boolean? = null,
        providerRootDirectory: String? = null,
        specification: String? = null,
    ): io.appwrite.models.Site {
        val apiPath = "/sites/{siteId}"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "framework" to framework,
            "enabled" to enabled,
            "logging" to logging,
            "timeout" to timeout,
            "installCommand" to installCommand,
            "buildCommand" to buildCommand,
            "outputDirectory" to outputDirectory,
            "buildRuntime" to buildRuntime,
            "adapter" to adapter,
            "fallbackFile" to fallbackFile,
            "installationId" to installationId,
            "providerRepositoryId" to providerRepositoryId,
            "providerBranch" to providerBranch,
            "providerSilentMode" to providerSilentMode,
            "providerRootDirectory" to providerRootDirectory,
            "specification" to specification,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Site::class,
            serializer = io.appwrite.models.Site.serializer()
        )
    }

            /**
     * Delete site
     *
     * Delete a site by its unique ID.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     */
    @Throws(Throwable::class)
    suspend fun delete(
        siteId: String,
    ): Any {
        val apiPath = "/sites/{siteId}"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

            /**
     * Update site&#039;s deployment
     *
     * Update the site active deployment. Use this endpoint to switch the code deployment that should be used when visitor opens your site.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun updateSiteDeployment(
        siteId: String,
        deploymentId: String,
    ): io.appwrite.models.Site {
        val apiPath = "/sites/{siteId}/deployment"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "deploymentId" to deploymentId,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Site::class,
            serializer = io.appwrite.models.Site.serializer()
        )
    }

            /**
     * List deployments
     *
     * Get a list of all the site&#039;s code deployments. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: buildSize, sourceSize, totalSize, buildDuration, status, activate, type
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listDeployments(
        siteId: String,
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.DeploymentList {
        val apiPath = "/sites/{siteId}/deployments"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.DeploymentList::class,
            serializer = io.appwrite.models.DeploymentList.serializer()
        )
    }

            /**
     * Create deployment
     *
     * Create a new site code deployment. Use this endpoint to upload a new version of your site code. To activate your newly uploaded code, you&#039;ll need to update the site&#039;s deployment to use your new deployment ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param code Gzip file with your code package. When used with the Appwrite CLI, pass the path to your code directory, and the CLI will automatically package your code. Use a path that is within the current directory.
     * @param activate Automatically activate the deployment when it is finished building.
     * @param installCommand Install Commands.
     * @param buildCommand Build Commands.
     * @param outputDirectory Output Directory.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createDeployment(
        siteId: String,
        code: InputFile,
        activate: Boolean,
        installCommand: String? = null,
        buildCommand: String? = null,
        outputDirectory: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "installCommand" to installCommand,
            "buildCommand" to buildCommand,
            "outputDirectory" to outputDirectory,
            "code" to code,
            "activate" to activate,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "multipart/form-data",
        )

        val idParamName: String? =null
        val paramName = "code"

        return client.chunkedUpload(
            apiPath,
            apiHeaders,
            apiParams,
            code,
            responseType = io.appwrite.models.Deployment::class,
            io.appwrite.models.Deployment.serializer(),
            paramName,
            idParamName,
            onProgress
        )
    }

            /**
     * Create duplicate deployment
     *
     * Create a new build for an existing site deployment. This endpoint allows you to rebuild a deployment with the updated site configuration, including its commands and output directory if they have been modified. The build process will be queued and executed asynchronously. The original deployment&#039;s code will be preserved and used for the new build.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun createDuplicateDeployment(
        siteId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/duplicate"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "deploymentId" to deploymentId,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class,
            serializer = io.appwrite.models.Deployment.serializer()
        )
    }

            /**
     * Create template deployment
     *
     * Create a deployment based on a template.Use this endpoint with combination of [listTemplates](https://appwrite.io/docs/products/sites/templates) to find the template details.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param repository Repository name of the template.
     * @param owner The name of the owner of the template.
     * @param rootDirectory Path to site code in the template repo.
     * @param version Version (tag) for the repo linked to the site template.
     * @param activate Automatically activate the deployment when it is finished building.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createTemplateDeployment(
        siteId: String,
        repository: String,
        owner: String,
        rootDirectory: String,
        version: String,
        activate: Boolean? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/template"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "repository" to repository,
            "owner" to owner,
            "rootDirectory" to rootDirectory,
            "version" to version,
            "activate" to activate,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class,
            serializer = io.appwrite.models.Deployment.serializer()
        )
    }

            /**
     * Create VCS deployment
     *
     * Create a deployment when a site is connected to VCS.This endpoint lets you create deployment from a branch, commit, or a tag.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param type Type of reference passed. Allowed values are: branch, commit
     * @param reference VCS reference to create deployment from. Depending on type this can be: branch name, commit hash
     * @param activate Automatically activate the deployment when it is finished building.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createVcsDeployment(
        siteId: String,
        type: io.appwrite.enums.VCSDeploymentType,
        reference: String,
        activate: Boolean? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/vcs"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "type" to type,
            "reference" to reference,
            "activate" to activate,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class,
            serializer = io.appwrite.models.Deployment.serializer()
        )
    }

            /**
     * Get deployment
     *
     * Get a site deployment by its unique ID.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun getDeployment(
        siteId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/{deploymentId}"
            .replace("{siteId}", siteId)
            .replace("{deploymentId}", deploymentId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class,
            serializer = io.appwrite.models.Deployment.serializer()
        )
    }

            /**
     * Delete deployment
     *
     * Delete a site deployment by its unique ID.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteDeployment(
        siteId: String,
        deploymentId: String,
    ): Any {
        val apiPath = "/sites/{siteId}/deployments/{deploymentId}"
            .replace("{siteId}", siteId)
            .replace("{deploymentId}", deploymentId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

            /**
     * Get deployment download
     *
     * Get a site deployment content by its unique ID. The endpoint response return with a &#039;Content-Disposition: attachment&#039; header that tells the browser to start downloading the file to user downloads directory.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     * @param type Deployment file to download. Can be: "source", "output".
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getDeploymentDownload(
        siteId: String,
        deploymentId: String,
        type: io.appwrite.enums.DeploymentDownloadType? = null,
    ): ByteArray {
        val apiPath = "/sites/{siteId}/deployments/{deploymentId}/download"
            .replace("{siteId}", siteId)
            .replace("{deploymentId}", deploymentId)


        val apiParams = mutableMapOf<String, Any?>(
            "type" to type,
            "project" to client.config["project"],
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class
        )
    }

            /**
     * Update deployment status
     *
     * Cancel an ongoing site deployment build. If the build is already in progress, it will be stopped and marked as canceled. If the build hasn&#039;t started yet, it will be marked as canceled without executing. You cannot cancel builds that have already completed (status &#039;ready&#039;) or failed. The response includes the final build status and details.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun updateDeploymentStatus(
        siteId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/sites/{siteId}/deployments/{deploymentId}/status"
            .replace("{siteId}", siteId)
            .replace("{deploymentId}", deploymentId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Deployment::class,
            serializer = io.appwrite.models.Deployment.serializer()
        )
    }

            /**
     * List logs
     *
     * Get a list of all site logs. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: trigger, status, responseStatusCode, duration, requestMethod, requestPath, deploymentId
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listLogs(
        siteId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ExecutionList {
        val apiPath = "/sites/{siteId}/logs"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ExecutionList::class,
            serializer = io.appwrite.models.ExecutionList.serializer()
        )
    }

            /**
     * Get log
     *
     * Get a site request log by its unique ID.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param logId Log ID.
     */
    @Throws(Throwable::class)
    suspend fun getLog(
        siteId: String,
        logId: String,
    ): io.appwrite.models.Execution {
        val apiPath = "/sites/{siteId}/logs/{logId}"
            .replace("{siteId}", siteId)
            .replace("{logId}", logId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Execution::class,
            serializer = io.appwrite.models.Execution.serializer()
        )
    }

            /**
     * Delete log
     *
     * Delete a site log by its unique ID.
     *
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param logId Log ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteLog(
        siteId: String,
        logId: String,
    ): Any {
        val apiPath = "/sites/{siteId}/logs/{logId}"
            .replace("{siteId}", siteId)
            .replace("{logId}", logId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

            /**
     * Get site usage
     *
     * Get usage metrics and statistics for a for a specific site. View statistics including total deployments, builds, executions, storage usage, and compute time. The response includes both current totals and historical data for each metric. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site ID.
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getUsage(
        siteId: String,
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageSite {
        val apiPath = "/sites/{siteId}/usage"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "range" to range,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.UsageSite::class,
            serializer = io.appwrite.models.UsageSite.serializer()
        )
    }

            /**
     * List variables
     *
     * Get a list of all variables of a specific site.
     *
    @Throws(Throwable::class)
     * @param siteId Site unique ID.
     */
    @Throws(Throwable::class)
    suspend fun listVariables(
        siteId: String,
    ): io.appwrite.models.VariableList {
        val apiPath = "/sites/{siteId}/variables"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VariableList::class,
            serializer = io.appwrite.models.VariableList.serializer()
        )
    }

            /**
     * Create variable
     *
     * Create a new site variable. These variables can be accessed during build and runtime (server-side rendering) as environment variables.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only sites can read them during build and runtime.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createVariable(
        siteId: String,
        key: String,
        value: String,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/sites/{siteId}/variables"
            .replace("{siteId}", siteId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class,
            serializer = io.appwrite.models.Variable.serializer()
        )
    }

            /**
     * Get variable
     *
     * Get a variable by its unique ID.
     *
    @Throws(Throwable::class)
     * @param siteId Site unique ID.
     * @param variableId Variable unique ID.
     */
    @Throws(Throwable::class)
    suspend fun getVariable(
        siteId: String,
        variableId: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/sites/{siteId}/variables/{variableId}"
            .replace("{siteId}", siteId)
            .replace("{variableId}", variableId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class,
            serializer = io.appwrite.models.Variable.serializer()
        )
    }

            /**
     * Update variable
     *
     * Update variable by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param siteId Site unique ID.
     * @param variableId Variable unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only sites can read them during build and runtime.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateVariable(
        siteId: String,
        variableId: String,
        key: String,
        value: String? = null,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/sites/{siteId}/variables/{variableId}"
            .replace("{siteId}", siteId)
            .replace("{variableId}", variableId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "value" to value,
            "secret" to secret,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Variable::class,
            serializer = io.appwrite.models.Variable.serializer()
        )
    }

            /**
     * Delete variable
     *
     * Delete a variable by its unique ID.
     *
    @Throws(Throwable::class)
     * @param siteId Site unique ID.
     * @param variableId Variable unique ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteVariable(
        siteId: String,
        variableId: String,
    ): Any {
        val apiPath = "/sites/{siteId}/variables/{variableId}"
            .replace("{siteId}", siteId)
            .replace("{variableId}", variableId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

    }
