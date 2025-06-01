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
 * The Project service allows you to manage all the projects in your Appwrite server.
 **/
class Projects(client: Client) : Service(client) {
        /**
     * List projects
     *
     * Get a list of all projects. You can use the query params to filter your results. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, teamId
     * @param search Search term to filter your list results. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.ProjectList {
        val apiPath = "/projects"


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
            responseType = io.appwrite.models.ProjectList::class,
            serializer = io.appwrite.models.ProjectList.serializer()
        )
    }

            /**
     * Create project
     *
     * Create a new project. You can create a maximum of 100 projects per account. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, and hyphen. Can't start with a special char. Max length is 36 chars.
     * @param name Project name. Max length: 128 chars.
     * @param teamId Team unique ID.
     * @param region Project Region.
     * @param description Project description. Max length: 256 chars.
     * @param logo Project logo.
     * @param url Project URL.
     * @param legalName Project legal Name. Max length: 256 chars.
     * @param legalCountry Project legal Country. Max length: 256 chars.
     * @param legalState Project legal State. Max length: 256 chars.
     * @param legalCity Project legal City. Max length: 256 chars.
     * @param legalAddress Project legal Address. Max length: 256 chars.
     * @param legalTaxId Project legal Tax ID. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun create(
        projectId: String,
        name: String,
        teamId: String,
        region: io.appwrite.enums.Region? = null,
        description: String? = null,
        logo: String? = null,
        url: String? = null,
        legalName: String? = null,
        legalCountry: String? = null,
        legalState: String? = null,
        legalCity: String? = null,
        legalAddress: String? = null,
        legalTaxId: String? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/projects"


        val apiParams = mutableMapOf<String, Any?>(
            "projectId" to projectId,
            "name" to name,
            "teamId" to teamId,
            "region" to region,
            "description" to description,
            "logo" to logo,
            "url" to url,
            "legalName" to legalName,
            "legalCountry" to legalCountry,
            "legalState" to legalState,
            "legalCity" to legalCity,
            "legalAddress" to legalAddress,
            "legalTaxId" to legalTaxId,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Get project
     *
     * Get a project by its unique ID. This endpoint allows you to retrieve the project&#039;s details, including its name, description, team, region, and other metadata. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     */
    @Throws(Throwable::class)
    suspend fun get(
        projectId: String,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}"
            .replace("{projectId}", projectId)


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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update project
     *
     * Update a project by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param name Project name. Max length: 128 chars.
     * @param description Project description. Max length: 256 chars.
     * @param logo Project logo.
     * @param url Project URL.
     * @param legalName Project legal name. Max length: 256 chars.
     * @param legalCountry Project legal country. Max length: 256 chars.
     * @param legalState Project legal state. Max length: 256 chars.
     * @param legalCity Project legal city. Max length: 256 chars.
     * @param legalAddress Project legal address. Max length: 256 chars.
     * @param legalTaxId Project legal tax ID. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun update(
        projectId: String,
        name: String,
        description: String? = null,
        logo: String? = null,
        url: String? = null,
        legalName: String? = null,
        legalCountry: String? = null,
        legalState: String? = null,
        legalCity: String? = null,
        legalAddress: String? = null,
        legalTaxId: String? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "description" to description,
            "logo" to logo,
            "url" to url,
            "legalName" to legalName,
            "legalCountry" to legalCountry,
            "legalState" to legalState,
            "legalCity" to legalCity,
            "legalAddress" to legalAddress,
            "legalTaxId" to legalTaxId,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Delete project
     *
     * Delete a project by its unique ID.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     */
    @Throws(Throwable::class)
    suspend fun delete(
        projectId: String,
    ): Any {
        val apiPath = "/projects/{projectId}"
            .replace("{projectId}", projectId)


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
     * Update API status
     *
     * Update the status of a specific API type. Use this endpoint to enable or disable API types such as REST, GraphQL and Realtime.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param api API name.
     * @param status API status.
     */
    @Throws(Throwable::class)
    suspend fun updateApiStatus(
        projectId: String,
        api: io.appwrite.enums.Api,
        status: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/api"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "api" to api,
            "status" to status,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update all API status
     *
     * Update the status of all API types. Use this endpoint to enable or disable API types such as REST, GraphQL and Realtime all at once.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param status API status.
     */
    @Throws(Throwable::class)
    suspend fun updateApiStatusAll(
        projectId: String,
        status: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/api/all"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "status" to status,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update project authentication duration
     *
     * Update how long sessions created within a project should stay active for.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param duration Project session length in seconds. Max length: 31536000 seconds.
     */
    @Throws(Throwable::class)
    suspend fun updateAuthDuration(
        projectId: String,
        duration: Long,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/duration"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "duration" to duration,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update project users limit
     *
     * Update the maximum number of users allowed in this project. Set to 0 for unlimited users. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param limit Set the max number of users allowed in this project. Use 0 for unlimited.
     */
    @Throws(Throwable::class)
    suspend fun updateAuthLimit(
        projectId: String,
        limit: Long,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/limit"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "limit" to limit,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update project user sessions limit
     *
     * Update the maximum number of sessions allowed per user within the project, if the limit is hit the oldest session will be deleted to make room for new sessions.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param limit Set the max number of users allowed in this project. Value allowed is between 1-100. Default is 10
     */
    @Throws(Throwable::class)
    suspend fun updateAuthSessionsLimit(
        projectId: String,
        limit: Long,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/max-sessions"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "limit" to limit,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update project memberships privacy attributes
     *
     * Update project membership privacy settings. Use this endpoint to control what user information is visible to other team members, such as user name, email, and MFA status. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param userName Set to true to show userName to members of a team.
     * @param userEmail Set to true to show email to members of a team.
     * @param mfa Set to true to show mfa to members of a team.
     */
    @Throws(Throwable::class)
    suspend fun updateMembershipsPrivacy(
        projectId: String,
        userName: Boolean,
        userEmail: Boolean,
        mfa: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/memberships-privacy"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "userName" to userName,
            "userEmail" to userEmail,
            "mfa" to mfa,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update the mock numbers for the project
     *
     * Update the list of mock phone numbers for testing. Use these numbers to bypass SMS verification in development. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param numbers An array of mock numbers and their corresponding verification codes (OTPs). Each number should be a valid E.164 formatted phone number. Maximum of 10 numbers are allowed.
     */
    @Throws(Throwable::class)
    suspend fun updateMockNumbers(
        projectId: String,
        numbers: List<Any>,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/mock-numbers"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "numbers" to numbers,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update authentication password dictionary status. Use this endpoint to enable or disable the dicitonary check for user password
     *
     * Enable or disable checking user passwords against common passwords dictionary. This helps ensure users don&#039;t use common and insecure passwords. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param enabled Set whether or not to enable checking user's password against most commonly used passwords. Default is false.
     */
    @Throws(Throwable::class)
    suspend fun updateAuthPasswordDictionary(
        projectId: String,
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/password-dictionary"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "enabled" to enabled,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update authentication password history. Use this endpoint to set the number of password history to save and 0 to disable password history.
     *
     * Update the authentication password history requirement. Use this endpoint to require new passwords to be different than the last X amount of previously used ones.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param limit Set the max number of passwords to store in user history. User can't choose a new password that is already stored in the password history list.  Max number of passwords allowed in history is20. Default value is 0
     */
    @Throws(Throwable::class)
    suspend fun updateAuthPasswordHistory(
        projectId: String,
        limit: Long,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/password-history"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "limit" to limit,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update personal data check
     *
     * Enable or disable checking user passwords against their personal data. This helps prevent users from using personal information in their passwords. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param enabled Set whether or not to check a password for similarity with personal data. Default is false.
     */
    @Throws(Throwable::class)
    suspend fun updatePersonalDataCheck(
        projectId: String,
        enabled: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/personal-data"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "enabled" to enabled,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update project sessions emails
     *
     * Enable or disable session email alerts. When enabled, users will receive email notifications when new sessions are created.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param alerts Set to true to enable session emails.
     */
    @Throws(Throwable::class)
    suspend fun updateSessionAlerts(
        projectId: String,
        alerts: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/session-alerts"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "alerts" to alerts,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update project auth method status. Use this endpoint to enable or disable a given auth method for this project.
     *
     * Update the status of a specific authentication method. Use this endpoint to enable or disable different authentication methods such as email, magic urls or sms in your project. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param method Auth Method. Possible values: email-password,magic-url,email-otp,anonymous,invites,jwt,phone
     * @param status Set the status of this auth method.
     */
    @Throws(Throwable::class)
    suspend fun updateAuthStatus(
        projectId: String,
        method: io.appwrite.enums.AuthMethod,
        status: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/auth/{method}"
            .replace("{projectId}", projectId)
            .replace("{method}", method.value)


        val apiParams = mutableMapOf<String, Any?>(
            "status" to status,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Create JWT
     *
     * Create a new JWT token. This token can be used to authenticate users with custom scopes and expiration time. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param scopes List of scopes allowed for JWT key. Maximum of 100 scopes are allowed.
     * @param duration Time in seconds before JWT expires. Default duration is 900 seconds, and maximum is 3600 seconds.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createJWT(
        projectId: String,
        scopes: List<String>,
        duration: Long? = null,
    ): io.appwrite.models.Jwt {
        val apiPath = "/projects/{projectId}/jwts"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "scopes" to scopes,
            "duration" to duration,
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
            responseType = io.appwrite.models.Jwt::class,
            serializer = io.appwrite.models.Jwt.serializer()
        )
    }

            /**
     * List keys
     *
     * Get a list of all API keys from the current project. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     */
    @Throws(Throwable::class)
    suspend fun listKeys(
        projectId: String,
    ): io.appwrite.models.KeyList {
        val apiPath = "/projects/{projectId}/keys"
            .replace("{projectId}", projectId)


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
            responseType = io.appwrite.models.KeyList::class,
            serializer = io.appwrite.models.KeyList.serializer()
        )
    }

            /**
     * Create key
     *
     * Create a new API key. It&#039;s recommended to have multiple API keys with strict scopes for separate functions within your project.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param name Key name. Max length: 128 chars.
     * @param scopes Key scopes list. Maximum of 100 scopes are allowed.
     * @param expire Expiration time in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. Use null for unlimited expiration.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createKey(
        projectId: String,
        name: String,
        scopes: List<String>,
        expire: String? = null,
    ): io.appwrite.models.Key {
        val apiPath = "/projects/{projectId}/keys"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "scopes" to scopes,
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
            responseType = io.appwrite.models.Key::class,
            serializer = io.appwrite.models.Key.serializer()
        )
    }

            /**
     * Get key
     *
     * Get a key by its unique ID. This endpoint returns details about a specific API key in your project including it&#039;s scopes.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param keyId Key unique ID.
     */
    @Throws(Throwable::class)
    suspend fun getKey(
        projectId: String,
        keyId: String,
    ): io.appwrite.models.Key {
        val apiPath = "/projects/{projectId}/keys/{keyId}"
            .replace("{projectId}", projectId)
            .replace("{keyId}", keyId)


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
            responseType = io.appwrite.models.Key::class,
            serializer = io.appwrite.models.Key.serializer()
        )
    }

            /**
     * Update key
     *
     * Update a key by its unique ID. Use this endpoint to update the name, scopes, or expiration time of an API key. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param keyId Key unique ID.
     * @param name Key name. Max length: 128 chars.
     * @param scopes Key scopes list. Maximum of 100 events are allowed.
     * @param expire Expiration time in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. Use null for unlimited expiration.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateKey(
        projectId: String,
        keyId: String,
        name: String,
        scopes: List<String>,
        expire: String? = null,
    ): io.appwrite.models.Key {
        val apiPath = "/projects/{projectId}/keys/{keyId}"
            .replace("{projectId}", projectId)
            .replace("{keyId}", keyId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "scopes" to scopes,
            "expire" to expire,
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
            responseType = io.appwrite.models.Key::class,
            serializer = io.appwrite.models.Key.serializer()
        )
    }

            /**
     * Delete key
     *
     * Delete a key by its unique ID. Once deleted, the key can no longer be used to authenticate API calls. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param keyId Key unique ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteKey(
        projectId: String,
        keyId: String,
    ): Any {
        val apiPath = "/projects/{projectId}/keys/{keyId}"
            .replace("{projectId}", projectId)
            .replace("{keyId}", keyId)


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
     * Update project OAuth2
     *
     * Update the OAuth2 provider configurations. Use this endpoint to set up or update the OAuth2 provider credentials or enable/disable providers. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param provider Provider Name
     * @param appId Provider app ID. Max length: 256 chars.
     * @param secret Provider secret key. Max length: 512 chars.
     * @param enabled Provider status. Set to 'false' to disable new session creation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateOAuth2(
        projectId: String,
        provider: io.appwrite.enums.OAuthProvider,
        appId: String? = null,
        secret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/oauth2"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "provider" to provider,
            "appId" to appId,
            "secret" to secret,
            "enabled" to enabled,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * List platforms
     *
     * Get a list of all platforms in the project. This endpoint returns an array of all platforms and their configurations. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     */
    @Throws(Throwable::class)
    suspend fun listPlatforms(
        projectId: String,
    ): io.appwrite.models.PlatformList {
        val apiPath = "/projects/{projectId}/platforms"
            .replace("{projectId}", projectId)


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
            responseType = io.appwrite.models.PlatformList::class,
            serializer = io.appwrite.models.PlatformList.serializer()
        )
    }

            /**
     * Create platform
     *
     * Create a new platform for your project. Use this endpoint to register a new platform where your users will run your application which will interact with the Appwrite API.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param type Platform type.
     * @param name Platform name. Max length: 128 chars.
     * @param key Package name for Android or bundle ID for iOS or macOS. Max length: 256 chars.
     * @param store App store or Google Play store ID. Max length: 256 chars.
     * @param hostname Platform client hostname. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createPlatform(
        projectId: String,
        type: io.appwrite.enums.PlatformType,
        name: String,
        key: String? = null,
        store: String? = null,
        hostname: String? = null,
    ): io.appwrite.models.Platform {
        val apiPath = "/projects/{projectId}/platforms"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "type" to type,
            "name" to name,
            "key" to key,
            "store" to store,
            "hostname" to hostname,
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
            responseType = io.appwrite.models.Platform::class,
            serializer = io.appwrite.models.Platform.serializer()
        )
    }

            /**
     * Get platform
     *
     * Get a platform by its unique ID. This endpoint returns the platform&#039;s details, including its name, type, and key configurations. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param platformId Platform unique ID.
     */
    @Throws(Throwable::class)
    suspend fun getPlatform(
        projectId: String,
        platformId: String,
    ): io.appwrite.models.Platform {
        val apiPath = "/projects/{projectId}/platforms/{platformId}"
            .replace("{projectId}", projectId)
            .replace("{platformId}", platformId)


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
            responseType = io.appwrite.models.Platform::class,
            serializer = io.appwrite.models.Platform.serializer()
        )
    }

            /**
     * Update platform
     *
     * Update a platform by its unique ID. Use this endpoint to update the platform&#039;s name, key, platform store ID, or hostname. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param platformId Platform unique ID.
     * @param name Platform name. Max length: 128 chars.
     * @param key Package name for android or bundle ID for iOS. Max length: 256 chars.
     * @param store App store or Google Play store ID. Max length: 256 chars.
     * @param hostname Platform client URL. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updatePlatform(
        projectId: String,
        platformId: String,
        name: String,
        key: String? = null,
        store: String? = null,
        hostname: String? = null,
    ): io.appwrite.models.Platform {
        val apiPath = "/projects/{projectId}/platforms/{platformId}"
            .replace("{projectId}", projectId)
            .replace("{platformId}", platformId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "key" to key,
            "store" to store,
            "hostname" to hostname,
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
            responseType = io.appwrite.models.Platform::class,
            serializer = io.appwrite.models.Platform.serializer()
        )
    }

            /**
     * Delete platform
     *
     * Delete a platform by its unique ID. This endpoint removes the platform and all its configurations from the project. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param platformId Platform unique ID.
     */
    @Throws(Throwable::class)
    suspend fun deletePlatform(
        projectId: String,
        platformId: String,
    ): Any {
        val apiPath = "/projects/{projectId}/platforms/{platformId}"
            .replace("{projectId}", projectId)
            .replace("{platformId}", platformId)


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
     * Update service status
     *
     * Update the status of a specific service. Use this endpoint to enable or disable a service in your project. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param service Service name.
     * @param status Service status.
     */
    @Throws(Throwable::class)
    suspend fun updateServiceStatus(
        projectId: String,
        service: io.appwrite.enums.ApiService,
        status: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/service"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "service" to service,
            "status" to status,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update all service status
     *
     * Update the status of all services. Use this endpoint to enable or disable all optional services at once. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param status Service status.
     */
    @Throws(Throwable::class)
    suspend fun updateServiceStatusAll(
        projectId: String,
        status: Boolean,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/service/all"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "status" to status,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Update SMTP
     *
     * Update the SMTP configuration for your project. Use this endpoint to configure your project&#039;s SMTP provider with your custom settings for sending transactional emails. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param enabled Enable custom SMTP service
     * @param senderName Name of the email sender
     * @param senderEmail Email of the sender
     * @param replyTo Reply to email
     * @param host SMTP server host name
     * @param port SMTP server port
     * @param username SMTP server username
     * @param password SMTP server password
     * @param secure Does SMTP server use secure connection
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateSmtp(
        projectId: String,
        enabled: Boolean,
        senderName: String? = null,
        senderEmail: String? = null,
        replyTo: String? = null,
        host: String? = null,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        secure: io.appwrite.enums.SMTPSecure? = null,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/smtp"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "enabled" to enabled,
            "senderName" to senderName,
            "senderEmail" to senderEmail,
            "replyTo" to replyTo,
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "secure" to secure,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Create SMTP test
     *
     * Send a test email to verify SMTP configuration. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param emails Array of emails to send test email to. Maximum of 10 emails are allowed.
     * @param senderName Name of the email sender
     * @param senderEmail Email of the sender
     * @param host SMTP server host name
     * @param replyTo Reply to email
     * @param port SMTP server port
     * @param username SMTP server username
     * @param password SMTP server password
     * @param secure Does SMTP server use secure connection
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createSmtpTest(
        projectId: String,
        emails: List<String>,
        senderName: String,
        senderEmail: String,
        host: String,
        replyTo: String? = null,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        secure: io.appwrite.enums.SMTPSecure? = null,
    ): Any {
        val apiPath = "/projects/{projectId}/smtp/tests"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "emails" to emails,
            "senderName" to senderName,
            "senderEmail" to senderEmail,
            "replyTo" to replyTo,
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "secure" to secure,
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
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

            /**
     * Update project team
     *
     * Update the team ID of a project allowing for it to be transferred to another team.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param teamId Team ID of the team to transfer project to.
     */
    @Throws(Throwable::class)
    suspend fun updateTeam(
        projectId: String,
        teamId: String,
    ): io.appwrite.models.Project {
        val apiPath = "/projects/{projectId}/team"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "teamId" to teamId,
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
            responseType = io.appwrite.models.Project::class,
            serializer = io.appwrite.models.Project.serializer()
        )
    }

            /**
     * Get custom email template
     *
     * Get a custom email template for the specified locale and type. This endpoint returns the template content, subject, and other configuration details. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param type Template type
     * @param locale Template locale
     */
    @Throws(Throwable::class)
    suspend fun getEmailTemplate(
        projectId: String,
        type: io.appwrite.enums.EmailTemplateType,
        locale: io.appwrite.enums.EmailTemplateLocale,
    ): io.appwrite.models.EmailTemplate {
        val apiPath = "/projects/{projectId}/templates/email/{type}/{locale}"
            .replace("{projectId}", projectId)
            .replace("{type}", type.value)
            .replace("{locale}", locale.value)


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
            responseType = io.appwrite.models.EmailTemplate::class,
            serializer = io.appwrite.models.EmailTemplate.serializer()
        )
    }

            /**
     * Update custom email templates
     *
     * Update a custom email template for the specified locale and type. Use this endpoint to modify the content of your email templates.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param type Template type
     * @param locale Template locale
     * @param subject Email Subject
     * @param message Template message
     * @param senderName Name of the email sender
     * @param senderEmail Email of the sender
     * @param replyTo Reply to email
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateEmailTemplate(
        projectId: String,
        type: io.appwrite.enums.EmailTemplateType,
        locale: io.appwrite.enums.EmailTemplateLocale,
        subject: String,
        message: String,
        senderName: String? = null,
        senderEmail: String? = null,
        replyTo: String? = null,
    ): io.appwrite.models.EmailTemplate {
        val apiPath = "/projects/{projectId}/templates/email/{type}/{locale}"
            .replace("{projectId}", projectId)
            .replace("{type}", type.value)
            .replace("{locale}", locale.value)


        val apiParams = mutableMapOf<String, Any?>(
            "subject" to subject,
            "message" to message,
            "senderName" to senderName,
            "senderEmail" to senderEmail,
            "replyTo" to replyTo,
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
            responseType = io.appwrite.models.EmailTemplate::class,
            serializer = io.appwrite.models.EmailTemplate.serializer()
        )
    }

            /**
     * Delete custom email template
     *
     * Reset a custom email template to its default value. This endpoint removes any custom content and restores the template to its original state. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param type Template type
     * @param locale Template locale
     */
    @Throws(Throwable::class)
    suspend fun deleteEmailTemplate(
        projectId: String,
        type: io.appwrite.enums.EmailTemplateType,
        locale: io.appwrite.enums.EmailTemplateLocale,
    ): io.appwrite.models.EmailTemplate {
        val apiPath = "/projects/{projectId}/templates/email/{type}/{locale}"
            .replace("{projectId}", projectId)
            .replace("{type}", type.value)
            .replace("{locale}", locale.value)


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
            responseType = io.appwrite.models.EmailTemplate::class,
            serializer = io.appwrite.models.EmailTemplate.serializer()
        )
    }

            /**
     * Get custom SMS template
     *
     * Get a custom SMS template for the specified locale and type returning it&#039;s contents.
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param type Template type
     * @param locale Template locale
     */
    @Throws(Throwable::class)
    suspend fun getSmsTemplate(
        projectId: String,
        type: io.appwrite.enums.SmsTemplateType,
        locale: io.appwrite.enums.SmsTemplateLocale,
    ): io.appwrite.models.SmsTemplate {
        val apiPath = "/projects/{projectId}/templates/sms/{type}/{locale}"
            .replace("{projectId}", projectId)
            .replace("{type}", type.value)
            .replace("{locale}", locale.value)


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
            responseType = io.appwrite.models.SmsTemplate::class,
            serializer = io.appwrite.models.SmsTemplate.serializer()
        )
    }

            /**
     * Update custom SMS template
     *
     * Update a custom SMS template for the specified locale and type. Use this endpoint to modify the content of your SMS templates. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param type Template type
     * @param locale Template locale
     * @param message Template message
     */
    @Throws(Throwable::class)
    suspend fun updateSmsTemplate(
        projectId: String,
        type: io.appwrite.enums.SmsTemplateType,
        locale: io.appwrite.enums.SmsTemplateLocale,
        message: String,
    ): io.appwrite.models.SmsTemplate {
        val apiPath = "/projects/{projectId}/templates/sms/{type}/{locale}"
            .replace("{projectId}", projectId)
            .replace("{type}", type.value)
            .replace("{locale}", locale.value)


        val apiParams = mutableMapOf<String, Any?>(
            "message" to message,
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
            responseType = io.appwrite.models.SmsTemplate::class,
            serializer = io.appwrite.models.SmsTemplate.serializer()
        )
    }

            /**
     * Reset custom SMS template
     *
     * Reset a custom SMS template to its default value. This endpoint removes any custom message and restores the template to its original state. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param type Template type
     * @param locale Template locale
     */
    @Throws(Throwable::class)
    suspend fun deleteSmsTemplate(
        projectId: String,
        type: io.appwrite.enums.SmsTemplateType,
        locale: io.appwrite.enums.SmsTemplateLocale,
    ): io.appwrite.models.SmsTemplate {
        val apiPath = "/projects/{projectId}/templates/sms/{type}/{locale}"
            .replace("{projectId}", projectId)
            .replace("{type}", type.value)
            .replace("{locale}", locale.value)


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
            responseType = io.appwrite.models.SmsTemplate::class,
            serializer = io.appwrite.models.SmsTemplate.serializer()
        )
    }

            /**
     * List webhooks
     *
     * Get a list of all webhooks belonging to the project. You can use the query params to filter your results. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     */
    @Throws(Throwable::class)
    suspend fun listWebhooks(
        projectId: String,
    ): io.appwrite.models.WebhookList {
        val apiPath = "/projects/{projectId}/webhooks"
            .replace("{projectId}", projectId)


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
            responseType = io.appwrite.models.WebhookList::class,
            serializer = io.appwrite.models.WebhookList.serializer()
        )
    }

            /**
     * Create webhook
     *
     * Create a new webhook. Use this endpoint to configure a URL that will receive events from Appwrite when specific events occur. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param name Webhook name. Max length: 128 chars.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param url Webhook URL.
     * @param security Certificate verification, false for disabled or true for enabled.
     * @param enabled Enable or disable a webhook.
     * @param httpUser Webhook HTTP user. Max length: 256 chars.
     * @param httpPass Webhook HTTP password. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createWebhook(
        projectId: String,
        name: String,
        events: List<String>,
        url: String,
        security: Boolean,
        enabled: Boolean? = null,
        httpUser: String? = null,
        httpPass: String? = null,
    ): io.appwrite.models.Webhook {
        val apiPath = "/projects/{projectId}/webhooks"
            .replace("{projectId}", projectId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "events" to events,
            "url" to url,
            "security" to security,
            "httpUser" to httpUser,
            "httpPass" to httpPass,
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
            responseType = io.appwrite.models.Webhook::class,
            serializer = io.appwrite.models.Webhook.serializer()
        )
    }

            /**
     * Get webhook
     *
     * Get a webhook by its unique ID. This endpoint returns details about a specific webhook configured for a project. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param webhookId Webhook unique ID.
     */
    @Throws(Throwable::class)
    suspend fun getWebhook(
        projectId: String,
        webhookId: String,
    ): io.appwrite.models.Webhook {
        val apiPath = "/projects/{projectId}/webhooks/{webhookId}"
            .replace("{projectId}", projectId)
            .replace("{webhookId}", webhookId)


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
            responseType = io.appwrite.models.Webhook::class,
            serializer = io.appwrite.models.Webhook.serializer()
        )
    }

            /**
     * Update webhook
     *
     * Update a webhook by its unique ID. Use this endpoint to update the URL, events, or status of an existing webhook. 
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param webhookId Webhook unique ID.
     * @param name Webhook name. Max length: 128 chars.
     * @param events Events list. Maximum of 100 events are allowed.
     * @param url Webhook URL.
     * @param security Certificate verification, false for disabled or true for enabled.
     * @param enabled Enable or disable a webhook.
     * @param httpUser Webhook HTTP user. Max length: 256 chars.
     * @param httpPass Webhook HTTP password. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateWebhook(
        projectId: String,
        webhookId: String,
        name: String,
        events: List<String>,
        url: String,
        security: Boolean,
        enabled: Boolean? = null,
        httpUser: String? = null,
        httpPass: String? = null,
    ): io.appwrite.models.Webhook {
        val apiPath = "/projects/{projectId}/webhooks/{webhookId}"
            .replace("{projectId}", projectId)
            .replace("{webhookId}", webhookId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "events" to events,
            "url" to url,
            "security" to security,
            "httpUser" to httpUser,
            "httpPass" to httpPass,
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
            responseType = io.appwrite.models.Webhook::class,
            serializer = io.appwrite.models.Webhook.serializer()
        )
    }

            /**
     * Delete webhook
     *
     * Delete a webhook by its unique ID. Once deleted, the webhook will no longer receive project events. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param webhookId Webhook unique ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteWebhook(
        projectId: String,
        webhookId: String,
    ): Any {
        val apiPath = "/projects/{projectId}/webhooks/{webhookId}"
            .replace("{projectId}", projectId)
            .replace("{webhookId}", webhookId)


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
     * Update webhook signature key
     *
     * Update the webhook signature key. This endpoint can be used to regenerate the signature key used to sign and validate payload deliveries for a specific webhook. 
     *
    @Throws(Throwable::class)
     * @param projectId Project unique ID.
     * @param webhookId Webhook unique ID.
     */
    @Throws(Throwable::class)
    suspend fun updateWebhookSignature(
        projectId: String,
        webhookId: String,
    ): io.appwrite.models.Webhook {
        val apiPath = "/projects/{projectId}/webhooks/{webhookId}/signature"
            .replace("{projectId}", projectId)
            .replace("{webhookId}", webhookId)


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
            responseType = io.appwrite.models.Webhook::class,
            serializer = io.appwrite.models.Webhook.serializer()
        )
    }

    }
