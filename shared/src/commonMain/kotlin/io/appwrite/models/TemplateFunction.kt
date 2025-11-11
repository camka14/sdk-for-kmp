package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Template Function
 */
@Serializable
data class TemplateFunction(
    /**
     * Function Template Icon.
     */
    @SerialName("icon")
    val icon: String,

    /**
     * Function Template ID.
     */
    @SerialName("id")
    val id: String,

    /**
     * Function Template Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Function Template Tagline.
     */
    @SerialName("tagline")
    val tagline: String,

    /**
     * Execution permissions.
     */
    @SerialName("permissions")
    val permissions: List<String>,

    /**
     * Function trigger events.
     */
    @SerialName("events")
    val events: List<String>,

    /**
     * Function execution schedult in CRON format.
     */
    @SerialName("cron")
    val cron: String,

    /**
     * Function execution timeout in seconds.
     */
    @SerialName("timeout")
    val timeout: Long,

    /**
     * Function use cases.
     */
    @SerialName("useCases")
    val useCases: List<String>,

    /**
     * List of runtimes that can be used with this template.
     */
    @SerialName("runtimes")
    val runtimes: List<TemplateRuntime>,

    /**
     * Function Template Instructions.
     */
    @SerialName("instructions")
    val instructions: String,

    /**
     * VCS (Version Control System) Provider.
     */
    @SerialName("vcsProvider")
    val vcsProvider: String,

    /**
     * VCS (Version Control System) Repository ID
     */
    @SerialName("providerRepositoryId")
    val providerRepositoryId: String,

    /**
     * VCS (Version Control System) Owner.
     */
    @SerialName("providerOwner")
    val providerOwner: String,

    /**
     * VCS (Version Control System) branch version (tag).
     */
    @SerialName("providerVersion")
    val providerVersion: String,

    /**
     * Function variables.
     */
    @SerialName("variables")
    val variables: List<TemplateVariable>,

    /**
     * Function scopes.
     */
    @SerialName("scopes")
    val scopes: List<String>,

    )

