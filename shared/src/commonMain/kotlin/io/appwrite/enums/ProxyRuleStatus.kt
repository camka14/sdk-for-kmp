package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ProxyRuleStatus(val value: String) {
    @SerialName("created")
    CREATED("created"),
    @SerialName("verifying")
    VERIFYING("verifying"),
    @SerialName("verified")
    VERIFIED("verified"),
    @SerialName("unverified")
    UNVERIFIED("unverified");

    override fun toString() = value
}
