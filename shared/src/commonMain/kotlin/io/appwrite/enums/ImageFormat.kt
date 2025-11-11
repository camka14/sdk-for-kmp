package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class ImageFormat(val value: String) {
    @SerialName("jpg")
    JPG("jpg"),
    @SerialName("jpeg")
    JPEG("jpeg"),
    @SerialName("png")
    PNG("png"),
    @SerialName("webp")
    WEBP("webp"),
    @SerialName("heic")
    HEIC("heic"),
    @SerialName("avif")
    AVIF("avif"),
    @SerialName("gif")
    GIF("gif");

    override fun toString() = value
}
