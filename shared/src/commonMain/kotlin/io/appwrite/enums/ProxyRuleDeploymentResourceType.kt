package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProxyRuleDeploymentResourceType(val value: String) {
    @SerialName("function")
    FUNCTION("function"),
    @SerialName("site")
    SITE("site");

    override fun toString() = value
}
