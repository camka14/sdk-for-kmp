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
class Assistant(client: Client) : Service(client) {
        /**
     * Ask query
     *
     * Send a prompt to the AI assistant and receive a response. This endpoint allows you to interact with Appwrite&#039;s AI assistant by sending questions or prompts and receiving helpful responses in real-time through a server-sent events stream. 
     *
    @Throws(Throwable::class)
     * @param prompt Prompt. A string containing questions asked to the AI assistant.
     */
    @Throws(Throwable::class)
    suspend fun chat(
        prompt: String,
    ): Any {
        val apiPath = "/console/assistant"


        val apiParams = mutableMapOf<String, Any?>(
            "prompt" to prompt,
        )
        val apiHeaders = mutableMapOf(
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
