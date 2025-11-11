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
 * The Functions Service allows you view, create and manage your Cloud Functions.
 **/
class Functions(client: Client) : Service(client) {
        /**
     * List functions
     *
     * Get a list of all the project&#039;s functions. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, runtime, deploymentId, schedule, scheduleNext, schedulePrevious, timeout, entrypoint, commands, installationId
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.FunctionList {
        val apiPath = "/functions"


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
            responseType = io.appwrite.models.FunctionList::class,
            serializer = io.appwrite.models.FunctionList.serializer()
        )
    }

            /**
     * Create function
     *
     * Create a new function. You can pass a list of [permissions](https://appwrite.io/docs/permissions) to allow different project users or team with access to execute the function using the client API.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Function name. Max length: 128 chars.
     * @param runtime Execution runtime.
     * @param execute An array of role strings with execution permissions. By default no user is granted with any execute permissions. [learn more about roles](https://appwrite.io/docs/permissions#permission-roles). Maximum of 100 roles are allowed, each 64 characters long.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param schedule Schedule CRON syntax.
     * @param timeout Function maximum execution time in seconds.
     * @param enabled Is function enabled? When set to 'disabled', users cannot access the function but Server SDKs with and API key can still access the function. No data is lost when this is toggled.
     * @param logging When disabled, executions will exclude logs and errors, and will be slightly faster.
     * @param entrypoint Entrypoint File. This path is relative to the "providerRootDirectory".
     * @param commands Build Commands.
     * @param scopes List of scopes allowed for API key auto-generated for every execution. Maximum of 100 scopes are allowed.
     * @param installationId Appwrite Installation ID for VCS (Version Control System) deployment.
     * @param providerRepositoryId Repository ID of the repo linked to the function.
     * @param providerBranch Production branch for the repo linked to the function.
     * @param providerSilentMode Is the VCS (Version Control System) connection in silent mode for the repo linked to the function? In silent mode, comments will not be made on commits and pull requests.
     * @param providerRootDirectory Path to function code in the linked repo.
     * @param specification Runtime specification for the function and builds.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun create(
        functionId: String,
        name: String,
        runtime: io.appwrite.enums.Runtime,
        execute: List<String>? = null,
        events: List<String>? = null,
        schedule: String? = null,
        timeout: Long? = null,
        enabled: Boolean? = null,
        logging: Boolean? = null,
        entrypoint: String? = null,
        commands: String? = null,
        scopes: List<String>? = null,
        installationId: String? = null,
        providerRepositoryId: String? = null,
        providerBranch: String? = null,
        providerSilentMode: Boolean? = null,
        providerRootDirectory: String? = null,
        specification: String? = null,
    ): io.appwrite.models.Function {
        val apiPath = "/functions"


        val apiParams = mutableMapOf<String, Any?>(
            "functionId" to functionId,
            "name" to name,
            "runtime" to runtime,
            "execute" to execute,
            "events" to events,
            "schedule" to schedule,
            "timeout" to timeout,
            "enabled" to enabled,
            "logging" to logging,
            "entrypoint" to entrypoint,
            "commands" to commands,
            "scopes" to scopes,
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
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Function::class,
            serializer = io.appwrite.models.Function.serializer()
        )
    }

            /**
     * List runtimes
     *
     * Get a list of all runtimes that are currently active on your instance.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listRuntimes(
    ): io.appwrite.models.RuntimeList {
        val apiPath = "/functions/runtimes"


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
            responseType = io.appwrite.models.RuntimeList::class,
            serializer = io.appwrite.models.RuntimeList.serializer()
        )
    }

            /**
     * List specifications
     *
     * List allowed function specifications for this instance.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listSpecifications(
    ): io.appwrite.models.SpecificationList {
        val apiPath = "/functions/specifications"


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
     * List available function templates. You can use template details in [createFunction](/docs/references/cloud/server-nodejs/functions#create) method.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param runtimes List of runtimes allowed for filtering function templates. Maximum of 100 runtimes are allowed.
     * @param useCases List of use cases allowed for filtering function templates. Maximum of 100 use cases are allowed.
     * @param limit Limit the number of templates returned in the response. Default limit is 25, and maximum limit is 5000.
     * @param offset Offset the list of returned templates. Maximum offset is 5000.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listTemplates(
        runtimes: List<String>? = null,
        useCases: List<String>? = null,
        limit: Long? = null,
        offset: Long? = null,
        total: Boolean? = null,
    ): io.appwrite.models.TemplateFunctionList {
        val apiPath = "/functions/templates"


        val apiParams = mutableMapOf<String, Any?>(
            "runtimes" to runtimes,
            "useCases" to useCases,
            "limit" to limit,
            "offset" to offset,
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
            responseType = io.appwrite.models.TemplateFunctionList::class,
            serializer = io.appwrite.models.TemplateFunctionList.serializer()
        )
    }

            /**
     * Get function template
     *
     * Get a function template using ID. You can use template details in [createFunction](/docs/references/cloud/server-nodejs/functions#create) method.
     *
    @Throws(Throwable::class)
     * @param templateId Template ID.
     */
    @Throws(Throwable::class)
    suspend fun getTemplate(
        templateId: String,
    ): io.appwrite.models.TemplateFunction {
        val apiPath = "/functions/templates/{templateId}"
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
            responseType = io.appwrite.models.TemplateFunction::class,
            serializer = io.appwrite.models.TemplateFunction.serializer()
        )
    }

            /**
     * Get functions usage
     *
     * Get usage metrics and statistics for all functions in the project. View statistics including total deployments, builds, logs, storage usage, and compute time. The response includes both current totals and historical data for each metric. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listUsage(
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageFunctions {
        val apiPath = "/functions/usage"


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
            responseType = io.appwrite.models.UsageFunctions::class,
            serializer = io.appwrite.models.UsageFunctions.serializer()
        )
    }

            /**
     * Get function
     *
     * Get a function by its unique ID.
     *
    @Throws(Throwable::class)
     * @param functionId Function ID.
     */
    @Throws(Throwable::class)
    suspend fun get(
        functionId: String,
    ): io.appwrite.models.Function {
        val apiPath = "/functions/{functionId}"
            .replace("{functionId}", functionId)


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
            responseType = io.appwrite.models.Function::class,
            serializer = io.appwrite.models.Function.serializer()
        )
    }

            /**
     * Update function
     *
     * Update function by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param name Function name. Max length: 128 chars.
     * @param runtime Execution runtime.
     * @param execute An array of role strings with execution permissions. By default no user is granted with any execute permissions. [learn more about roles](https://appwrite.io/docs/permissions#permission-roles). Maximum of 100 roles are allowed, each 64 characters long.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param schedule Schedule CRON syntax.
     * @param timeout Maximum execution time in seconds.
     * @param enabled Is function enabled? When set to 'disabled', users cannot access the function but Server SDKs with and API key can still access the function. No data is lost when this is toggled.
     * @param logging When disabled, executions will exclude logs and errors, and will be slightly faster.
     * @param entrypoint Entrypoint File. This path is relative to the "providerRootDirectory".
     * @param commands Build Commands.
     * @param scopes List of scopes allowed for API Key auto-generated for every execution. Maximum of 100 scopes are allowed.
     * @param installationId Appwrite Installation ID for VCS (Version Controle System) deployment.
     * @param providerRepositoryId Repository ID of the repo linked to the function
     * @param providerBranch Production branch for the repo linked to the function
     * @param providerSilentMode Is the VCS (Version Control System) connection in silent mode for the repo linked to the function? In silent mode, comments will not be made on commits and pull requests.
     * @param providerRootDirectory Path to function code in the linked repo.
     * @param specification Runtime specification for the function and builds.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun update(
        functionId: String,
        name: String,
        runtime: io.appwrite.enums.Runtime? = null,
        execute: List<String>? = null,
        events: List<String>? = null,
        schedule: String? = null,
        timeout: Long? = null,
        enabled: Boolean? = null,
        logging: Boolean? = null,
        entrypoint: String? = null,
        commands: String? = null,
        scopes: List<String>? = null,
        installationId: String? = null,
        providerRepositoryId: String? = null,
        providerBranch: String? = null,
        providerSilentMode: Boolean? = null,
        providerRootDirectory: String? = null,
        specification: String? = null,
    ): io.appwrite.models.Function {
        val apiPath = "/functions/{functionId}"
            .replace("{functionId}", functionId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "runtime" to runtime,
            "execute" to execute,
            "events" to events,
            "schedule" to schedule,
            "timeout" to timeout,
            "enabled" to enabled,
            "logging" to logging,
            "entrypoint" to entrypoint,
            "commands" to commands,
            "scopes" to scopes,
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
            responseType = io.appwrite.models.Function::class,
            serializer = io.appwrite.models.Function.serializer()
        )
    }

            /**
     * Delete function
     *
     * Delete a function by its unique ID.
     *
    @Throws(Throwable::class)
     * @param functionId Function ID.
     */
    @Throws(Throwable::class)
    suspend fun delete(
        functionId: String,
    ): Any {
        val apiPath = "/functions/{functionId}"
            .replace("{functionId}", functionId)


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
     * Update function&#039;s deployment
     *
     * Update the function active deployment. Use this endpoint to switch the code deployment that should be used when visitor opens your function.
     *
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun updateFunctionDeployment(
        functionId: String,
        deploymentId: String,
    ): io.appwrite.models.Function {
        val apiPath = "/functions/{functionId}/deployment"
            .replace("{functionId}", functionId)


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
            responseType = io.appwrite.models.Function::class,
            serializer = io.appwrite.models.Function.serializer()
        )
    }

            /**
     * List deployments
     *
     * Get a list of all the function&#039;s code deployments. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: buildSize, sourceSize, totalSize, buildDuration, status, activate, type
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listDeployments(
        functionId: String,
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.DeploymentList {
        val apiPath = "/functions/{functionId}/deployments"
            .replace("{functionId}", functionId)


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
     * Create a new function code deployment. Use this endpoint to upload a new version of your code function. To execute your newly uploaded code, you&#039;ll need to update the function&#039;s deployment to use your new deployment UID.This endpoint accepts a tar.gz file compressed with your code. Make sure to include any dependencies your code has within the compressed file. You can learn more about code packaging in the [Appwrite Cloud Functions tutorial](https://appwrite.io/docs/functions).Use the &quot;command&quot; param to set the entrypoint used to execute your code.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param code Gzip file with your code package. When used with the Appwrite CLI, pass the path to your code directory, and the CLI will automatically package your code. Use a path that is within the current directory.
     * @param activate Automatically activate the deployment when it is finished building.
     * @param entrypoint Entrypoint File.
     * @param commands Build Commands.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createDeployment(
        functionId: String,
        code: InputFile,
        activate: Boolean,
        entrypoint: String? = null,
        commands: String? = null,
        onProgress: ((UploadProgress) -> Unit)? = null
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments"
            .replace("{functionId}", functionId)


        val apiParams = mutableMapOf<String, Any?>(
            "entrypoint" to entrypoint,
            "commands" to commands,
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
     * Create a new build for an existing function deployment. This endpoint allows you to rebuild a deployment with the updated function configuration, including its entrypoint and build commands if they have been modified. The build process will be queued and executed asynchronously. The original deployment&#039;s code will be preserved and used for the new build.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @param buildId Build unique ID.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createDuplicateDeployment(
        functionId: String,
        deploymentId: String,
        buildId: String? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/duplicate"
            .replace("{functionId}", functionId)


        val apiParams = mutableMapOf<String, Any?>(
            "deploymentId" to deploymentId,
            "buildId" to buildId,
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
     * Create a deployment based on a template.Use this endpoint with combination of [listTemplates](https://appwrite.io/docs/products/functions/templates) to find the template details.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param repository Repository name of the template.
     * @param owner The name of the owner of the template.
     * @param rootDirectory Path to function code in the template repo.
     * @param version Version (tag) for the repo linked to the function template.
     * @param activate Automatically activate the deployment when it is finished building.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createTemplateDeployment(
        functionId: String,
        repository: String,
        owner: String,
        rootDirectory: String,
        version: String,
        activate: Boolean? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/template"
            .replace("{functionId}", functionId)


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
     * Create a deployment when a function is connected to VCS.This endpoint lets you create deployment from a branch, commit, or a tag.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param type Type of reference passed. Allowed values are: branch, commit
     * @param reference VCS reference to create deployment from. Depending on type this can be: branch name, commit hash
     * @param activate Automatically activate the deployment when it is finished building.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createVcsDeployment(
        functionId: String,
        type: io.appwrite.enums.VCSDeploymentType,
        reference: String,
        activate: Boolean? = null,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/vcs"
            .replace("{functionId}", functionId)


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
     * Get a function deployment by its unique ID.
     *
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun getDeployment(
        functionId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}"
            .replace("{functionId}", functionId)
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
     * Delete a code deployment by its unique ID.
     *
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteDeployment(
        functionId: String,
        deploymentId: String,
    ): Any {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}"
            .replace("{functionId}", functionId)
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
     * Get a function deployment content by its unique ID. The endpoint response return with a &#039;Content-Disposition: attachment&#039; header that tells the browser to start downloading the file to user downloads directory.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     * @param type Deployment file to download. Can be: "source", "output".
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getDeploymentDownload(
        functionId: String,
        deploymentId: String,
        type: io.appwrite.enums.DeploymentDownloadType? = null,
    ): ByteArray {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}/download"
            .replace("{functionId}", functionId)
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
     * Cancel an ongoing function deployment build. If the build is already in progress, it will be stopped and marked as canceled. If the build hasn&#039;t started yet, it will be marked as canceled without executing. You cannot cancel builds that have already completed (status &#039;ready&#039;) or failed. The response includes the final build status and details.
     *
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param deploymentId Deployment ID.
     */
    @Throws(Throwable::class)
    suspend fun updateDeploymentStatus(
        functionId: String,
        deploymentId: String,
    ): io.appwrite.models.Deployment {
        val apiPath = "/functions/{functionId}/deployments/{deploymentId}/status"
            .replace("{functionId}", functionId)
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
     * List executions
     *
     * Get a list of all the current user function execution logs. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: trigger, status, responseStatusCode, duration, requestMethod, requestPath, deploymentId
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listExecutions(
        functionId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ExecutionList {
        val apiPath = "/functions/{functionId}/executions"
            .replace("{functionId}", functionId)


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
     * Create execution
     *
     * Trigger a function execution. The returned object will return you the current execution status. You can ping the `Get Execution` endpoint to get updates on the current execution status. Once this endpoint is called, your function execution process will start asynchronously.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param body HTTP body of execution. Default value is empty string.
     * @param async Execute code in the background. Default value is false.
     * @param path HTTP path of execution. Path can include query params. Default value is /
     * @param method HTTP method of execution. Default value is POST.
     * @param headers HTTP headers of execution. Defaults to empty.
     * @param scheduledAt Scheduled execution time in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future with precision in minutes.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createExecution(
        functionId: String,
        body: String? = null,
        async: Boolean? = null,
        path: String? = null,
        method: io.appwrite.enums.ExecutionMethod? = null,
        headers: Any? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Execution {
        val apiPath = "/functions/{functionId}/executions"
            .replace("{functionId}", functionId)


        val apiParams = mutableMapOf<String, Any?>(
            "body" to body,
            "async" to async,
            "path" to path,
            "method" to method,
            "headers" to headers,
            "scheduledAt" to scheduledAt,
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
            responseType = io.appwrite.models.Execution::class,
            serializer = io.appwrite.models.Execution.serializer()
        )
    }

            /**
     * Get execution
     *
     * Get a function execution log by its unique ID.
     *
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param executionId Execution ID.
     */
    @Throws(Throwable::class)
    suspend fun getExecution(
        functionId: String,
        executionId: String,
    ): io.appwrite.models.Execution {
        val apiPath = "/functions/{functionId}/executions/{executionId}"
            .replace("{functionId}", functionId)
            .replace("{executionId}", executionId)


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
     * Delete execution
     *
     * Delete a function execution by its unique ID.
     *
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param executionId Execution ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteExecution(
        functionId: String,
        executionId: String,
    ): Any {
        val apiPath = "/functions/{functionId}/executions/{executionId}"
            .replace("{functionId}", functionId)
            .replace("{executionId}", executionId)


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
     * Get function usage
     *
     * Get usage metrics and statistics for a for a specific function. View statistics including total deployments, builds, executions, storage usage, and compute time. The response includes both current totals and historical data for each metric. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function ID.
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getUsage(
        functionId: String,
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageFunction {
        val apiPath = "/functions/{functionId}/usage"
            .replace("{functionId}", functionId)


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
            responseType = io.appwrite.models.UsageFunction::class,
            serializer = io.appwrite.models.UsageFunction.serializer()
        )
    }

            /**
     * List variables
     *
     * Get a list of all variables of a specific function.
     *
    @Throws(Throwable::class)
     * @param functionId Function unique ID.
     */
    @Throws(Throwable::class)
    suspend fun listVariables(
        functionId: String,
    ): io.appwrite.models.VariableList {
        val apiPath = "/functions/{functionId}/variables"
            .replace("{functionId}", functionId)


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
     * Create a new function environment variable. These variables can be accessed in the function at runtime as environment variables.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param functionId Function unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only functions can read them during build and runtime.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createVariable(
        functionId: String,
        key: String,
        value: String,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/functions/{functionId}/variables"
            .replace("{functionId}", functionId)


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
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     */
    @Throws(Throwable::class)
    suspend fun getVariable(
        functionId: String,
        variableId: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/functions/{functionId}/variables/{variableId}"
            .replace("{functionId}", functionId)
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
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only functions can read them during build and runtime.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateVariable(
        functionId: String,
        variableId: String,
        key: String,
        value: String? = null,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/functions/{functionId}/variables/{variableId}"
            .replace("{functionId}", functionId)
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
     * @param functionId Function unique ID.
     * @param variableId Variable unique ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteVariable(
        functionId: String,
        variableId: String,
    ): Any {
        val apiPath = "/functions/{functionId}/variables/{variableId}"
            .replace("{functionId}", functionId)
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
