package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class StorageUsageRange(val value: String) {
    @SerialName("24h")
    TWENTY_FOUR_HOURS("24h"),
    @SerialName("30d")
    THIRTY_DAYS("30d"),
    @SerialName("90d")
    NINETY_DAYS("90d");

    override fun toString() = value
}
