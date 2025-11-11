package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.serializers.*

/**
 * The Project service allows you to manage all the projects in your Appwrite server.
 **/
class Project(client: Client) : Service(client) {
    /**
     * Get project usage stats
     *
     * Get comprehensive usage statistics for your project. View metrics including network requests, bandwidth, storage, function executions, database usage, and user activity. Specify a time range with startDate and endDate, and optionally set the data granularity with period (1h or 1d). The response includes both total counts and detailed breakdowns by resource, along with historical data over the specified period.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param startDate Starting date for the usage
     * @param endDate End date for the usage
     * @param period Period used
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getUsage(
        startDate: String,
        endDate: String,
        period: io.appwrite.enums.ProjectUsageRange? = null,
    ): io.appwrite.models.UsageProject {
        val apiPath = "/project/usage"


        val apiParams = mutableMapOf<String, Any?>(
            "startDate" to startDate,
            "endDate" to endDate,
            "period" to period,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.UsageProject::class,
            serializer = io.appwrite.models.UsageProject.serializer()
        )
    }

    /**
     * List variables
     *
     * Get a list of all project variables. These variables will be accessible in all Appwrite Functions at runtime.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listVariables(
    ): io.appwrite.models.VariableList {
        val apiPath = "/project/variables"


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
     * Create a new project variable. This variable will be accessible in all Appwrite Functions at runtime.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only projects can read them during build and runtime.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createVariable(
        key: String,
        value: String,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables"


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
     * Get a project variable by its unique ID.
     *
    @Throws(Throwable::class)
     * @param variableId Variable unique ID.
     */
    @Throws(Throwable::class)
    suspend fun getVariable(
        variableId: String,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables/{variableId}"
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
     * Update project variable by its unique ID. This variable will be accessible in all Appwrite Functions at runtime.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param variableId Variable unique ID.
     * @param key Variable key. Max length: 255 chars.
     * @param value Variable value. Max length: 8192 chars.
     * @param secret Secret variables can be updated or deleted, but only projects can read them during build and runtime.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateVariable(
        variableId: String,
        key: String,
        value: String? = null,
        secret: Boolean? = null,
    ): io.appwrite.models.Variable {
        val apiPath = "/project/variables/{variableId}"
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
     * Delete a project variable by its unique ID.
     *
    @Throws(Throwable::class)
     * @param variableId Variable unique ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteVariable(
        variableId: String,
    ): Any {
        val apiPath = "/project/variables/{variableId}"
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
