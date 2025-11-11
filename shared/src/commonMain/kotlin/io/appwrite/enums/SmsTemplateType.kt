package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class SmsTemplateType(val value: String) {
    @SerialName("verification")
    VERIFICATION("verification"),
    @SerialName("login")
    LOGIN("login"),
    @SerialName("invitation")
    INVITATION("invitation"),
    @SerialName("mfachallenge")
    MFACHALLENGE("mfachallenge");

    override fun toString() = value
}
