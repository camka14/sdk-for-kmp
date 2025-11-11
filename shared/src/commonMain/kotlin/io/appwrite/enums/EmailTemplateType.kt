package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class EmailTemplateType(val value: String) {
    @SerialName("verification")
    VERIFICATION("verification"),
    @SerialName("magicsession")
    MAGICSESSION("magicsession"),
    @SerialName("recovery")
    RECOVERY("recovery"),
    @SerialName("invitation")
    INVITATION("invitation"),
    @SerialName("mfachallenge")
    MFACHALLENGE("mfachallenge"),
    @SerialName("sessionalert")
    SESSIONALERT("sessionalert"),
    @SerialName("otpsession")
    OTPSESSION("otpsession");

    override fun toString() = value
}
