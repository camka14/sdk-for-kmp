package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class Framework(val value: String) {
    @SerialName("analog")
    ANALOG("analog"),

    @SerialName("angular")
    ANGULAR("angular"),

    @SerialName("nextjs")
    NEXTJS("nextjs"),

    @SerialName("react")
    REACT("react"),

    @SerialName("nuxt")
    NUXT("nuxt"),

    @SerialName("vue")
    VUE("vue"),

    @SerialName("sveltekit")
    SVELTEKIT("sveltekit"),

    @SerialName("astro")
    ASTRO("astro"),

    @SerialName("tanstack-start")
    TANSTACK_START("tanstack-start"),

    @SerialName("remix")
    REMIX("remix"),

    @SerialName("lynx")
    LYNX("lynx"),

    @SerialName("flutter")
    FLUTTER("flutter"),

    @SerialName("react-native")
    REACT_NATIVE("react-native"),

    @SerialName("vite")
    VITE("vite"),

    @SerialName("other")
    OTHER("other");

    override fun toString() = value
}
