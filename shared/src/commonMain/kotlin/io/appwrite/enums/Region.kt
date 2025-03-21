package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Region(val value: String) {
    @SerialName("default")
    DEFAULT("default"),
    @SerialName("fra")
    FRA("fra");

    override fun toString() = value
}
