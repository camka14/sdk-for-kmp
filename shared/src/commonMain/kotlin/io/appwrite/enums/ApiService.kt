package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ApiService(val value: String) {
    @SerialName("account")
    ACCOUNT("account"),

    @SerialName("avatars")
    AVATARS("avatars"),

    @SerialName("databases")
    DATABASES("databases"),

    @SerialName("tablesdb")
    TABLESDB("tablesdb"),

    @SerialName("locale")
    LOCALE("locale"),

    @SerialName("health")
    HEALTH("health"),

    @SerialName("storage")
    STORAGE("storage"),

    @SerialName("teams")
    TEAMS("teams"),

    @SerialName("users")
    USERS("users"),

    @SerialName("sites")
    SITES("sites"),

    @SerialName("functions")
    FUNCTIONS("functions"),

    @SerialName("graphql")
    GRAPHQL("graphql"),

    @SerialName("messaging")
    MESSAGING("messaging");

    override fun toString() = value
}
