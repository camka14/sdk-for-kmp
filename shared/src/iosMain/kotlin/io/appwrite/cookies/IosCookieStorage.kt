package io.appwrite.cookies

import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.http.Cookie
import io.ktor.http.Url
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import platform.Foundation.NSDate
import platform.Foundation.NSDateFormatter
import platform.Foundation.NSHTTPCookie
import platform.Foundation.NSHTTPCookieAcceptPolicy
import platform.Foundation.NSHTTPCookieDomain
import platform.Foundation.NSHTTPCookieName
import platform.Foundation.NSHTTPCookiePath
import platform.Foundation.NSHTTPCookieStorage
import platform.Foundation.NSHTTPCookieValue
import platform.Foundation.NSRecursiveLock
import platform.Foundation.NSTimeZone
import platform.Foundation.NSURL
import platform.Foundation.NSUserDefaults
import platform.Foundation.dateWithTimeIntervalSince1970
import platform.Foundation.timeIntervalSince1970
import platform.Foundation.timeZoneWithAbbreviation
import kotlin.collections.component1
import kotlin.collections.component2

@Serializable
private data class StoredCookie(
    val name: String,
    val value: String,
    val domain: String,
    val path: String,
    val expires: Double?,
    val isSecure: Boolean,
    val isHttpOnly: Boolean,
    val maxAge: Int? = null
)

class IosCookieStorage : CookiesStorage {
    private val cookieStorage = NSHTTPCookieStorage.sharedHTTPCookieStorage.apply {
        cookieAcceptPolicy = NSHTTPCookieAcceptPolicy.NSHTTPCookieAcceptPolicyAlways
    }
    private val lock = NSRecursiveLock()
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    init {
        initialize()
    }

    private fun initialize() {
        lock.lock()
        try {
            cleanupExpiredCookies()
            restoreCookies()
        } finally {
            lock.unlock()
        }
    }

    override suspend fun get(requestUrl: Url): List<Cookie> {
        lock.lock()
        return try {
            val nsUrl = NSURL(string = requestUrl.toString())
            cookieStorage.cookiesForURL(nsUrl)
                ?.map { (it as NSHTTPCookie).toKtorCookie() }
                ?: emptyList()
        } finally {
            lock.unlock()
        }
    }

    override suspend fun addCookie(requestUrl: Url, cookie: Cookie) {
        lock.lock()
        try {
            val nsUrl = NSURL(string = requestUrl.toString())
            val domain = cookie.domain ?: requestUrl.host

            val setCookieHeader = buildCookieHeader(cookie, domain)
            val storedCookie = createStoredCookie(cookie, domain)

            persistCookie(storedCookie)

            NSHTTPCookie.cookiesWithResponseHeaderFields(
                mapOf("Set-Cookie" to setCookieHeader),
                nsUrl
            ).forEach {
                cookieStorage.setCookie(it as NSHTTPCookie)
            }
        } finally {
            lock.unlock()
        }
    }

    override fun close() {
        lock.lock()
        try {
            cookieStorage.cookies?.forEach {
                cookieStorage.deleteCookie(it as NSHTTPCookie)
            }
            clearStoredCookies()
        } finally {
            lock.unlock()
        }
    }

    private fun buildCookieHeader(cookie: Cookie, domain: String): String = buildString {
        append("${cookie.name}=${cookie.value}")
        val cookieDomain = if (!domain.startsWith(".") && !domain.equals("localhost", true)) {
            ".$domain"
        } else domain
        append("; Domain=${cookieDomain}")
        append("; Path=${cookie.path ?: "/"}")
        cookie.expires?.let { gmtDate ->
            append("; Expires=${formatDate(gmtDate.timestamp)}")
        }
        cookie.maxAge?.let {
            append("; Max-Age=$it")
        }
        if (cookie.secure) append("; Secure")
        if (cookie.httpOnly) append("; HttpOnly")
    }


