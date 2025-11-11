package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Compression(val value: String) {
    @SerialName("none")
    NONE("none"),

    @SerialName("gzip")
    GZIP("gzip"),

    @SerialName("zstd")
    ZSTD("zstd");

    override fun toString() = value
}
