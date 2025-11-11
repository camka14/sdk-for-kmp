package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Template Site
 */
@Serializable
data class TemplateSite(
    /**
     * Site Template ID.
     */
    @SerialName("key")
    val key: String,

    /**
     * Site Template Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Short description of template
     */
    @SerialName("tagline")
    val tagline: String,

    /**
     * URL hosting a template demo.
     */
    @SerialName("demoUrl")
    val demoUrl: String,

    /**
     * File URL with preview screenshot in dark theme preference.
     */
    @SerialName("screenshotDark")
    val screenshotDark: String,

    /**
     * File URL with preview screenshot in light theme preference.
     */
    @SerialName("screenshotLight")
    val screenshotLight: String,

    /**
     * Site use cases.
     */
    @SerialName("useCases")
    val useCases: List<String>,

    /**
     * List of frameworks that can be used with this template.
     */
    @SerialName("frameworks")
    val frameworks: List<TemplateFramework>,

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
     * Site variables.
     */
    @SerialName("variables")
    val variables: List<TemplateVariable>,

    )

