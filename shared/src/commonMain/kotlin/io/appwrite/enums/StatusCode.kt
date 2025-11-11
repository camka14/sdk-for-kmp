package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class StatusCode(val value: String) {
    @SerialName("301")
    MOVED_PERMANENTLY_301("301"),

    @SerialName("302")
    FOUND_302("302"),

    @SerialName("307")
    TEMPORARY_REDIRECT_307("307"),

    @SerialName("308")
    PERMANENT_REDIRECT_308("308");

    override fun toString() = value
}
