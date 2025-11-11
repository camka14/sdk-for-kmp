package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class DatabaseType(val value: String) {
    @SerialName("legacy")
    LEGACY("legacy"),

    @SerialName("tablesdb")
    TABLESDB("tablesdb");

    override fun toString() = value
}
