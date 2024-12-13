package io.appwrite.cookies

import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.http.Cookie
import io.ktor.http.Url
import platform.Foundation.NSDate
import platform.Foundation.NSHTTPCookie
import platform.Foundation.NSHTTPCookieAcceptPolicy
import platform.Foundation.NSHTTPCookieDomain
import platform.Foundation.NSHTTPCookieExpires
import platform.Foundation.NSHTTPCookieName
import platform.Foundation.NSHTTPCookiePath
import platform.Foundation.NSHTTPCookieStorage
import platform.Foundation.NSHTTPCookieValue
import platform.Foundation.NSURL
import platform.Foundation.NSUserDefaults
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970

class IosCookieStorage : CookiesStorage {
    private val cookieStorage = NSHTTPCookieStorage.sharedHTTPCookieStorage.apply {
        cookieAcceptPolicy = NSHTTPCookieAcceptPolicy.NSHTTPCookieAcceptPolicyAlways
    }

    override suspend fun get(requestUrl: Url): List<Cookie> {
        syncCookies()
        val nsUrl = NSURL(string = requestUrl.toString())

        val httpCookies = cookieStorage.cookiesForURL(nsUrl)

        return httpCookies?.map { cookie ->
            (cookie as NSHTTPCookie).toKtorCookie()
        } ?: emptyList()
    }

    override suspend fun addCookie(requestUrl: Url, cookie: Cookie) {
        val nsUrl = NSURL(string = requestUrl.toString())
        val domain = cookie.domain ?: ".${requestUrl.host}"

        val properties = mutableMapOf<Any?, Any?>(
            NSHTTPCookieName to cookie.name,
            NSHTTPCookieValue to cookie.value,
            NSHTTPCookiePath to (cookie.path ?: "/"),
            NSHTTPCookieDomain to domain
        )

        // Add expiration if present
        cookie.expires?.let { expires ->
            properties[NSHTTPCookieExpires] = NSDate.dateWithTimeIntervalSince1970(
                expires.timestamp.toDouble()
            )
        }

        // Store in UserDefaults
        val cookieString = cookie.toString()
        val existing =
            NSUserDefaults.standardUserDefaults.stringArrayForKey(domain)?.toMutableList()
                ?: mutableListOf()
        existing.add(cookieString)
        NSUserDefaults.standardUserDefaults.setObject(existing, domain)

        // Create and store the cookie
        NSHTTPCookie.cookiesWithResponseHeaderFields(
            mapOf("Set-Cookie" to "${cookie.name}=${cookie.value}; Domain=${domain}; Path=${cookie.path ?: "/"}"),
            nsUrl
        ).forEach { nsCookie ->
            nsCookie as NSHTTPCookie
            cookieStorage.setCookie(nsCookie)
        }
    }

    override fun close() {
        println("Closing cookie storage")
        cookieStorage.cookies?.forEach { cookie ->
            cookie as NSHTTPCookie
            cookieStorage.deleteCookie(cookie)
        }
    }

    private fun syncCookies() {
        cookieStorage.cookies?.forEach { cookie ->
            cookie as NSHTTPCookie
            val domain = cookie.domain
            val cookieString = "${cookie.name}=${cookie.value}"


            val existing = NSUserDefaults.standardUserDefaults
                .stringArrayForKey(domain)?.toMutableList() ?: mutableListOf()

            if (!existing.contains(cookieString)) {
                existing.add(cookieString)
                NSUserDefaults.standardUserDefaults.setObject(existing, domain)
            }
        }
    }

    private fun NSHTTPCookie.toKtorCookie(): Cookie = Cookie(
        name = name,
        value = value,
        domain = domain,
        path = path,
        secure = isSecure(),
        httpOnly = isHTTPOnly(),
        maxAge = expiresDate?.let {
            ((it.timeIntervalSince1970 - NSDate().timeIntervalSince1970) / 1000).toInt()
        }
    )
}