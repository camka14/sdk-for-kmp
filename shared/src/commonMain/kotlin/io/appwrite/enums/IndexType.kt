package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class IndexType(val value: String) {
    @SerialName("key")
    KEY("key"),

    @SerialName("fulltext")
    FULLTEXT("fulltext"),

    @SerialName("unique")
    UNIQUE("unique"),

    @SerialName("spatial")
    SPATIAL("spatial");

    override fun toString() = value
}
