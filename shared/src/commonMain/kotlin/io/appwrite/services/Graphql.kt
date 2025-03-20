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
 * The GraphQL API allows you to query and mutate your Appwrite server using GraphQL.
 **/
class Graphql(client: Client) : Service(client) {
        /**
     * GraphQL endpoint
     *
     * Execute a GraphQL mutation.
     *
    @Throws(Throwable::class)
     * @param query The query or queries to execute.
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
            serializer = DynamicLookupSerializer
        )
    }

            /**
     * GraphQL endpoint
     *
     * Execute a GraphQL mutation.
     *
    @Throws(Throwable::class)
     * @param query The query or queries to execute.
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
            serializer = DynamicLookupSerializer
        )
    }

    }
