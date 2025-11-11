package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Theme(val value: String) {
    @SerialName("light")
    LIGHT("light"),

    @SerialName("dark")
    DARK("dark");

    override fun toString() = value
}