    private fun createStoredCookie(cookie: Cookie, domain: String) = StoredCookie(
        name = cookie.name,
        value = cookie.value,
        domain = domain,
        path = cookie.path ?: "/",
        expires = cookie.expires?.timestamp?.toDouble(),
        isSecure = cookie.secure,
        isHttpOnly = cookie.httpOnly,
        maxAge = cookie.maxAge
    )

    private fun persistCookie(storedCookie: StoredCookie) {
        val key = getCookieKey(storedCookie.domain, storedCookie.name, storedCookie.path)
        val cookieJson = json.encodeToString(StoredCookie.serializer(), storedCookie)
        NSUserDefaults.standardUserDefaults.setObject(cookieJson, key)
    }

    private fun restoreCookies() {
        val userDefaults = NSUserDefaults.standardUserDefaults
        userDefaults.dictionaryRepresentation().forEach { (key, value) ->
            if (key !is String || !key.startsWith("cookie:")) return@forEach

            try {
                val cookieJson = value as? String ?: return@forEach
                val storedCookie = json.decodeFromString(StoredCookie.serializer(), cookieJson)

                if (isExpired(storedCookie)) {
                    userDefaults.removeObjectForKey(key)
                    return@forEach
                }

                if (storedCookie.domain.isNotBlank() && storedCookie.path.isNotBlank()) {
                    recreateCookie(storedCookie)
                } else {
                    userDefaults.removeObjectForKey(key)
                }
            } catch (e: Exception) {
                userDefaults.removeObjectForKey(key)
            }
        }
    }


    private fun recreateCookie(storedCookie: StoredCookie) {
        val properties = mutableMapOf<Any?, Any?>(
            NSHTTPCookieName to storedCookie.name,
            NSHTTPCookieValue to storedCookie.value,
            NSHTTPCookiePath to storedCookie.path,
            NSHTTPCookieDomain to storedCookie.domain
        )

        NSHTTPCookie.cookieWithProperties(properties)?.let {
            cookieStorage.setCookie(it)
        }
    }

    private fun cleanupExpiredCookies() {
        cookieStorage.cookies?.forEach { cookie ->
            cookie as NSHTTPCookie
            if (isExpired(cookie)) {
                cookieStorage.deleteCookie(cookie)
                removeFromUserDefaults(cookie)
            }
        }
    }

    private fun isExpired(cookie: NSHTTPCookie): Boolean {
        val expiresDate = cookie.expiresDate ?: return false
        return expiresDate.timeIntervalSince1970 < NSDate().timeIntervalSince1970
    }

    private fun isExpired(cookie: StoredCookie): Boolean {
        val expires = cookie.expires ?: return false
        return (expires / 1000) < NSDate().timeIntervalSince1970
    }

    private fun removeFromUserDefaults(cookie: NSHTTPCookie) {
        val key = getCookieKey(cookie.domain, cookie.name, cookie.path)
        NSUserDefaults.standardUserDefaults.removeObjectForKey(key)
    }

    private fun clearStoredCookies() {
        val userDefaults = NSUserDefaults.standardUserDefaults
        userDefaults.dictionaryRepresentation().keys
            .filter { (it as? String)?.startsWith("cookie:") == true }
            .forEach { key ->
                userDefaults.removeObjectForKey(key as String)
            }
    }


    private fun getCookieKey(domain: String, name: String, path: String): String {
        return "cookie:$domain:$name:$path"
    }

    private fun formatDate(timestamp: Long): String {
        val date = NSDate.dateWithTimeIntervalSince1970(timestamp.toDouble() / 1000)
        val formatter = NSDateFormatter().apply {
            dateFormat = "EEE, dd MMM yyyy HH:mm:ss 'GMT'"
            timeZone = NSTimeZone.timeZoneWithAbbreviation("GMT")!!
        }
        return formatter.stringFromDate(date)
    }


    private fun NSHTTPCookie.toKtorCookie(): Cookie = Cookie(
        name = name,
        value = value,
        domain = domain,
        path = path,
        secure = isSecure(),
        httpOnly = isHTTPOnly(),
        maxAge = expiresDate?.let {
            (it.timeIntervalSince1970 - NSDate().timeIntervalSince1970).toInt()
        }
    )
}
