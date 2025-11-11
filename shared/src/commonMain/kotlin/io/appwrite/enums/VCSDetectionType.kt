package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class VCSDetectionType(val value: String) {
    @SerialName("runtime")
    RUNTIME("runtime"),
    @SerialName("framework")
    FRAMEWORK("framework");

    override fun toString() = value
}
