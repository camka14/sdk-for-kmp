package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.serializers.*

/**
 *
 **/
class Tokens(client: Client) : Service(client) {
    /**
     * List tokens
     *
     * List all the tokens created for a specific file or bucket. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File unique ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: expire
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun list(
        bucketId: String,
        fileId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ResourceTokenList {
        val apiPath = "/tokens/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)


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
            responseType = io.appwrite.models.ResourceTokenList::class,
            serializer = io.appwrite.models.ResourceTokenList.serializer()
        )
    }

    /**
     * Create file token
     *
     * Create a new token. A token is linked to a file. Token can be passed as a request URL search parameter.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File unique ID.
     * @param expire Token expiry date
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createFileToken(
        bucketId: String,
        fileId: String,
        expire: String? = null,
    ): io.appwrite.models.ResourceToken {
        val apiPath = "/tokens/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)


        val apiParams = mutableMapOf<String, Any?>(
            "expire" to expire,
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
            responseType = io.appwrite.models.ResourceToken::class,
            serializer = io.appwrite.models.ResourceToken.serializer()
        )
    }

    /**
     * Get token
     *
     * Get a token by its unique ID.
     *
    @Throws(Throwable::class)
     * @param tokenId Token ID.
     */
    @Throws(Throwable::class)
    suspend fun get(
        tokenId: String,
    ): io.appwrite.models.ResourceToken {
        val apiPath = "/tokens/{tokenId}"
            .replace("{tokenId}", tokenId)


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
            responseType = io.appwrite.models.ResourceToken::class,
            serializer = io.appwrite.models.ResourceToken.serializer()
        )
    }

    /**
     * Update token
     *
     * Update a token by its unique ID. Use this endpoint to update a token&#039;s expiry date.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param tokenId Token unique ID.
     * @param expire File token expiry date
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun update(
        tokenId: String,
        expire: String? = null,
    ): io.appwrite.models.ResourceToken {
        val apiPath = "/tokens/{tokenId}"
            .replace("{tokenId}", tokenId)


        val apiParams = mutableMapOf<String, Any?>(
            "expire" to expire,
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
            responseType = io.appwrite.models.ResourceToken::class,
            serializer = io.appwrite.models.ResourceToken.serializer()
        )
    }

    /**
     * Delete token
     *
     * Delete a token by its unique ID.
     *
    @Throws(Throwable::class)
     * @param tokenId Token ID.
     */
    @Throws(Throwable::class)
    suspend fun delete(
        tokenId: String,
    ): Any {
        val apiPath = "/tokens/{tokenId}"
            .replace("{tokenId}", tokenId)


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
