package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * AuthProvider
 */
@Serializable
data class AuthProvider(
    /**
     * Auth Provider.
     */
    @SerialName("key")
    val key: String,

    /**
     * Auth Provider name.
     */
    @SerialName("name")
    val name: String,

    /**
     * OAuth 2.0 application ID.
     */
    @SerialName("appId")
    val appId: String,

    /**
     * OAuth 2.0 application secret. Might be JSON string if provider requires extra configuration.
     */
    @SerialName("secret")
    val secret: String,

    /**
     * Auth Provider is active and can be used to create session.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    )

