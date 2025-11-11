package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class DeploymentDownloadType(val value: String) {
    @SerialName("source")
    SOURCE("source"),
    @SerialName("output")
    OUTPUT("output");

    override fun toString() = value
}
