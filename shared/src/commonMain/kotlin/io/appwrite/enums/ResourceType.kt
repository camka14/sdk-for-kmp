package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ResourceType(val value: String) {
    @SerialName("api")
    API("api"),
    @SerialName("function")
    FUNCTION("function");

    override fun toString() = value
}
