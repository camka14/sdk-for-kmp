package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class HealthAntivirusStatus(val value: String) {
    @SerialName("disabled")
    DISABLED("disabled"),

    @SerialName("offline")
    OFFLINE("offline"),

    @SerialName("online")
    ONLINE("online");

    override fun toString() = value
}
