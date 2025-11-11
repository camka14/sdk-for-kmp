package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProxyResourceType(val value: String) {
    @SerialName("site")
    SITE("site"),

    @SerialName("function")
    FUNCTION("function");

    override fun toString() = value
}
