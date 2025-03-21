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
 * The Proxy Service allows you to configure actions for your domains beyond DNS configuration.
 **/
class Proxy(client: Client) : Service(client) {
        /**
     * List rules
     *
     * Get a list of all the proxy rules. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: domain, resourceType, resourceId, url
     * @param search Search term to filter your list results. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listRules(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.ProxyRuleList {
        val apiPath = "/proxy/rules"


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
            responseType = io.appwrite.models.ProxyRuleList::class,
            serializer = io.appwrite.models.ProxyRuleList.serializer()
        )
    }

            /**
     * Create rule
     *
     * Create a new proxy rule.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param domain Domain name.
     * @param resourceType Action definition for the rule. Possible values are "api", "function"
     * @param resourceId ID of resource for the action type. If resourceType is "api", leave empty. If resourceType is "function", provide ID of the function.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createRule(
        domain: String,
        resourceType: io.appwrite.enums.ResourceType,
        resourceId: String? = null,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules"


        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
            "resourceType" to resourceType,
            "resourceId" to resourceId,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRule::class,
            serializer = io.appwrite.models.ProxyRule.serializer()
        )
    }

            /**
     * Get rule
     *
     * Get a proxy rule by its unique ID.
     *
    @Throws(Throwable::class)
     * @param ruleId Rule ID.
     */
    @Throws(Throwable::class)
    suspend fun getRule(
        ruleId: String,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/{ruleId}"
            .replace("{ruleId}", ruleId)


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
            responseType = io.appwrite.models.ProxyRule::class,
            serializer = io.appwrite.models.ProxyRule.serializer()
        )
    }

            /**
     * Delete rule
     *
     * Delete a proxy rule by its unique ID.
     *
    @Throws(Throwable::class)
     * @param ruleId Rule ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteRule(
        ruleId: String,
    ): Any {
        val apiPath = "/proxy/rules/{ruleId}"
            .replace("{ruleId}", ruleId)


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

            /**
     * Update rule verification status
     *
     * Retry getting verification process of a proxy rule. This endpoint triggers domain verification by checking DNS records (CNAME) against the configured target domain. If verification is successful, a TLS certificate will be automatically provisioned for the domain.
     *
    @Throws(Throwable::class)
     * @param ruleId Rule ID.
     */
    @Throws(Throwable::class)
    suspend fun updateRuleVerification(
        ruleId: String,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/{ruleId}/verification"
            .replace("{ruleId}", ruleId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProxyRule::class,
            serializer = io.appwrite.models.ProxyRule.serializer()
        )
    }

    }
