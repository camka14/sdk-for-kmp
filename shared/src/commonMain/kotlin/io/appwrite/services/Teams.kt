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
 * The Teams service allows you to group users of your project and to enable them to share read and write access to your project resources
 **/
class Teams(client: Client) : Service(client) {
        /**
     * List teams
     *
     * Get a list of all the teams in which the current user is a member. You can use the parameters to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, total, billingPlan
     * @param search Search term to filter your list results. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> list(
        queries: List<String>? = null,
        search: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.TeamList<T> {
        val apiPath = "/teams"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

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
            responseType = classOf(),
            serializer = io.appwrite.models.TeamList.serializer(actualSerializer)
        )
    }

    /**
     * List teams
     *
     * Get a list of all the teams in which the current user is a member. You can use the parameters to filter your results.
     *
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, total, billingPlan
     * @param search Search term to filter your list results. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.TeamList<Map<String, Any>> = list(
        queries,
        search,
        nestedType = classOf(),
    )
            /**
     * Create team
     *
     * Create a new team. The user who creates the team will automatically be assigned as the owner of the team. Only the users with the owner role can invite new members, add new owners and delete or update the team.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param teamId Team ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Team name. Max length: 128 chars.
     * @param roles Array of strings. Use this param to set the roles in the team for the user who created it. The default role is **owner**. A role can be any string. Learn more about [roles and permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 32 characters long.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> create(
        teamId: String,
        name: String,
        roles: List<String>? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Team<T> {
        val apiPath = "/teams"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "teamId" to teamId,
            "name" to name,
            "roles" to roles,
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
            responseType = classOf(),
            serializer = io.appwrite.models.Team.serializer(actualSerializer)
        )
    }

    /**
     * Create team
     *
     * Create a new team. The user who creates the team will automatically be assigned as the owner of the team. Only the users with the owner role can invite new members, add new owners and delete or update the team.
     *
     * @param teamId Team ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Team name. Max length: 128 chars.
     * @param roles Array of strings. Use this param to set the roles in the team for the user who created it. The default role is **owner**. A role can be any string. Learn more about [roles and permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 32 characters long.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun create(
        teamId: String,
        name: String,
        roles: List<String>? = null,
    ): io.appwrite.models.Team<Map<String, Any>> = create(
        teamId,
        name,
        roles,
        nestedType = classOf(),
    )
            /**
     * Get team
     *
     * Get a team by its ID. All team members have read access for this resource.
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> get(
        teamId: String,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Team<T> {
        val apiPath = "/teams/{teamId}"
            .replace("{teamId}", teamId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

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
            responseType = classOf(),
            serializer = io.appwrite.models.Team.serializer(actualSerializer)
        )
    }

    /**
     * Get team
     *
     * Get a team by its ID. All team members have read access for this resource.
     *
     * @param teamId Team ID.
     */
    @Throws(Throwable::class)
    suspend fun get(
        teamId: String,
    ): io.appwrite.models.Team<Map<String, Any>> = get(
        teamId,
        nestedType = classOf(),
    )
            /**
     * Update name
     *
     * Update the team&#039;s name by its unique ID.
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param name New team name. Max length: 128 chars.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updateName(
        teamId: String,
        name: String,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Team<T> {
        val apiPath = "/teams/{teamId}"
            .replace("{teamId}", teamId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
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
            responseType = classOf(),
            serializer = io.appwrite.models.Team.serializer(actualSerializer)
        )
    }

    /**
     * Update name
     *
     * Update the team&#039;s name by its unique ID.
     *
     * @param teamId Team ID.
     * @param name New team name. Max length: 128 chars.
     */
    @Throws(Throwable::class)
    suspend fun updateName(
        teamId: String,
        name: String,
    ): io.appwrite.models.Team<Map<String, Any>> = updateName(
        teamId,
        name,
        nestedType = classOf(),
    )
            /**
     * Delete team
     *
     * Delete a team using its ID. Only team members with the owner role can delete the team.
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     */
    @Throws(Throwable::class)
    suspend fun delete(
        teamId: String,
    ): Any {
        val apiPath = "/teams/{teamId}"
            .replace("{teamId}", teamId)


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
     * List team logs
     *
     * Get the team activity logs list by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listLogs(
        teamId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/teams/{teamId}/logs"
            .replace("{teamId}", teamId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class,
            serializer = io.appwrite.models.LogList.serializer()
        )
    }

            /**
     * List team memberships
     *
     * Use this endpoint to list a team&#039;s members using the team&#039;s ID. All team members have read access to this endpoint. Hide sensitive attributes from the response by toggling membership privacy in the Console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: userId, teamId, invited, joined, confirm
     * @param search Search term to filter your list results. Max length: 256 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listMemberships(
        teamId: String,
        queries: List<String>? = null,
        search: String? = null,
    ): io.appwrite.models.MembershipList {
        val apiPath = "/teams/{teamId}/memberships"
            .replace("{teamId}", teamId)


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
            responseType = io.appwrite.models.MembershipList::class,
            serializer = io.appwrite.models.MembershipList.serializer()
        )
    }

            /**
     * Create team membership
     *
     * Invite a new member to join your team. Provide an ID for existing users, or invite unregistered users using an email or phone number. If initiated from a Client SDK, Appwrite will send an email or sms with a link to join the team to the invited user, and an account will be created for them if one doesn&#039;t exist. If initiated from a Server SDK, the new member will be added automatically to the team.You only need to provide one of a user ID, email, or phone number. Appwrite will prioritize accepting the user ID &gt; email &gt; phone number if you provide more than one of these parameters.Use the `url` parameter to redirect the user from the invitation email to your app. After the user is redirected, use the [Update Team Membership Status](https://appwrite.io/docs/references/cloud/client-web/teams#updateMembershipStatus) endpoint to allow the user to accept the invitation to the team. Please note that to avoid a [Redirect Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md) Appwrite will accept the only redirect URLs under the domains you have added as a platform on the Appwrite Console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param roles Array of strings. Use this param to set the user roles in the team. A role can be any string. Learn more about [roles and permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 32 characters long.
     * @param email Email of the new team member.
     * @param userId ID of the user to be added to a team.
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param url URL to redirect the user back to your app from the invitation email. This parameter is not required when an API key is supplied. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param name Name of the new team member. Max length: 128 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createMembership(
        teamId: String,
        roles: List<String>,
        email: String? = null,
        userId: String? = null,
        phone: String? = null,
        url: String? = null,
        name: String? = null,
    ): io.appwrite.models.Membership {
        val apiPath = "/teams/{teamId}/memberships"
            .replace("{teamId}", teamId)


        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
            "userId" to userId,
            "phone" to phone,
            "roles" to roles,
            "url" to url,
            "name" to name,
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
            responseType = io.appwrite.models.Membership::class,
            serializer = io.appwrite.models.Membership.serializer()
        )
    }

            /**
     * Get team membership
     *
     * Get a team member by the membership unique id. All team members have read access for this resource. Hide sensitive attributes from the response by toggling membership privacy in the Console.
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param membershipId Membership ID.
     */
    @Throws(Throwable::class)
    suspend fun getMembership(
        teamId: String,
        membershipId: String,
    ): io.appwrite.models.Membership {
        val apiPath = "/teams/{teamId}/memberships/{membershipId}"
            .replace("{teamId}", teamId)
            .replace("{membershipId}", membershipId)


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
            responseType = io.appwrite.models.Membership::class,
            serializer = io.appwrite.models.Membership.serializer()
        )
    }

