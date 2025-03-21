package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class AuthMethod(val value: String) {
    @SerialName("email-password")
    EMAIL_PASSWORD("email-password"),
    @SerialName("magic-url")
    MAGIC_URL("magic-url"),
    @SerialName("email-otp")
    EMAIL_OTP("email-otp"),
    @SerialName("anonymous")
    ANONYMOUS("anonymous"),
    @SerialName("invites")
    INVITES("invites"),
    @SerialName("jwt")
    JWT("jwt"),
    @SerialName("phone")
    PHONE("phone");

    override fun toString() = value
}
