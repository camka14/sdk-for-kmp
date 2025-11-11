package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
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
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/databases#querying-documents). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: domain, type, trigger, deploymentResourceType, deploymentResourceId, deploymentId, deploymentVcsProviderBranch
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listRules(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ProxyRuleList {
        val apiPath = "/proxy/rules"


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
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
            responseType = io.appwrite.models.ProxyRuleList::class,
            serializer = io.appwrite.models.ProxyRuleList.serializer()
        )
    }

            /**
     * Create API rule
     *
     * Create a new proxy rule for serving Appwrite&#039;s API on custom domain.
     *
    @Throws(Throwable::class)
     * @param domain Domain name.
     */
    @Throws(Throwable::class)
    suspend fun createAPIRule(
        domain: String,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/api"


        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
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
            responseType = io.appwrite.models.ProxyRule::class,
            serializer = io.appwrite.models.ProxyRule.serializer()
        )
    }

            /**
     * Create function rule
     *
     * Create a new proxy rule for executing Appwrite Function on custom domain.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param domain Domain name.
     * @param functionId ID of function to be executed.
     * @param branch Name of VCS branch to deploy changes automatically
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createFunctionRule(
        domain: String,
        functionId: String,
        branch: String? = null,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/function"


        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
            "functionId" to functionId,
            "branch" to branch,
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
            responseType = io.appwrite.models.ProxyRule::class,
            serializer = io.appwrite.models.ProxyRule.serializer()
        )
    }

            /**
     * Create Redirect rule
     *
     * Create a new proxy rule for to redirect from custom domain to another domain.
     *
    @Throws(Throwable::class)
     * @param domain Domain name.
     * @param url Target URL of redirection
     * @param statusCode Status code of redirection
     * @param resourceId ID of parent resource.
     * @param resourceType Type of parent resource.
     */
    @Throws(Throwable::class)
    suspend fun createRedirectRule(
        domain: String,
        url: String,
        statusCode: io.appwrite.enums.StatusCode,
        resourceId: String,
        resourceType: io.appwrite.enums.ProxyResourceType,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/redirect"


        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
            "url" to url,
            "statusCode" to statusCode,
            "resourceId" to resourceId,
            "resourceType" to resourceType,
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
            responseType = io.appwrite.models.ProxyRule::class,
            serializer = io.appwrite.models.ProxyRule.serializer()
        )
    }

            /**
     * Create site rule
     *
     * Create a new proxy rule for serving Appwrite Site on custom domain.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param domain Domain name.
     * @param siteId ID of site to be executed.
     * @param branch Name of VCS branch to deploy changes automatically
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createSiteRule(
        domain: String,
        siteId: String,
        branch: String? = null,
    ): io.appwrite.models.ProxyRule {
        val apiPath = "/proxy/rules/site"


        val apiParams = mutableMapOf<String, Any?>(
            "domain" to domain,
            "siteId" to siteId,
            "branch" to branch,
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
