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
 * The Console service allows you to interact with console relevant informations.
 **/
class Console(client: Client) : Service(client) {
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
