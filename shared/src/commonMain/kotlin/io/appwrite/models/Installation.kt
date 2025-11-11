package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Installation
 */
@Serializable
data class Installation(
    /**
     * Function ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Function creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Function update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * VCS (Version Control System) provider name.
     */
    @SerialName("provider")
    val provider: String,

    /**
     * VCS (Version Control System) organization name.
     */
    @SerialName("organization")
    val organization: String,

    /**
     * VCS (Version Control System) installation ID.
     */
    @SerialName("providerInstallationId")
    val providerInstallationId: String,

    )

