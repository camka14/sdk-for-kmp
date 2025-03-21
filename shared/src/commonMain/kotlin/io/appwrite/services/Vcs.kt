package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.enums.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.*
import io.appwrite.serializers.*
import io.appwrite.webInterface.UrlParser
import kotlinx.serialization.KSerializer
import kotlin.jvm.JvmOverloads
import kotlin.reflect.KClass

/**
 * 
 **/
class Vcs(client: Client) : Service(client) {
        /**
     * List repositories
     *
     * Get a list of GitHub repositories available through your installation. This endpoint returns repositories with their basic information, detected runtime environments, and latest push dates. You can optionally filter repositories using a search term. Each repository&#039;s runtime is automatically detected based on its contents and language statistics. The GitHub installation must be properly configured for this endpoint to work.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param installationId Installation Id
     * @param search Search term to filter your list results. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listRepositories(
        installationId: String,
        search: String? = null,
    ): io.appwrite.models.ProviderRepositoryList {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories"
            .replace("{installationId}", installationId)


        val apiParams = mutableMapOf<String, Any?>(
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProviderRepositoryList::class,
            serializer = io.appwrite.models.ProviderRepositoryList.serializer()
        )
    }

            /**
     * Create repository
     *
     * Create a new GitHub repository through your installation. This endpoint allows you to create either a public or private repository by specifying a name and visibility setting. The repository will be created under your GitHub user account or organization, depending on your installation type. The GitHub installation must be properly configured and have the necessary permissions for repository creation.
     *
    @Throws(Throwable::class)
     * @param installationId Installation Id
     * @param name Repository name (slug)
     * @param private Mark repository public or private
     */
    @Throws(Throwable::class)
    suspend fun createRepository(
        installationId: String,
        name: String,
        private: Boolean,
    ): io.appwrite.models.ProviderRepository {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories"
            .replace("{installationId}", installationId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "private" to private,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProviderRepository::class,
            serializer = io.appwrite.models.ProviderRepository.serializer()
        )
    }

