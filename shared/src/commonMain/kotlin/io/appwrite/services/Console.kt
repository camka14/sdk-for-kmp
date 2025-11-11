package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.serializers.*

/**
 * The Console service allows you to interact with console relevant informations.
 **/
class Console(client: Client) : Service(client) {
    /**
     * Check resource ID availability
     *
     * Check if a resource ID is available.
     *
    @Throws(Throwable::class)
     * @param value Resource value.
     * @param type Resource type.
     */
    @Throws(Throwable::class)
    suspend fun getResource(
        value: String,
        type: io.appwrite.enums.ConsoleResourceType,
    ): Any {
        val apiPath = "/console/resources"


        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "type" to type,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

    /**
     * Get variables
     *
     * Get all Environment Variables that are relevant for the console.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun variables(
    ): io.appwrite.models.ConsoleVariables {
        val apiPath = "/console/variables"


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
            responseType = io.appwrite.models.ConsoleVariables::class,
            serializer = io.appwrite.models.ConsoleVariables.serializer()
        )
    }

}
