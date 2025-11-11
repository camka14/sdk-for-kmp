package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ConsoleResourceType(val value: String) {
    @SerialName("rules")
    RULES("rules");

    override fun toString() = value
}