            /**
     * Get repository
     *
     * Get detailed information about a specific GitHub repository from your installation. This endpoint returns repository details including its ID, name, visibility status, organization, and latest push date. The GitHub installation must be properly configured and have access to the requested repository for this endpoint to work.
     *
    @Throws(Throwable::class)
     * @param installationId Installation Id
     * @param providerRepositoryId Repository Id
     */
    @Throws(Throwable::class)
    suspend fun getRepository(
        installationId: String,
        providerRepositoryId: String,
    ): io.appwrite.models.ProviderRepository {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories/{providerRepositoryId}"
            .replace("{installationId}", installationId)
            .replace("{providerRepositoryId}", providerRepositoryId)


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
            responseType = io.appwrite.models.ProviderRepository::class,
            serializer = io.appwrite.models.ProviderRepository.serializer()
        )
    }

            /**
     * List repository branches
     *
     * Get a list of all branches from a GitHub repository in your installation. This endpoint returns the names of all branches in the repository and their total count. The GitHub installation must be properly configured and have access to the requested repository for this endpoint to work.
     *
    @Throws(Throwable::class)
     * @param installationId Installation Id
     * @param providerRepositoryId Repository Id
     */
    @Throws(Throwable::class)
    suspend fun listRepositoryBranches(
        installationId: String,
        providerRepositoryId: String,
    ): io.appwrite.models.BranchList {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories/{providerRepositoryId}/branches"
            .replace("{installationId}", installationId)
            .replace("{providerRepositoryId}", providerRepositoryId)


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
            responseType = io.appwrite.models.BranchList::class,
            serializer = io.appwrite.models.BranchList.serializer()
        )
    }

            /**
     * Get files and directories of a VCS repository
     *
     * Get a list of files and directories from a GitHub repository connected to your project. This endpoint returns the contents of a specified repository path, including file names, sizes, and whether each item is a file or directory. The GitHub installation must be properly configured and the repository must be accessible through your installation for this endpoint to work.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param installationId Installation Id
     * @param providerRepositoryId Repository Id
     * @param providerRootDirectory Path to get contents of nested directory
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getRepositoryContents(
        installationId: String,
        providerRepositoryId: String,
        providerRootDirectory: String? = null,
    ): io.appwrite.models.VcsContentList {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories/{providerRepositoryId}/contents"
            .replace("{installationId}", installationId)
            .replace("{providerRepositoryId}", providerRepositoryId)


        val apiParams = mutableMapOf<String, Any?>(
            "providerRootDirectory" to providerRootDirectory,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.VcsContentList::class,
            serializer = io.appwrite.models.VcsContentList.serializer()
        )
    }

            /**
     * Detect runtime settings from source code
     *
     * Analyze a GitHub repository to automatically detect the programming language and runtime environment. This endpoint scans the repository&#039;s files and language statistics to determine the appropriate runtime settings for your function. The GitHub installation must be properly configured and the repository must be accessible through your installation for this endpoint to work.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param installationId Installation Id
     * @param providerRepositoryId Repository Id
     * @param providerRootDirectory Path to Root Directory
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createRepositoryDetection(
        installationId: String,
        providerRepositoryId: String,
        providerRootDirectory: String? = null,
    ): io.appwrite.models.Detection {
        val apiPath = "/vcs/github/installations/{installationId}/providerRepositories/{providerRepositoryId}/detection"
            .replace("{installationId}", installationId)
            .replace("{providerRepositoryId}", providerRepositoryId)


        val apiParams = mutableMapOf<String, Any?>(
            "providerRootDirectory" to providerRootDirectory,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Detection::class,
            serializer = io.appwrite.models.Detection.serializer()
        )
    }

            /**
     * Authorize external deployment
     *
     * Authorize and create deployments for a GitHub pull request in your project. This endpoint allows external contributions by creating deployments from pull requests, enabling preview environments for code review. The pull request must be open and not previously authorized. The GitHub installation must be properly configured and have access to both the repository and pull request for this endpoint to work.
     *
    @Throws(Throwable::class)
     * @param installationId Installation Id
     * @param repositoryId VCS Repository Id
     * @param providerPullRequestId GitHub Pull Request Id
     */
    @Throws(Throwable::class)
    suspend fun updateExternalDeployments(
        installationId: String,
        repositoryId: String,
        providerPullRequestId: String,
    ): Any {
        val apiPath = "/vcs/github/installations/{installationId}/repositories/{repositoryId}"
            .replace("{installationId}", installationId)
            .replace("{repositoryId}", repositoryId)


        val apiParams = mutableMapOf<String, Any?>(
            "providerPullRequestId" to providerPullRequestId,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

            /**
     * List installations
     *
     * List all VCS installations configured for the current project. This endpoint returns a list of installations including their provider, organization, and other configuration details.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: provider, organization
     * @param search Search term to filter your list results. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listInstallations(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.InstallationList {
        val apiPath = "/vcs/installations"


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.InstallationList::class,
            serializer = io.appwrite.models.InstallationList.serializer()
        )
    }

            /**
     * Get installation
     *
     * Get a VCS installation by its unique ID. This endpoint returns the installation&#039;s details including its provider, organization, and configuration. 
     *
    @Throws(Throwable::class)
     * @param installationId Installation Id
     */
    @Throws(Throwable::class)
    suspend fun getInstallation(
        installationId: String,
    ): io.appwrite.models.Installation {
        val apiPath = "/vcs/installations/{installationId}"
            .replace("{installationId}", installationId)


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
            responseType = io.appwrite.models.Installation::class,
            serializer = io.appwrite.models.Installation.serializer()
        )
    }

            /**
     * Delete installation
     *
     * Delete a VCS installation by its unique ID. This endpoint removes the installation and all its associated repositories from the project.
     *
    @Throws(Throwable::class)
     * @param installationId Installation Id
     */
    @Throws(Throwable::class)
    suspend fun deleteInstallation(
        installationId: String,
    ): Any {
        val apiPath = "/vcs/installations/{installationId}"
            .replace("{installationId}", installationId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
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