            /**
     * Update membership
     *
     * Modify the roles of a team member. Only team members with the owner role have access to this endpoint. Learn more about [roles and permissions](https://appwrite.io/docs/permissions).
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param membershipId Membership ID.
     * @param roles An array of strings. Use this param to set the user's roles in the team. A role can be any string. Learn more about [roles and permissions](https://appwrite.io/docs/permissions). Maximum of 100 roles are allowed, each 32 characters long.
     */
    @Throws(Throwable::class)
    suspend fun updateMembership(
        teamId: String,
        membershipId: String,
        roles: List<String>,
    ): io.appwrite.models.Membership {
        val apiPath = "/teams/{teamId}/memberships/{membershipId}"
            .replace("{teamId}", teamId)
            .replace("{membershipId}", membershipId)


        val apiParams = mutableMapOf<String, Any?>(
            "roles" to roles,
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
            responseType = io.appwrite.models.Membership::class,
            serializer = io.appwrite.models.Membership.serializer()
        )
    }

            /**
     * Delete team membership
     *
     * This endpoint allows a user to leave a team or for a team owner to delete the membership of any other team member. You can also use this endpoint to delete a user membership even if it is not accepted.
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param membershipId Membership ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteMembership(
        teamId: String,
        membershipId: String,
    ): Any {
        val apiPath = "/teams/{teamId}/memberships/{membershipId}"
            .replace("{teamId}", teamId)
            .replace("{membershipId}", membershipId)


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
     * Update team membership status
     *
     * Use this endpoint to allow a user to accept an invitation to join a team after being redirected back to your app from the invitation email received by the user.If the request is successful, a session for the user is automatically created.
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param membershipId Membership ID.
     * @param userId User ID.
     * @param secret Secret key.
     */
    @Throws(Throwable::class)
    suspend fun updateMembershipStatus(
        teamId: String,
        membershipId: String,
        userId: String,
        secret: String,
    ): io.appwrite.models.Membership {
        val apiPath = "/teams/{teamId}/memberships/{membershipId}/status"
            .replace("{teamId}", teamId)
            .replace("{membershipId}", membershipId)


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
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
            responseType = io.appwrite.models.Membership::class,
            serializer = io.appwrite.models.Membership.serializer()
        )
    }

            /**
     * Get team preferences
     *
     * Get the team&#039;s shared preferences by its unique ID. If a preference doesn&#039;t need to be shared by all team members, prefer storing them in [user preferences](https://appwrite.io/docs/references/cloud/client-web/account#getPrefs).
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> getPrefs(
        teamId: String,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Preferences<T> {
        val apiPath = "/teams/{teamId}/prefs"
            .replace("{teamId}", teamId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

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
            responseType = classOf(),
            serializer = io.appwrite.models.Preferences.serializer(actualSerializer)
        )
    }

    /**
     * Get team preferences
     *
     * Get the team&#039;s shared preferences by its unique ID. If a preference doesn&#039;t need to be shared by all team members, prefer storing them in [user preferences](https://appwrite.io/docs/references/cloud/client-web/account#getPrefs).
     *
     * @param teamId Team ID.
     */
    @Throws(Throwable::class)
    suspend fun getPrefs(
        teamId: String,
    ): io.appwrite.models.Preferences<Map<String, Any>> = getPrefs(
        teamId,
        nestedType = classOf(),
    )
            /**
     * Update preferences
     *
     * Update the team&#039;s preferences by its unique ID. The object you pass is stored as is and replaces any previous value. The maximum allowed prefs size is 64kB and throws an error if exceeded.
     *
    @Throws(Throwable::class)
     * @param teamId Team ID.
     * @param prefs Prefs key-value JSON object.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updatePrefs(
        teamId: String,
        prefs: Any,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Preferences<T> {
        val apiPath = "/teams/{teamId}/prefs"
            .replace("{teamId}", teamId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "prefs" to json.encodeToString(actualSerializer, prefs as T),
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
            responseType = classOf(),
            serializer = io.appwrite.models.Preferences.serializer(actualSerializer)
        )
    }

    /**
     * Update preferences
     *
     * Update the team&#039;s preferences by its unique ID. The object you pass is stored as is and replaces any previous value. The maximum allowed prefs size is 64kB and throws an error if exceeded.
     *
     * @param teamId Team ID.
     * @param prefs Prefs key-value JSON object.
     */
    @Throws(Throwable::class)
    suspend fun updatePrefs(
        teamId: String,
        prefs: Any,
    ): io.appwrite.models.Preferences<Map<String, Any>> = updatePrefs(
        teamId,
        prefs,
        nestedType = classOf(),
    )
    }
