package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class DeploymentStatus(val value: String) {
    @SerialName("waiting")
    WAITING("waiting"),
    @SerialName("processing")
    PROCESSING("processing"),
    @SerialName("building")
    BUILDING("building"),
    @SerialName("ready")
    READY("ready"),
    @SerialName("failed")
    FAILED("failed");

    override fun toString() = value
}
