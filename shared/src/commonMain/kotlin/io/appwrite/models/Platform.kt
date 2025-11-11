package io.appwrite.models

import io.appwrite.enums.PlatformType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Platform
 */
@Serializable
data class Platform(
    /**
     * Platform ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Platform creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Platform update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Platform name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Platform type. Possible values are: web, flutter-web, flutter-ios, flutter-android, flutter-linux, flutter-macos, flutter-windows, apple-ios, apple-macos, apple-watchos, apple-tvos, android, unity, react-native-ios, react-native-android.
     */
    @SerialName("type")
    val type: PlatformType,

    /**
     * Platform Key. iOS bundle ID or Android package name.  Empty string for other platforms.
     */
    @SerialName("key")
    val key: String,

    /**
     * App store or Google Play store ID.
     */
    @SerialName("store")
    val store: String,

    /**
     * Web app hostname. Empty string for other platforms.
     */
    @SerialName("hostname")
    val hostname: String,

    /**
     * HTTP basic authentication username.
     */
    @SerialName("httpUser")
    val httpUser: String,

    /**
     * HTTP basic authentication password.
     */
    @SerialName("httpPass")
    val httpPass: String,

    )

