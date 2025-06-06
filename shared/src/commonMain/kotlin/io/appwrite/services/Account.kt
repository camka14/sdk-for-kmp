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
 * The Account service allows you to authenticate and manage a user account.
 **/
class Account(client: Client) : Service(client) {
        /**
     * Get account
     *
     * Get the currently logged in user.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> get(
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account"

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
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Get account
     *
     * Get the currently logged in user.
     *
     */
    @Throws(Throwable::class)
    suspend fun get(
    ): io.appwrite.models.User<Map<String, Any>> = get(
        nestedType = classOf(),
    )
            /**
     * Create account
     *
     * Use this endpoint to allow a new user to register a new account in your project. After the user registration completes successfully, you can use the [/account/verfication](https://appwrite.io/docs/references/cloud/client-web/account#createVerification) route to start verifying the user email address. To allow the new user to login to their new account, you need to create a new [account session](https://appwrite.io/docs/references/cloud/client-web/account#createEmailSession).
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password New user password. Must be between 8 and 256 chars.
     * @param name User name. Max length: 128 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> create(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "password" to password,
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
            responseType = classOf(),
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Create account
     *
     * Use this endpoint to allow a new user to register a new account in your project. After the user registration completes successfully, you can use the [/account/verfication](https://appwrite.io/docs/references/cloud/client-web/account#createVerification) route to start verifying the user email address. To allow the new user to login to their new account, you need to create a new [account session](https://appwrite.io/docs/references/cloud/client-web/account#createEmailSession).
     *
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param password New user password. Must be between 8 and 256 chars.
     * @param name User name. Max length: 128 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun create(
        userId: String,
        email: String,
        password: String,
        name: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = create(
        userId,
        email,
        password,
        name,
        nestedType = classOf(),
    )
            /**
     * Delete account
     *
     * Delete the currently logged in user.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun delete(
    ): Any {
        val apiPath = "/account"


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
     * Update email
     *
     * Update currently logged in user account email address. After changing user address, the user confirmation status will get reset. A new confirmation email is not sent automatically however you can use the send confirmation email endpoint again to send the confirmation email. For security measures, user password is required to complete this request.This endpoint can also be used to convert an anonymous account to a normal one, by passing an email address and a new password.
     *
    @Throws(Throwable::class)
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updateEmail(
        email: String,
        password: String,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/email"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
            "password" to password,
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
            responseType = classOf(),
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Update email
     *
     * Update currently logged in user account email address. After changing user address, the user confirmation status will get reset. A new confirmation email is not sent automatically however you can use the send confirmation email endpoint again to send the confirmation email. For security measures, user password is required to complete this request.This endpoint can also be used to convert an anonymous account to a normal one, by passing an email address and a new password.
     *
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     */
    @Throws(Throwable::class)
    suspend fun updateEmail(
        email: String,
        password: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateEmail(
        email,
        password,
        nestedType = classOf(),
    )
            /**
     * List identities
     *
     * Get the list of identities for the currently logged in user.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: userId, provider, providerUid, providerEmail, providerAccessTokenExpiry
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listIdentities(
        queries: List<String>? = null,
    ): io.appwrite.models.IdentityList {
        val apiPath = "/account/identities"


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
            responseType = io.appwrite.models.IdentityList::class,
            serializer = io.appwrite.models.IdentityList.serializer()
        )
    }

            /**
     * Delete identity
     *
     * Delete an identity by its unique ID.
     *
    @Throws(Throwable::class)
     * @param identityId Identity ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteIdentity(
        identityId: String,
    ): Any {
        val apiPath = "/account/identities/{identityId}"
            .replace("{identityId}", identityId)


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
     * Create JWT
     *
     * Use this endpoint to create a JSON Web Token. You can use the resulting JWT to authenticate on behalf of the current user when working with the Appwrite server-side API and SDKs. The JWT secret is valid for 15 minutes from its creation and will be invalid if the user will logout in that time frame.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun createJWT(
    ): io.appwrite.models.Jwt {
        val apiPath = "/account/jwts"


        val apiParams = mutableMapOf<String, Any?>(
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
     * List logs
     *
     * Get the list of latest security activity logs for the currently logged in user. Each log returns user IP address, location and date and time of log.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listLogs(
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/account/logs"


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
     * Update MFA
     *
     * Enable or disable MFA on an account.
     *
    @Throws(Throwable::class)
     * @param mfa Enable or disable MFA.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updateMFA(
        mfa: Boolean,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/mfa"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
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
            responseType = classOf(),
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Update MFA
     *
     * Enable or disable MFA on an account.
     *
     * @param mfa Enable or disable MFA.
     */
    @Throws(Throwable::class)
    suspend fun updateMFA(
        mfa: Boolean,
    ): io.appwrite.models.User<Map<String, Any>> = updateMFA(
        mfa,
        nestedType = classOf(),
    )
            /**
     * Create authenticator
     *
     * Add an authenticator app to be used as an MFA factor. Verify the authenticator using the [verify authenticator](/docs/references/cloud/client-web/account#updateMfaAuthenticator) method.
     *
    @Throws(Throwable::class)
     * @param type Type of authenticator. Must be `totp`
     */
    @Throws(Throwable::class)
    suspend fun createMfaAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
    ): io.appwrite.models.MfaType {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)


