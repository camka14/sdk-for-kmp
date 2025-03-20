package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AuthenticationFactor(val value: String) {
    @SerialName("email")
    EMAIL("email"),
    @SerialName("phone")
    PHONE("phone"),
    @SerialName("totp")
    TOTP("totp"),
    @SerialName("recoverycode")
    RECOVERYCODE("recoverycode");

    override fun toString() = value
}
