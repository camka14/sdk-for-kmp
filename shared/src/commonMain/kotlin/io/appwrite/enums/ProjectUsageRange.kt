package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProjectUsageRange(val value: String) {
    @SerialName("1h")
    ONE_HOUR("1h"),
    @SerialName("1d")
    ONE_DAY("1d");

    override fun toString() = value
}
