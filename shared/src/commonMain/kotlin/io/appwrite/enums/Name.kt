package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Name(val value: String) {
    @SerialName("v1-database")
    V1_DATABASE("v1-database"),

    @SerialName("v1-deletes")
    V1_DELETES("v1-deletes"),

    @SerialName("v1-audits")
    V1_AUDITS("v1-audits"),

    @SerialName("v1-mails")
    V1_MAILS("v1-mails"),

    @SerialName("v1-functions")
    V1_FUNCTIONS("v1-functions"),

    @SerialName("v1-stats-resources")
    V1_STATS_RESOURCES("v1-stats-resources"),

    @SerialName("v1-stats-usage")
    V1_STATS_USAGE("v1-stats-usage"),

    @SerialName("v1-webhooks")
    V1_WEBHOOKS("v1-webhooks"),

    @SerialName("v1-certificates")
    V1_CERTIFICATES("v1-certificates"),

    @SerialName("v1-builds")
    V1_BUILDS("v1-builds"),

    @SerialName("v1-messaging")
    V1_MESSAGING("v1-messaging"),

    @SerialName("v1-migrations")
    V1_MIGRATIONS("v1-migrations");

    override fun toString() = value
}
