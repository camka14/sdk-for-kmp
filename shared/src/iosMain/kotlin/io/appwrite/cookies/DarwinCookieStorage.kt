package io.appwrite.cookies

import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.http.Cookie
import io.ktor.http.Url
import kotlinx.coroutines.internal.Storage.put

class DarwinCookieStorage : CookiesStorage {
    private val storage = NSHTTPCookieStorage.sharedHTTPCookieStorage

    override suspend fun addCookie(requestUrl: Url, cookie: Cookie) {
        val properties = mutableMapOf<NSString, Any>().apply {
            put(NSHTTPCookieName, cookie.name)
            put(NSHTTPCookieValue, cookie.value)
            put(NSHTTPCookieDomain, cookie.domain)
            put(NSHTTPCookiePath, cookie.path)

            if (cookie.maxAge != null) {
                val date = NSDate().dateByAddingTimeInterval(cookie.maxAge.toDouble())
                put(NSHTTPCookieExpires, date)
            }

            if (cookie.secure) {
                put(NSHTTPCookieSecure, "YES")
            }

            if (cookie.httpOnly) {
                put(NSHTTPCookieHTTPOnly, "YES")
            }
        }

        NSHTTPCookie.cookieWithProperties(properties)?.let {
            storage.setCookie(it)
        }
    }

    override suspend fun get(requestUrl: Url): List<Cookie> {
        return storage.cookies?.mapNotNull { nsCookie ->
            Cookie(
                name = nsCookie.name,
                value = nsCookie.value,
                domain = nsCookie.domain,
                path = nsCookie.path,
                secure = nsCookie.isSecure,
                httpOnly = nsCookie.isHTTPOnly,
                maxAge = nsCookie.expiresDate?.let {
                    ((it.timeIntervalSince1970 - NSDate().timeIntervalSince1970) / 1000).toInt()
                }
            )
        } ?: emptyList()
    }

    override suspend fun clear() {
        storage.cookies?.forEach {
            storage.deleteCookie(it)
        }
    }
}