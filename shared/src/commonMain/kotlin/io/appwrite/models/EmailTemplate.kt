package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * EmailTemplate
 */
@Serializable
data class EmailTemplate(
    /**
     * Template type
     */
    @SerialName("type")
    val type: String,

    /**
     * Template locale
     */
    @SerialName("locale")
    val locale: String,

    /**
     * Template message
     */
    @SerialName("message")
    val message: String,

    /**
     * Name of the sender
     */
    @SerialName("senderName")
    val senderName: String,

    /**
     * Email of the sender
     */
    @SerialName("senderEmail")
    val senderEmail: String,

    /**
     * Reply to email address
     */
    @SerialName("replyTo")
    val replyTo: String,

    /**
     * Email subject
     */
    @SerialName("subject")
    val subject: String,

    )

