package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Log
 */
@Serializable
data class Log(
    /**
     * Event name.
     */
    @SerialName("event")
    val event: String,

    /**
     * User ID.
     */
    @SerialName("userId")
    val userId: String,

    /**
     * User Email.
     */
    @SerialName("userEmail")
    val userEmail: String,

    /**
     * User Name.
     */
    @SerialName("userName")
    val userName: String,

    /**
     * API mode when event triggered.
     */
    @SerialName("mode")
    val mode: String,

    /**
     * IP session in use when the session was created.
     */
    @SerialName("ip")
    val ip: String,

    /**
     * Log creation date in ISO 8601 format.
     */
    @SerialName("time")
    val time: String,

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

) {
    fun toMap(): Map<String, Any> = mapOf(
        "event" to event as Any,
        "userId" to userId as Any,
        "userEmail" to userEmail as Any,
        "userName" to userName as Any,
        "mode" to mode as Any,
        "ip" to ip as Any,
        "time" to time as Any,
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
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = Log(
            event = map["event"] as String,
            userId = map["userId"] as String,
            userEmail = map["userEmail"] as String,
            userName = map["userName"] as String,
            mode = map["mode"] as String,
            ip = map["ip"] as String,
            time = map["time"] as String,
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
        )
    }
}