package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Browser(val value: String) {
    @SerialName("aa")
    AVANT_BROWSER("aa"),
    @SerialName("an")
    ANDROID_WEBVIEW_BETA("an"),
    @SerialName("ch")
    GOOGLE_CHROME("ch"),
    @SerialName("ci")
    GOOGLE_CHROME_IOS("ci"),
    @SerialName("cm")
    GOOGLE_CHROME_MOBILE("cm"),
    @SerialName("cr")
    CHROMIUM("cr"),
    @SerialName("ff")
    MOZILLA_FIREFOX("ff"),
    @SerialName("sf")
    SAFARI("sf"),
    @SerialName("mf")
    MOBILE_SAFARI("mf"),
    @SerialName("ps")
    MICROSOFT_EDGE("ps"),
    @SerialName("oi")
    MICROSOFT_EDGE_IOS("oi"),
    @SerialName("om")
    OPERA_MINI("om"),
    @SerialName("op")
    OPERA("op"),
    @SerialName("on")
    OPERA_NEXT("on");

    override fun toString() = value
}