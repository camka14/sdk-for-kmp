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
 * The Migrations service allows you to migrate third-party data to your Appwrite project.
 **/
class Migrations(client: Client) : Service(client) {
        /**
     * List migrations
     *
     * List all migrations in the current project. This endpoint returns a list of all migrations including their status, progress, and any errors that occurred during the migration process.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: status, stage, source, destination, resources, statusCounters, resourceData, errors
     * @param search Search term to filter your list results. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.MigrationList {
        val apiPath = "/migrations"


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
            responseType = io.appwrite.models.MigrationList::class,
            serializer = io.appwrite.models.MigrationList.serializer()
        )
    }

            /**
     * Create Appwrite migration
     *
     * Migrate data from another Appwrite project to your current project. This endpoint allows you to migrate resources like databases, collections, documents, users, and files from an existing Appwrite project. 
     *
    @Throws(Throwable::class)
     * @param resources List of resources to migrate
     * @param endpoint Source Appwrite endpoint
     * @param projectId Source Project ID
     * @param apiKey Source API Key
     */
    @Throws(Throwable::class)
    suspend fun createAppwriteMigration(
        resources: List<String>,
        endpoint: String,
        projectId: String,
        apiKey: String,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/appwrite"


        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "endpoint" to endpoint,
            "projectId" to projectId,
            "apiKey" to apiKey,
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
            responseType = io.appwrite.models.Migration::class,
            serializer = io.appwrite.models.Migration.serializer()
        )
    }

            /**
     * Get Appwrite migration report
     *
     * Generate a report of the data in an Appwrite project before migrating. This endpoint analyzes the source project and returns information about the resources that can be migrated.
     *
    @Throws(Throwable::class)
     * @param resources List of resources to migrate
     * @param endpoint Source's Appwrite Endpoint
     * @param projectID Source's Project ID
     * @param key Source's API Key
     */
    @Throws(Throwable::class)
    suspend fun getAppwriteReport(
        resources: List<String>,
        endpoint: String,
        projectID: String,
        key: String,
    ): io.appwrite.models.MigrationReport {
        val apiPath = "/migrations/appwrite/report"


        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "endpoint" to endpoint,
            "projectID" to projectID,
            "key" to key,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MigrationReport::class,
            serializer = io.appwrite.models.MigrationReport.serializer()
        )
    }

            /**
     * Create Firebase migration
     *
     * Migrate data from a Firebase project to your Appwrite project. This endpoint allows you to migrate resources like authentication and other supported services from a Firebase project. 
     *
    @Throws(Throwable::class)
     * @param resources List of resources to migrate
     * @param serviceAccount JSON of the Firebase service account credentials
     */
    @Throws(Throwable::class)
    suspend fun createFirebaseMigration(
        resources: List<String>,
        serviceAccount: String,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/firebase"


        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "serviceAccount" to serviceAccount,
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
            responseType = io.appwrite.models.Migration::class,
            serializer = io.appwrite.models.Migration.serializer()
        )
    }

            /**
     * Get Firebase migration report
     *
     * Generate a report of the data in a Firebase project before migrating. This endpoint analyzes the source project and returns information about the resources that can be migrated.
     *
    @Throws(Throwable::class)
     * @param resources List of resources to migrate
     * @param serviceAccount JSON of the Firebase service account credentials
     */
    @Throws(Throwable::class)
    suspend fun getFirebaseReport(
        resources: List<String>,
        serviceAccount: String,
    ): io.appwrite.models.MigrationReport {
        val apiPath = "/migrations/firebase/report"


        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "serviceAccount" to serviceAccount,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MigrationReport::class,
            serializer = io.appwrite.models.MigrationReport.serializer()
        )
    }

            /**
     * Create NHost migration
     *
     * Migrate data from an NHost project to your Appwrite project. This endpoint allows you to migrate resources like authentication, databases, and other supported services from an NHost project. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param resources List of resources to migrate
     * @param subdomain Source's Subdomain
     * @param region Source's Region
     * @param adminSecret Source's Admin Secret
     * @param database Source's Database Name
     * @param username Source's Database Username
     * @param password Source's Database Password
     * @param port Source's Database Port
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createNHostMigration(
        resources: List<String>,
        subdomain: String,
        region: String,
        adminSecret: String,
        database: String,
        username: String,
        password: String,
        port: Long? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/nhost"


        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "subdomain" to subdomain,
            "region" to region,
            "adminSecret" to adminSecret,
            "database" to database,
            "username" to username,
            "password" to password,
            "port" to port,
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
            responseType = io.appwrite.models.Migration::class,
            serializer = io.appwrite.models.Migration.serializer()
        )
    }

            /**
     * Get NHost migration report
     *
     * Generate a detailed report of the data in an NHost project before migrating. This endpoint analyzes the source project and returns information about the resources that can be migrated. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param resources List of resources to migrate.
     * @param subdomain Source's Subdomain.
     * @param region Source's Region.
     * @param adminSecret Source's Admin Secret.
     * @param database Source's Database Name.
     * @param username Source's Database Username.
     * @param password Source's Database Password.
     * @param port Source's Database Port.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getNHostReport(
        resources: List<String>,
        subdomain: String,
        region: String,
        adminSecret: String,
        database: String,
        username: String,
        password: String,
        port: Long? = null,
    ): io.appwrite.models.MigrationReport {
        val apiPath = "/migrations/nhost/report"


        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "subdomain" to subdomain,
            "region" to region,
            "adminSecret" to adminSecret,
            "database" to database,
            "username" to username,
            "password" to password,
            "port" to port,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MigrationReport::class,
            serializer = io.appwrite.models.MigrationReport.serializer()
        )
    }

            /**
     * Create Supabase migration
     *
     * Migrate data from a Supabase project to your Appwrite project. This endpoint allows you to migrate resources like authentication, databases, and other supported services from a Supabase project. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param resources List of resources to migrate
     * @param endpoint Source's Supabase Endpoint
     * @param apiKey Source's API Key
     * @param databaseHost Source's Database Host
     * @param username Source's Database Username
     * @param password Source's Database Password
     * @param port Source's Database Port
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createSupabaseMigration(
        resources: List<String>,
        endpoint: String,
        apiKey: String,
        databaseHost: String,
        username: String,
        password: String,
        port: Long? = null,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/supabase"


        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "endpoint" to endpoint,
            "apiKey" to apiKey,
            "databaseHost" to databaseHost,
            "username" to username,
            "password" to password,
            "port" to port,
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
            responseType = io.appwrite.models.Migration::class,
            serializer = io.appwrite.models.Migration.serializer()
        )
    }

            /**
     * Get Supabase migration report
     *
     * Generate a report of the data in a Supabase project before migrating. This endpoint analyzes the source project and returns information about the resources that can be migrated. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param resources List of resources to migrate
     * @param endpoint Source's Supabase Endpoint.
     * @param apiKey Source's API Key.
     * @param databaseHost Source's Database Host.
     * @param username Source's Database Username.
     * @param password Source's Database Password.
     * @param port Source's Database Port.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getSupabaseReport(
        resources: List<String>,
        endpoint: String,
        apiKey: String,
        databaseHost: String,
        username: String,
        password: String,
        port: Long? = null,
    ): io.appwrite.models.MigrationReport {
        val apiPath = "/migrations/supabase/report"


        val apiParams = mutableMapOf<String, Any?>(
            "resources" to resources,
            "endpoint" to endpoint,
            "apiKey" to apiKey,
            "databaseHost" to databaseHost,
            "username" to username,
            "password" to password,
            "port" to port,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MigrationReport::class,
            serializer = io.appwrite.models.MigrationReport.serializer()
        )
    }

            /**
     * Get migration
     *
     * Get a migration by its unique ID. This endpoint returns detailed information about a specific migration including its current status, progress, and any errors that occurred during the migration process. 
     *
    @Throws(Throwable::class)
     * @param migrationId Migration unique ID.
     */
    @Throws(Throwable::class)
    suspend fun get(
        migrationId: String,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/{migrationId}"
            .replace("{migrationId}", migrationId)


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
            responseType = io.appwrite.models.Migration::class,
            serializer = io.appwrite.models.Migration.serializer()
        )
    }

            /**
     * Update retry migration
     *
     * Retry a failed migration. This endpoint allows you to retry a migration that has previously failed.
     *
    @Throws(Throwable::class)
     * @param migrationId Migration unique ID.
     */
    @Throws(Throwable::class)
    suspend fun retry(
        migrationId: String,
    ): io.appwrite.models.Migration {
        val apiPath = "/migrations/{migrationId}"
            .replace("{migrationId}", migrationId)


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
            responseType = io.appwrite.models.Migration::class,
            serializer = io.appwrite.models.Migration.serializer()
        )
    }

            /**
     * Delete migration
     *
     * Delete a migration by its unique ID. This endpoint allows you to remove a migration from your project&#039;s migration history. 
     *
    @Throws(Throwable::class)
     * @param migrationId Migration ID.
     */
    @Throws(Throwable::class)
    suspend fun delete(
        migrationId: String,
    ): Any {
        val apiPath = "/migrations/{migrationId}"
            .replace("{migrationId}", migrationId)


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
