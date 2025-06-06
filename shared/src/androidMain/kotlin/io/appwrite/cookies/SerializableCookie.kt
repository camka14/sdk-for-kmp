package io.appwrite.cookies

import io.ktor.http.Cookie
import io.ktor.http.Url
import kotlinx.serialization.Serializable

@Serializable
data class SerializableCookie(
    val name: String,
    val value: String,
    val domain: String? = null,
    val path: String = "/",
    val maxAge: Int? = null,
    val secure: Boolean = false,
    val httpOnly: Boolean = false,
    val expiration: Long = System.currentTimeMillis() + (maxAge?.times(1000L) ?: 2592000000L)
) {
    fun toCookie(): Cookie = Cookie(
        name = name,
        value = value,
        domain = domain,
        path = path,
        maxAge = maxAge,
        secure = secure,
        httpOnly = httpOnly
    )

    companion object {
        fun fromCookie(cookie: Cookie): SerializableCookie = SerializableCookie(
            name = cookie.name,
            value = cookie.value,
            domain = cookie.domain,
            path = cookie.path ?: "/",
            maxAge = cookie.maxAge,
            secure = cookie.secure,
            httpOnly = cookie.httpOnly
        )
    }

    fun isNotExpired(): Boolean {
        return System.currentTimeMillis() < expiration
    }

    private fun domainMatches(requestHost: String?): Boolean {
        val cd = domain?.lowercase()
        val host = requestHost?.lowercase()
        return if (cd != null && host != null) {
            if (cd.startsWith(".")) {
                host == cd.substring(1) || host.endsWith(cd)
            } else if (requestHost.startsWith(".")) {
                host == host.substring(1) || cd.endsWith(cd)
            } else {
                host == cd
            }
        } else {
            false
        }
    }

    private fun pathMatches(requestPath: String): Boolean {
        return requestPath.startsWith(path)
    }

    fun cookieApplies(requestUrl: Url): Boolean {
        if (!isNotExpired()) return false
        if (!domainMatches(requestUrl.host)) return false

        val requestPath = requestUrl.encodedPath.ifEmpty { "/" }
        if (!pathMatches(requestPath)) return false

        if (secure && requestUrl.protocol.name != "https") return false

        return true
    }
}