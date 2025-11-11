package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class VCSDeploymentType(val value: String) {
    @SerialName("branch")
    BRANCH("branch"),

    @SerialName("commit")
    COMMIT("commit"),

    @SerialName("tag")
    TAG("tag");

    override fun toString() = value
}
