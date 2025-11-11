package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ExecutionTrigger(val value: String) {
    @SerialName("http")
    HTTP("http"),
    @SerialName("schedule")
    SCHEDULE("schedule"),
    @SerialName("event")
    EVENT("event");

    override fun toString() = value
}
