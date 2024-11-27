package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.enums.*

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
        val converter: (Any) -> Any = {
            it
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            converter,
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
        val converter: (Any) -> Any = {
            it
        }
        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            converter,
        )
    }


}