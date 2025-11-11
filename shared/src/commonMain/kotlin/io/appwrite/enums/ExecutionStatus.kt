package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ExecutionStatus(val value: String) {
    @SerialName("waiting")
    WAITING("waiting"),

    @SerialName("processing")
    PROCESSING("processing"),

    @SerialName("completed")
    COMPLETED("completed"),

    @SerialName("failed")
    FAILED("failed"),

    @SerialName("scheduled")
    SCHEDULED("scheduled");

    override fun toString() = value
}
