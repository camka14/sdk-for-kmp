package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SMTPSecure(val value: String) {
    @SerialName("tls")
    TLS("tls"),

    @SerialName("ssl")
    SSL("ssl");

    override fun toString() = value
}
