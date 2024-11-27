package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Session
 */
@Serializable
data class Session(
    /**
     * Session ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Session creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Session update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * User ID.
     */
    @SerialName("userId")
    val userId: String,

    /**
     * Session expiration date in ISO 8601 format.
     */
    @SerialName("expire")
    val expire: String,

    /**
     * Session Provider.
     */
    @SerialName("provider")
    val provider: String,

    /**
     * Session Provider User ID.
     */
    @SerialName("providerUid")
    val providerUid: String,

    /**
     * Session Provider Access Token.
     */
    @SerialName("providerAccessToken")
    val providerAccessToken: String,

    /**
     * The date of when the access token expires in ISO 8601 format.
     */
    @SerialName("providerAccessTokenExpiry")
    val providerAccessTokenExpiry: String,

    /**
     * Session Provider Refresh Token.
     */
    @SerialName("providerRefreshToken")
    val providerRefreshToken: String,

    /**
     * IP in use when the session was created.
     */
    @SerialName("ip")
    val ip: String,

    /**
     * Operating system code name. View list of [available options](https://github.com/appwrite/appwrite/blob/master/docs/lists/os.json).
     */
    @SerialName("osCode")
    val osCode: String,

    /**
     * Operating system name.
     */
    @SerialName("osName")
    val osName: String,

    /**
     * Operating system version.
     */
    @SerialName("osVersion")
    val osVersion: String,

    /**
     * Client type.
     */
    @SerialName("clientType")
    val clientType: String,

    /**
     * Client code name. View list of [available options](https://github.com/appwrite/appwrite/blob/master/docs/lists/clients.json).
     */
    @SerialName("clientCode")
    val clientCode: String,

    /**
     * Client name.
     */
    @SerialName("clientName")
    val clientName: String,

    /**
     * Client version.
     */
    @SerialName("clientVersion")
    val clientVersion: String,

    /**
     * Client engine name.
     */
    @SerialName("clientEngine")
    val clientEngine: String,

    /**
     * Client engine name.
     */
    @SerialName("clientEngineVersion")
    val clientEngineVersion: String,

    /**
     * Device name.
     */
    @SerialName("deviceName")
    val deviceName: String,

    /**
     * Device brand name.
     */
    @SerialName("deviceBrand")
    val deviceBrand: String,

    /**
     * Device model name.
     */
    @SerialName("deviceModel")
    val deviceModel: String,

    /**
     * Country two-character ISO 3166-1 alpha code.
     */
    @SerialName("countryCode")
    val countryCode: String,

    /**
     * Country name.
     */
    @SerialName("countryName")
    val countryName: String,

    /**
     * Returns true if this the current user session.
     */
    @SerialName("current")
    val current: Boolean,

    /**
     * Returns a list of active session factors.
     */
    @SerialName("factors")
    val factors: List<Any>,

    /**
     * Secret used to authenticate the user. Only included if the request was made with an API key
     */
    @SerialName("secret")
    val secret: String,

    /**
     * Most recent date in ISO 8601 format when the session successfully passed MFA challenge.
     */
    @SerialName("mfaUpdatedAt")
    val mfaUpdatedAt: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "\$id" to id as Any,
        "\$createdAt" to createdAt as Any,
        "\$updatedAt" to updatedAt as Any,
        "userId" to userId as Any,
        "expire" to expire as Any,
        "provider" to provider as Any,
        "providerUid" to providerUid as Any,
        "providerAccessToken" to providerAccessToken as Any,
        "providerAccessTokenExpiry" to providerAccessTokenExpiry as Any,
        "providerRefreshToken" to providerRefreshToken as Any,
        "ip" to ip as Any,
        "osCode" to osCode as Any,
        "osName" to osName as Any,
        "osVersion" to osVersion as Any,
        "clientType" to clientType as Any,
        "clientCode" to clientCode as Any,
        "clientName" to clientName as Any,
        "clientVersion" to clientVersion as Any,
        "clientEngine" to clientEngine as Any,
        "clientEngineVersion" to clientEngineVersion as Any,
        "deviceName" to deviceName as Any,
        "deviceBrand" to deviceBrand as Any,
        "deviceModel" to deviceModel as Any,
        "countryCode" to countryCode as Any,
        "countryName" to countryName as Any,
        "current" to current as Any,
        "factors" to factors as Any,
        "secret" to secret as Any,
        "mfaUpdatedAt" to mfaUpdatedAt as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Session(
            id = map["\$id"] as String,
            createdAt = map["\$createdAt"] as String,
            updatedAt = map["\$updatedAt"] as String,
            userId = map["userId"] as String,
            expire = map["expire"] as String,
            provider = map["provider"] as String,
            providerUid = map["providerUid"] as String,
            providerAccessToken = map["providerAccessToken"] as String,
            providerAccessTokenExpiry = map["providerAccessTokenExpiry"] as String,
            providerRefreshToken = map["providerRefreshToken"] as String,
            ip = map["ip"] as String,
            osCode = map["osCode"] as String,
            osName = map["osName"] as String,
            osVersion = map["osVersion"] as String,
            clientType = map["clientType"] as String,
            clientCode = map["clientCode"] as String,
            clientName = map["clientName"] as String,
            clientVersion = map["clientVersion"] as String,
            clientEngine = map["clientEngine"] as String,
            clientEngineVersion = map["clientEngineVersion"] as String,
            deviceName = map["deviceName"] as String,
            deviceBrand = map["deviceBrand"] as String,
            deviceModel = map["deviceModel"] as String,
            countryCode = map["countryCode"] as String,
            countryName = map["countryName"] as String,
            current = map["current"] as Boolean,
            factors = map["factors"] as List<Any>,
            secret = map["secret"] as String,
            mfaUpdatedAt = map["mfaUpdatedAt"] as String,
        )
    }
}