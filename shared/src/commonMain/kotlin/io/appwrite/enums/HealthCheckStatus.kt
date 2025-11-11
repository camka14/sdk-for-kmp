package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class HealthCheckStatus(val value: String) {
    @SerialName("pass")
    PASS("pass"),

    @SerialName("fail")
    FAIL("fail");

    override fun toString() = value
}
