package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Template Variable
 */
@Serializable
data class TemplateVariable(
    /**
     * Variable Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Variable Description.
     */
    @SerialName("description")
    val description: String,

    /**
     * Variable Value.
     */
    @SerialName("value")
    val value: String,

    /**
     * Variable secret flag. Secret variables can only be updated or deleted, but never read.
     */
    @SerialName("secret")
    val secret: Boolean,

    /**
     * Variable Placeholder.
     */
    @SerialName("placeholder")
    val placeholder: String,

    /**
     * Is the variable required?
     */
    @SerialName("required")
    val required: Boolean,

    /**
     * Variable Type.
     */
    @SerialName("type")
    val type: String,

    )

