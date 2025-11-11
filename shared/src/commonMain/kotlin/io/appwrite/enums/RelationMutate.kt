package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RelationMutate(val value: String) {
    @SerialName("cascade")
    CASCADE("cascade"),

    @SerialName("restrict")
    RESTRICT("restrict"),

    @SerialName("setNull")
    SETNULL("setNull");

    override fun toString() = value
}