        val apiParams = mutableMapOf<String, Any?>(
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
            responseType = io.appwrite.models.MfaType::class,
            serializer = io.appwrite.models.MfaType.serializer()
        )
    }

            /**
     * Update authenticator (confirmation)
     *
     * Verify an authenticator app after adding it using the [add authenticator](/docs/references/cloud/client-web/account#createMfaAuthenticator) method.
     *
    @Throws(Throwable::class)
     * @param type Type of authenticator.
     * @param otp Valid verification token.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updateMfaAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
        otp: String,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "otp" to otp,
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
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Update authenticator (confirmation)
     *
     * Verify an authenticator app after adding it using the [add authenticator](/docs/references/cloud/client-web/account#createMfaAuthenticator) method.
     *
     * @param type Type of authenticator.
     * @param otp Valid verification token.
     */
    @Throws(Throwable::class)
    suspend fun updateMfaAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
        otp: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateMfaAuthenticator(
        type,
        otp,
        nestedType = classOf(),
    )
            /**
     * Delete authenticator
     *
     * Delete an authenticator for a user by ID.
     *
    @Throws(Throwable::class)
     * @param type Type of authenticator.
     */
    @Throws(Throwable::class)
    suspend fun deleteMfaAuthenticator(
        type: io.appwrite.enums.AuthenticatorType,
    ): Any {
        val apiPath = "/account/mfa/authenticators/{type}"
            .replace("{type}", type.value)


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
     * Create MFA challenge
     *
     * Begin the process of MFA verification after sign-in. Finish the flow with [updateMfaChallenge](/docs/references/cloud/client-web/account#updateMfaChallenge) method.
     *
    @Throws(Throwable::class)
     * @param factor Factor used for verification. Must be one of following: `email`, `phone`, `totp`, `recoveryCode`.
     */
    @Throws(Throwable::class)
    suspend fun createMfaChallenge(
        factor: io.appwrite.enums.AuthenticationFactor,
    ): io.appwrite.models.MfaChallenge {
        val apiPath = "/account/mfa/challenge"


        val apiParams = mutableMapOf<String, Any?>(
            "factor" to factor,
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
            responseType = io.appwrite.models.MfaChallenge::class,
            serializer = io.appwrite.models.MfaChallenge.serializer()
        )
    }

            /**
     * Update MFA challenge (confirmation)
     *
     * Complete the MFA challenge by providing the one-time password. Finish the process of MFA verification by providing the one-time password. To begin the flow, use [createMfaChallenge](/docs/references/cloud/client-web/account#createMfaChallenge) method.
     *
    @Throws(Throwable::class)
     * @param challengeId ID of the challenge.
     * @param otp Valid verification token.
     */
    @Throws(Throwable::class)
    suspend fun updateMfaChallenge(
        challengeId: String,
        otp: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/mfa/challenge"


        val apiParams = mutableMapOf<String, Any?>(
            "challengeId" to challengeId,
            "otp" to otp,
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
            responseType = io.appwrite.models.Session::class,
            serializer = io.appwrite.models.Session.serializer()
        )
    }

            /**
     * List factors
     *
     * List the factors available on the account to be used as a MFA challange.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listMfaFactors(
    ): io.appwrite.models.MfaFactors {
        val apiPath = "/account/mfa/factors"


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
            responseType = io.appwrite.models.MfaFactors::class,
            serializer = io.appwrite.models.MfaFactors.serializer()
        )
    }

            /**
     * List MFA recovery codes
     *
     * Get recovery codes that can be used as backup for MFA flow. Before getting codes, they must be generated using [createMfaRecoveryCodes](/docs/references/cloud/client-web/account#createMfaRecoveryCodes) method. An OTP challenge is required to read recovery codes.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun getMfaRecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"


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
            responseType = io.appwrite.models.MfaRecoveryCodes::class,
            serializer = io.appwrite.models.MfaRecoveryCodes.serializer()
        )
    }

            /**
     * Create MFA recovery codes
     *
     * Generate recovery codes as backup for MFA flow. It&#039;s recommended to generate and show then immediately after user successfully adds their authehticator. Recovery codes can be used as a MFA verification type in [createMfaChallenge](/docs/references/cloud/client-web/account#createMfaChallenge) method.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun createMfaRecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"


        val apiParams = mutableMapOf<String, Any?>(
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
            responseType = io.appwrite.models.MfaRecoveryCodes::class,
            serializer = io.appwrite.models.MfaRecoveryCodes.serializer()
        )
    }

            /**
     * Update MFA recovery codes (regenerate)
     *
     * Regenerate recovery codes that can be used as backup for MFA flow. Before regenerating codes, they must be first generated using [createMfaRecoveryCodes](/docs/references/cloud/client-web/account#createMfaRecoveryCodes) method. An OTP challenge is required to regenreate recovery codes.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun updateMfaRecoveryCodes(
    ): io.appwrite.models.MfaRecoveryCodes {
        val apiPath = "/account/mfa/recovery-codes"


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
            responseType = io.appwrite.models.MfaRecoveryCodes::class,
            serializer = io.appwrite.models.MfaRecoveryCodes.serializer()
        )
    }

            /**
     * Update name
     *
     * Update currently logged in user account name.
     *
    @Throws(Throwable::class)
     * @param name User name. Max length: 128 chars.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updateName(
        name: String,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/name"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
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
            responseType = classOf(),
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Update name
     *
     * Update currently logged in user account name.
     *
     * @param name User name. Max length: 128 chars.
     */
    @Throws(Throwable::class)
    suspend fun updateName(
        name: String,
    ): io.appwrite.models.User<Map<String, Any>> = updateName(
        name,
        nestedType = classOf(),
    )
            /**
     * Update password
     *
     * Update currently logged in user password. For validation, user is required to pass in the new password, and the old password. For users created with OAuth, Team Invites and Magic URL, oldPassword is optional.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param password New user password. Must be at least 8 chars.
     * @param oldPassword Current user password. Must be at least 8 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> updatePassword(
        password: String,
        oldPassword: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/password"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "password" to password,
            "oldPassword" to oldPassword,
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
            responseType = classOf(),
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Update password
     *
     * Update currently logged in user password. For validation, user is required to pass in the new password, and the old password. For users created with OAuth, Team Invites and Magic URL, oldPassword is optional.
     *
     * @param password New user password. Must be at least 8 chars.
     * @param oldPassword Current user password. Must be at least 8 chars.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updatePassword(
        password: String,
        oldPassword: String? = null,
    ): io.appwrite.models.User<Map<String, Any>> = updatePassword(
        password,
        oldPassword,
        nestedType = classOf(),
    )
            /**
     * Update phone
     *
     * Update the currently logged in user&#039;s phone number. After updating the phone number, the phone verification status will be reset. A confirmation SMS is not sent automatically, however you can use the [POST /account/verification/phone](https://appwrite.io/docs/references/cloud/client-web/account#createPhoneVerification) endpoint to send a confirmation SMS.
     *
    @Throws(Throwable::class)
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param password User password. Must be at least 8 chars.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updatePhone(
        phone: String,
        password: String,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/phone"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "phone" to phone,
            "password" to password,
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
            responseType = classOf(),
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Update phone
     *
     * Update the currently logged in user&#039;s phone number. After updating the phone number, the phone verification status will be reset. A confirmation SMS is not sent automatically, however you can use the [POST /account/verification/phone](https://appwrite.io/docs/references/cloud/client-web/account#createPhoneVerification) endpoint to send a confirmation SMS.
     *
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param password User password. Must be at least 8 chars.
     */
    @Throws(Throwable::class)
    suspend fun updatePhone(
        phone: String,
        password: String,
    ): io.appwrite.models.User<Map<String, Any>> = updatePhone(
        phone,
        password,
        nestedType = classOf(),
    )
            /**
     * Get account preferences
     *
     * Get the preferences as a key-value object for the currently logged in user.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> getPrefs(
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Preferences<T> {
        val apiPath = "/account/prefs"

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
     * Get account preferences
     *
     * Get the preferences as a key-value object for the currently logged in user.
     *
     */
    @Throws(Throwable::class)
    suspend fun getPrefs(
    ): io.appwrite.models.Preferences<Map<String, Any>> = getPrefs(
        nestedType = classOf(),
    )
            /**
     * Update preferences
     *
     * Update currently logged in user account preferences. The object you pass is stored as is, and replaces any previous value. The maximum allowed prefs size is 64kB and throws error if exceeded.
     *
    @Throws(Throwable::class)
     * @param prefs Prefs key-value JSON object.
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updatePrefs(
        prefs: Any,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/prefs"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "prefs" to json.encodeToString(actualSerializer, prefs as T),
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
            responseType = classOf(),
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Update preferences
     *
     * Update currently logged in user account preferences. The object you pass is stored as is, and replaces any previous value. The maximum allowed prefs size is 64kB and throws error if exceeded.
     *
     * @param prefs Prefs key-value JSON object.
     */
    @Throws(Throwable::class)
    suspend fun updatePrefs(
        prefs: Any,
    ): io.appwrite.models.User<Map<String, Any>> = updatePrefs(
        prefs,
        nestedType = classOf(),
    )
            /**
     * Create password recovery
     *
     * Sends the user an email with a temporary secret key for password reset. When the user clicks the confirmation link he is redirected back to your app password reset URL with the secret key and email address values attached to the URL query string. Use the query string params to submit a request to the [PUT /account/recovery](https://appwrite.io/docs/references/cloud/client-web/account#updateRecovery) endpoint to complete the process. The verification link sent to the user&#039;s email address is valid for 1 hour.
     *
    @Throws(Throwable::class)
     * @param email User email.
     * @param url URL to redirect the user back to your app from the recovery email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     */
    @Throws(Throwable::class)
    suspend fun createRecovery(
        email: String,
        url: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/recovery"


        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
            "url" to url,
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

            /**
     * Update password recovery (confirmation)
     *
     * Use this endpoint to complete the user account password reset. Both the **userId** and **secret** arguments will be passed as query parameters to the redirect URL you have provided when sending your request to the [POST /account/recovery](https://appwrite.io/docs/references/cloud/client-web/account#createRecovery) endpoint.Please note that in order to avoid a [Redirect Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md) the only valid redirect URLs are the ones from domains you have set when adding your platforms in the console interface.
     *
    @Throws(Throwable::class)
     * @param userId User ID.
     * @param secret Valid reset token.
     * @param password New user password. Must be between 8 and 256 chars.
     */
    @Throws(Throwable::class)
    suspend fun updateRecovery(
        userId: String,
        secret: String,
        password: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/recovery"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
            "password" to password,
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

            /**
     * List sessions
     *
     * Get the list of active sessions across different devices for the currently logged in user.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listSessions(
    ): io.appwrite.models.SessionList {
        val apiPath = "/account/sessions"


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
            responseType = io.appwrite.models.SessionList::class,
            serializer = io.appwrite.models.SessionList.serializer()
        )
    }

            /**
     * Delete sessions
     *
     * Delete all sessions from the user account and remove any sessions cookies from the end client.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun deleteSessions(
    ): Any {
        val apiPath = "/account/sessions"


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
     * Create anonymous session
     *
     * Use this endpoint to allow a new user to register an anonymous account in your project. This route will also create a new session for the user. To allow the new user to convert an anonymous account to a normal account, you need to update its [email and password](https://appwrite.io/docs/references/cloud/client-web/account#updateEmail) or create an [OAuth2 session](https://appwrite.io/docs/references/cloud/client-web/account#CreateOAuth2Session).
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun createAnonymousSession(
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/anonymous"


        val apiParams = mutableMapOf<String, Any?>(
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
            responseType = io.appwrite.models.Session::class,
            serializer = io.appwrite.models.Session.serializer()
        )
    }

            /**
     * Create email password session
     *
     * Allow the user to login into their account by providing a valid email and password combination. This route will create a new session for the user.A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
     *
    @Throws(Throwable::class)
     * @param email User email.
     * @param password User password. Must be at least 8 chars.
     */
    @Throws(Throwable::class)
    suspend fun createEmailPasswordSession(
        email: String,
        password: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/email"


        val apiParams = mutableMapOf<String, Any?>(
            "email" to email,
            "password" to password,
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
            responseType = io.appwrite.models.Session::class,
            serializer = io.appwrite.models.Session.serializer()
        )
    }

            /**
     * Update magic URL session
     *
     * Use this endpoint to create a session from token. Provide the **userId** and **secret** parameters from the successful response of authentication flows initiated by token creation. For example, magic URL and phone login.
     *
    @Throws(Throwable::class)
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param secret Valid verification token.
     */
    @Throws(Throwable::class)
    suspend fun updateMagicURLSession(
        userId: String,
        secret: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/magic-url"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
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
            responseType = io.appwrite.models.Session::class,
            serializer = io.appwrite.models.Session.serializer()
        )
    }

                /**
     * Update phone session
     *
     * Use this endpoint to create a session from token. Provide the **userId** and **secret** parameters from the successful response of authentication flows initiated by token creation. For example, magic URL and phone login.
     *
    @Throws(Throwable::class)
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param secret Valid verification token.
     */
    @Throws(Throwable::class)
    suspend fun updatePhoneSession(
        userId: String,
        secret: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/phone"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
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
            responseType = io.appwrite.models.Session::class,
            serializer = io.appwrite.models.Session.serializer()
        )
    }

            /**
     * Create session
     *
     * Use this endpoint to create a session from token. Provide the **userId** and **secret** parameters from the successful response of authentication flows initiated by token creation. For example, magic URL and phone login.
     *
    @Throws(Throwable::class)
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param secret Secret of a token generated by login methods. For example, the `createMagicURLToken` or `createPhoneToken` methods.
     */
    @Throws(Throwable::class)
    suspend fun createSession(
        userId: String,
        secret: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/token"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
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
            responseType = io.appwrite.models.Session::class,
            serializer = io.appwrite.models.Session.serializer()
        )
    }

            /**
     * Get session
     *
     * Use this endpoint to get a logged in user&#039;s session using a Session ID. Inputting &#039;current&#039; will return the current session being used.
     *
    @Throws(Throwable::class)
     * @param sessionId Session ID. Use the string 'current' to get the current device session.
     */
    @Throws(Throwable::class)
    suspend fun getSession(
        sessionId: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)


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
            responseType = io.appwrite.models.Session::class,
            serializer = io.appwrite.models.Session.serializer()
        )
    }

            /**
     * Update session
     *
     * Use this endpoint to extend a session&#039;s length. Extending a session is useful when session expiry is short. If the session was created using an OAuth provider, this endpoint refreshes the access token from the provider.
     *
    @Throws(Throwable::class)
     * @param sessionId Session ID. Use the string 'current' to update the current device session.
     */
    @Throws(Throwable::class)
    suspend fun updateSession(
        sessionId: String,
    ): io.appwrite.models.Session {
        val apiPath = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)


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
            responseType = io.appwrite.models.Session::class,
            serializer = io.appwrite.models.Session.serializer()
        )
    }

            /**
     * Delete session
     *
     * Logout the user. Use &#039;current&#039; as the session ID to logout on this device, use a session ID to logout on another device. If you&#039;re looking to logout the user on all devices, use [Delete Sessions](https://appwrite.io/docs/references/cloud/client-web/account#deleteSessions) instead.
     *
    @Throws(Throwable::class)
     * @param sessionId Session ID. Use the string 'current' to delete the current device session.
     */
    @Throws(Throwable::class)
    suspend fun deleteSession(
        sessionId: String,
    ): Any {
        val apiPath = "/account/sessions/{sessionId}"
            .replace("{sessionId}", sessionId)


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
     * Update status
     *
     * Block the currently logged in user account. Behind the scene, the user record is not deleted but permanently blocked from any access. To completely delete a user, use the Users API instead.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend inline fun <reified T : Any> updateStatus(
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.User<T> {
        val apiPath = "/account/status"

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

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
            responseType = classOf(),
            serializer = io.appwrite.models.User.serializer(actualSerializer)
        )
    }

    /**
     * Update status
     *
     * Block the currently logged in user account. Behind the scene, the user record is not deleted but permanently blocked from any access. To completely delete a user, use the Users API instead.
     *
     */
    @Throws(Throwable::class)
    suspend fun updateStatus(
    ): io.appwrite.models.User<Map<String, Any>> = updateStatus(
        nestedType = classOf(),
    )
            /**
     * Create push target
     *
     * Use this endpoint to register a device for push notifications. Provide a target ID (custom or generated using ID.unique()), a device identifier (usually a device token), and optionally specify which provider should send notifications to this target. The target is automatically linked to the current session and includes device information like brand and model.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param targetId Target ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param identifier The target identifier (token, email, phone etc.)
     * @param providerId Provider ID. Message will be sent to this target from the specified provider ID. If no provider ID is set the first setup provider will be used.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createPushTarget(
        targetId: String,
        identifier: String,
        providerId: String? = null,
    ): io.appwrite.models.Target {
        val apiPath = "/account/targets/push"


        val apiParams = mutableMapOf<String, Any?>(
            "targetId" to targetId,
            "identifier" to identifier,
            "providerId" to providerId,
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
            responseType = io.appwrite.models.Target::class,
            serializer = io.appwrite.models.Target.serializer()
        )
    }

            /**
     * Update push target
     *
     * Update the currently logged in user&#039;s push notification target. You can modify the target&#039;s identifier (device token) and provider ID (token, email, phone etc.). The target must exist and belong to the current user. If you change the provider ID, notifications will be sent through the new messaging provider instead.
     *
    @Throws(Throwable::class)
     * @param targetId Target ID.
     * @param identifier The target identifier (token, email, phone etc.)
     */
    @Throws(Throwable::class)
    suspend fun updatePushTarget(
        targetId: String,
        identifier: String,
    ): io.appwrite.models.Target {
        val apiPath = "/account/targets/{targetId}/push"
            .replace("{targetId}", targetId)


        val apiParams = mutableMapOf<String, Any?>(
            "identifier" to identifier,
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
            responseType = io.appwrite.models.Target::class,
            serializer = io.appwrite.models.Target.serializer()
        )
    }

            /**
     * Delete push target
     *
     * Delete a push notification target for the currently logged in user. After deletion, the device will no longer receive push notifications. The target must exist and belong to the current user.
     *
    @Throws(Throwable::class)
     * @param targetId Target ID.
     */
    @Throws(Throwable::class)
    suspend fun deletePushTarget(
        targetId: String,
    ): Any {
        val apiPath = "/account/targets/{targetId}/push"
            .replace("{targetId}", targetId)


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
     * Create email token (OTP)
     *
     * Sends the user an email with a secret key for creating a session. If the provided user ID has not be registered, a new user will be created. Use the returned user ID and secret and submit a request to the [POST /v1/account/sessions/token](https://appwrite.io/docs/references/cloud/client-web/account#createSession) endpoint to complete the login process. The secret sent to the user&#039;s email is valid for 15 minutes.A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param userId User ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param phrase Toggle for security phrase. If enabled, email will be send with a randomly generated phrase and the phrase will also be included in the response. Confirming phrases match increases the security of your authentication flow.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createEmailToken(
        userId: String,
        email: String,
        phrase: Boolean? = null,
    ): io.appwrite.models.Token {
        val apiPath = "/account/tokens/email"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "phrase" to phrase,
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

            /**
     * Create magic URL token
     *
     * Sends the user an email with a secret key for creating a session. If the provided user ID has not been registered, a new user will be created. When the user clicks the link in the email, the user is redirected back to the URL you provided with the secret key and userId values attached to the URL query string. Use the query string parameters to submit a request to the [POST /v1/account/sessions/token](https://appwrite.io/docs/references/cloud/client-web/account#createSession) endpoint to complete the login process. The link sent to the user&#039;s email address is valid for 1 hour.A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param userId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param email User email.
     * @param url URL to redirect the user back to your app from the magic URL login. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     * @param phrase Toggle for security phrase. If enabled, email will be send with a randomly generated phrase and the phrase will also be included in the response. Confirming phrases match increases the security of your authentication flow.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createMagicURLToken(
        userId: String,
        email: String,
        url: String? = null,
        phrase: Boolean? = null,
    ): io.appwrite.models.Token {
        val apiPath = "/account/tokens/magic-url"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "email" to email,
            "url" to url,
            "phrase" to phrase,
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

                /**
     * Create phone token
     *
     * Sends the user an SMS with a secret key for creating a session. If the provided user ID has not be registered, a new user will be created. Use the returned user ID and secret and submit a request to the [POST /v1/account/sessions/token](https://appwrite.io/docs/references/cloud/client-web/account#createSession) endpoint to complete the login process. The secret sent to the user&#039;s phone is valid for 15 minutes.A user is limited to 10 active sessions at a time by default. [Learn more about session limits](https://appwrite.io/docs/authentication-security#limits).
     *
    @Throws(Throwable::class)
     * @param userId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param phone Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     */
    @Throws(Throwable::class)
    suspend fun createPhoneToken(
        userId: String,
        phone: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/tokens/phone"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "phone" to phone,
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

            /**
     * Create email verification
     *
     * Use this endpoint to send a verification message to your user email address to confirm they are the valid owners of that address. Both the **userId** and **secret** arguments will be passed as query parameters to the URL you have provided to be attached to the verification email. The provided URL should redirect the user back to your app and allow you to complete the verification process by verifying both the **userId** and **secret** parameters. Learn more about how to [complete the verification process](https://appwrite.io/docs/references/cloud/client-web/account#updateVerification). The verification link sent to the user&#039;s email address is valid for 7 days.Please note that in order to avoid a [Redirect Attack](https://github.com/OWASP/CheatSheetSeries/blob/master/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.md), the only valid redirect URLs are the ones from domains you have set when adding your platforms in the console interface.
     *
    @Throws(Throwable::class)
     * @param url URL to redirect the user back to your app from the verification email. Only URLs from hostnames in your project platform list are allowed. This requirement helps to prevent an [open redirect](https://cheatsheetseries.owasp.org/cheatsheets/Unvalidated_Redirects_and_Forwards_Cheat_Sheet.html) attack against your project API.
     */
    @Throws(Throwable::class)
    suspend fun createVerification(
        url: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/verification"


        val apiParams = mutableMapOf<String, Any?>(
            "url" to url,
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

            /**
     * Update email verification (confirmation)
     *
     * Use this endpoint to complete the user email verification process. Use both the **userId** and **secret** parameters that were attached to your app URL to verify the user email ownership. If confirmed this route will return a 200 status code.
     *
    @Throws(Throwable::class)
     * @param userId User ID.
     * @param secret Valid verification token.
     */
    @Throws(Throwable::class)
    suspend fun updateVerification(
        userId: String,
        secret: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/verification"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

            /**
     * Create phone verification
     *
     * Use this endpoint to send a verification SMS to the currently logged in user. This endpoint is meant for use after updating a user&#039;s phone number using the [accountUpdatePhone](https://appwrite.io/docs/references/cloud/client-web/account#updatePhone) endpoint. Learn more about how to [complete the verification process](https://appwrite.io/docs/references/cloud/client-web/account#updatePhoneVerification). The verification code sent to the user&#039;s phone number is valid for 15 minutes.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun createPhoneVerification(
    ): io.appwrite.models.Token {
        val apiPath = "/account/verification/phone"


        val apiParams = mutableMapOf<String, Any?>(
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

            /**
     * Update phone verification (confirmation)
     *
     * Use this endpoint to complete the user phone verification process. Use the **userId** and **secret** that were sent to your user&#039;s phone number to verify the user email ownership. If confirmed this route will return a 200 status code.
     *
    @Throws(Throwable::class)
     * @param userId User ID.
     * @param secret Valid verification token.
     */
    @Throws(Throwable::class)
    suspend fun updatePhoneVerification(
        userId: String,
        secret: String,
    ): io.appwrite.models.Token {
        val apiPath = "/account/verification/phone"


        val apiParams = mutableMapOf<String, Any?>(
            "userId" to userId,
            "secret" to secret,
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
            responseType = io.appwrite.models.Token::class,
            serializer = io.appwrite.models.Token.serializer()
        )
    }

    }
