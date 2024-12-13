package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service

/**
 * The GraphQL API allows you to query and mutate your Appwrite server using GraphQL.
 **/
class Graphql(client: Client) : Service(client) {

    /**
     * GraphQL endpoint
     *
     * Execute a GraphQL mutation.
     *
     * @param query The query or queries to execute.
     * @return [Any]
     */
    @Throws(Throwable::class)
    suspend fun query(
        query: Any,
    ): Any {
        val apiPath = "/graphql"

        val apiParams = mutableMapOf<String, Any?>(
            "query" to query,
        )
        val apiHeaders = mutableMapOf(
            "x-sdk-graphql" to "true",
            "content-type" to "application/json",
        )
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
        )
    }


    /**
     * GraphQL endpoint
     *
     * Execute a GraphQL mutation.
     *
     * @param query The query or queries to execute.
     * @return [Any]
     */
    @Throws(Throwable::class)
    suspend fun mutation(
        query: Any,
    ): Any {
        val apiPath = "/graphql/mutation"

        val apiParams = mutableMapOf<String, Any?>(
            "query" to query,
        )
        val apiHeaders = mutableMapOf(
            "x-sdk-graphql" to "true",
            "content-type" to "application/json",
        )
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
        )
    }
}