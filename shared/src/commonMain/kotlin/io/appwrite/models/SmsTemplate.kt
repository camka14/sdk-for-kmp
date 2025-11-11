package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * SmsTemplate
 */
@Serializable
data class SmsTemplate(
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

    )

