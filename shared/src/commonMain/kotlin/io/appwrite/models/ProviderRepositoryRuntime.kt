package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * ProviderRepositoryRuntime
 */
@Serializable
data class ProviderRepositoryRuntime(
    /**
     * VCS (Version Control System) repository ID.
     */
    @SerialName("id")
    val id: String,

    /**
     * VCS (Version Control System) repository name.
     */
    @SerialName("name")
    val name: String,

    /**
     * VCS (Version Control System) organization name
     */
    @SerialName("organization")
    val organization: String,

    /**
     * VCS (Version Control System) provider name.
     */
    @SerialName("provider")
    val provider: String,

    /**
     * Is VCS (Version Control System) repository private?
     */
    @SerialName("xprivate")
    val xprivate: Boolean,

    /**
     * VCS (Version Control System) repository&#039;s default branch name.
     */
    @SerialName("defaultBranch")
    val defaultBranch: String,

    /**
     * Last commit date in ISO 8601 format.
     */
    @SerialName("pushedAt")
    val pushedAt: String,

    /**
     * Auto-detected runtime. Empty if type is not &quot;runtime&quot;.
     */
    @SerialName("runtime")
    val runtime: String,

    )

