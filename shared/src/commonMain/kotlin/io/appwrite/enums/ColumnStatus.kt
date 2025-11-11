package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ColumnStatus(val value: String) {
    @SerialName("available")
    AVAILABLE("available"),

    @SerialName("processing")
    PROCESSING("processing"),

    @SerialName("deleting")
    DELETING("deleting"),

    @SerialName("stuck")
    STUCK("stuck"),

    @SerialName("failed")
    FAILED("failed");

    override fun toString() = value
}
