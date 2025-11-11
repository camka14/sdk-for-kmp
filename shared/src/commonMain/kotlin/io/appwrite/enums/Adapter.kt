package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Adapter(val value: String) {
    @SerialName("static")
    STATIC("static"),
    @SerialName("ssr")
    SSR("ssr");

    override fun toString() = value
}
