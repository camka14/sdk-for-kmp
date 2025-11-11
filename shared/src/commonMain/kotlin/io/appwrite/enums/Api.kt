package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Api(val value: String) {
    @SerialName("rest")
    REST("rest"),

    @SerialName("graphql")
    GRAPHQL("graphql"),

    @SerialName("realtime")
    REALTIME("realtime");

    override fun toString() = value
}
