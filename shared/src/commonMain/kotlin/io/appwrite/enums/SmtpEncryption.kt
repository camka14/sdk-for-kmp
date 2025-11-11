package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SmtpEncryption(val value: String) {
    @SerialName("none")
    NONE("none"),
    @SerialName("ssl")
    SSL("ssl"),
    @SerialName("tls")
    TLS("tls");

    override fun toString() = value
}
