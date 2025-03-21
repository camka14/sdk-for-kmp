package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PlatformType(val value: String) {
    @SerialName("web")
    WEB("web"),
    @SerialName("flutter-web")
    FLUTTER_WEB("flutter-web"),
    @SerialName("flutter-ios")
    FLUTTER_IOS("flutter-ios"),
    @SerialName("flutter-android")
    FLUTTER_ANDROID("flutter-android"),
    @SerialName("flutter-linux")
    FLUTTER_LINUX("flutter-linux"),
    @SerialName("flutter-macos")
    FLUTTER_MACOS("flutter-macos"),
    @SerialName("flutter-windows")
    FLUTTER_WINDOWS("flutter-windows"),
    @SerialName("apple-ios")
    APPLE_IOS("apple-ios"),
    @SerialName("apple-macos")
    APPLE_MACOS("apple-macos"),
    @SerialName("apple-watchos")
    APPLE_WATCHOS("apple-watchos"),
    @SerialName("apple-tvos")
    APPLE_TVOS("apple-tvos"),
    @SerialName("android")
    ANDROID("android"),
    @SerialName("unity")
    UNITY("unity"),
    @SerialName("react-native-ios")
    REACT_NATIVE_IOS("react-native-ios"),
    @SerialName("react-native-android")
    REACT_NATIVE_ANDROID("react-native-android");

    override fun toString() = value
}
