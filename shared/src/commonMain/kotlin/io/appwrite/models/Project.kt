package io.appwrite.models

import io.appwrite.extensions.jsonCast
import io.appwrite.extensions.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long
import kotlinx.serialization.json.put

/**
 * Project
 */
@Serializable
data class Project(
    /**
     * Project ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Project creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Project update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Project name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Project description.
     */
    @SerialName("description")
    val description: String,

    /**
     * Project team ID.
     */
    @SerialName("teamId")
    val teamId: String,

    /**
     * Project logo file ID.
     */
    @SerialName("logo")
    val logo: String,

    /**
     * Project website URL.
     */
    @SerialName("url")
    val url: String,

    /**
     * Company legal name.
     */
    @SerialName("legalName")
    val legalName: String,

    /**
     * Country code in [ISO 3166-1](http://en.wikipedia.org/wiki/ISO_3166-1) two-character format.
     */
    @SerialName("legalCountry")
    val legalCountry: String,

    /**
     * State name.
     */
    @SerialName("legalState")
    val legalState: String,

    /**
     * City name.
     */
    @SerialName("legalCity")
    val legalCity: String,

    /**
     * Company Address.
     */
    @SerialName("legalAddress")
    val legalAddress: String,

    /**
     * Company Tax ID.
     */
    @SerialName("legalTaxId")
    val legalTaxId: String,

    /**
     * Session duration in seconds.
     */
    @SerialName("authDuration")
    val authDuration: Long,

    /**
     * Max users allowed. 0 is unlimited.
     */
    @SerialName("authLimit")
    val authLimit: Long,

    /**
     * Max sessions allowed per user. 100 maximum.
     */
    @SerialName("authSessionsLimit")
    val authSessionsLimit: Long,

    /**
     * Max allowed passwords in the history list per user. Max passwords limit allowed in history is 20. Use 0 for disabling password history.
     */
    @SerialName("authPasswordHistory")
    val authPasswordHistory: Long,

    /**
     * Whether or not to check user&#039;s password against most commonly used passwords.
     */
    @SerialName("authPasswordDictionary")
    val authPasswordDictionary: Boolean,

    /**
     * Whether or not to check the user password for similarity with their personal data.
     */
    @SerialName("authPersonalDataCheck")
    val authPersonalDataCheck: Boolean,

    /**
     * An array of mock numbers and their corresponding verification codes (OTPs).
     */
    @SerialName("authMockNumbers")
    val authMockNumbers: List<MockNumber>,

    /**
     * Whether or not to send session alert emails to users.
     */
    @SerialName("authSessionAlerts")
    val authSessionAlerts: Boolean,

    /**
     * Whether or not to show user names in the teams membership response.
     */
    @SerialName("authMembershipsUserName")
    val authMembershipsUserName: Boolean,

    /**
     * Whether or not to show user emails in the teams membership response.
     */
    @SerialName("authMembershipsUserEmail")
    val authMembershipsUserEmail: Boolean,

    /**
     * Whether or not to show user MFA status in the teams membership response.
     */
    @SerialName("authMembershipsMfa")
    val authMembershipsMfa: Boolean,

    /**
     * Whether or not all existing sessions should be invalidated on password change
     */
    @SerialName("authInvalidateSessions")
    val authInvalidateSessions: Boolean,

    /**
     * List of Auth Providers.
     */
    @SerialName("oAuthProviders")
    val oAuthProviders: List<AuthProvider>,

    /**
     * List of Platforms.
     */
    @SerialName("platforms")
    val platforms: List<Platform>,

    /**
     * List of Webhooks.
     */
    @SerialName("webhooks")
    val webhooks: List<Webhook>,

    /**
     * List of API Keys.
     */
    @SerialName("keys")
    val keys: List<Key>,

    /**
     * List of dev keys.
     */
    @SerialName("devKeys")
    val devKeys: List<DevKey>,

    /**
     * Status for custom SMTP
     */
    @SerialName("smtpEnabled")
    val smtpEnabled: Boolean,

    /**
     * SMTP sender name
     */
    @SerialName("smtpSenderName")
    val smtpSenderName: String,

    /**
     * SMTP sender email
     */
    @SerialName("smtpSenderEmail")
    val smtpSenderEmail: String,

    /**
     * SMTP reply to email
     */
    @SerialName("smtpReplyTo")
    val smtpReplyTo: String,

    /**
     * SMTP server host name
     */
    @SerialName("smtpHost")
    val smtpHost: String,

    /**
     * SMTP server port
     */
    @SerialName("smtpPort")
    val smtpPort: Long,

    /**
     * SMTP server username
     */
    @SerialName("smtpUsername")
    val smtpUsername: String,

    /**
     * SMTP server password
     */
    @SerialName("smtpPassword")
    val smtpPassword: String,

    /**
     * SMTP server secure protocol
     */
    @SerialName("smtpSecure")
    val smtpSecure: String,

    /**
     * Number of times the ping was received for this project.
     */
    @SerialName("pingCount")
    val pingCount: Long,

    /**
     * Last ping datetime in ISO 8601 format.
     */
    @SerialName("pingedAt")
    val pingedAt: String,

    /**
     * Email/Password auth method status
     */
    @SerialName("authEmailPassword")
    val authEmailPassword: Boolean,

    /**
     * Magic URL auth method status
     */
    @SerialName("authUsersAuthMagicURL")
    val authUsersAuthMagicURL: Boolean,

    /**
     * Email (OTP) auth method status
     */
    @SerialName("authEmailOtp")
    val authEmailOtp: Boolean,

    /**
     * Anonymous auth method status
     */
    @SerialName("authAnonymous")
    val authAnonymous: Boolean,

    /**
     * Invites auth method status
     */
    @SerialName("authInvites")
    val authInvites: Boolean,

    /**
     * JWT auth method status
     */
    @SerialName("authJWT")
    val authJWT: Boolean,

    /**
     * Phone auth method status
     */
    @SerialName("authPhone")
    val authPhone: Boolean,

    /**
     * Account service status
     */
    @SerialName("serviceStatusForAccount")
    val serviceStatusForAccount: Boolean,

    /**
     * Avatars service status
     */
    @SerialName("serviceStatusForAvatars")
    val serviceStatusForAvatars: Boolean,

    /**
     * Databases (legacy) service status
     */
    @SerialName("serviceStatusForDatabases")
    val serviceStatusForDatabases: Boolean,

    /**
     * TablesDB service status
     */
    @SerialName("serviceStatusForTablesdb")
    val serviceStatusForTablesdb: Boolean,

    /**
     * Locale service status
     */
    @SerialName("serviceStatusForLocale")
    val serviceStatusForLocale: Boolean,

    /**
     * Health service status
     */
    @SerialName("serviceStatusForHealth")
    val serviceStatusForHealth: Boolean,

    /**
     * Storage service status
     */
    @SerialName("serviceStatusForStorage")
    val serviceStatusForStorage: Boolean,

    /**
     * Teams service status
     */
    @SerialName("serviceStatusForTeams")
    val serviceStatusForTeams: Boolean,

    /**
     * Users service status
     */
    @SerialName("serviceStatusForUsers")
    val serviceStatusForUsers: Boolean,

    /**
     * Sites service status
     */
    @SerialName("serviceStatusForSites")
    val serviceStatusForSites: Boolean,

    /**
     * Functions service status
     */
    @SerialName("serviceStatusForFunctions")
    val serviceStatusForFunctions: Boolean,

    /**
     * GraphQL service status
     */
    @SerialName("serviceStatusForGraphql")
    val serviceStatusForGraphql: Boolean,

    /**
     * Messaging service status
     */
    @SerialName("serviceStatusForMessaging")
    val serviceStatusForMessaging: Boolean,

)

