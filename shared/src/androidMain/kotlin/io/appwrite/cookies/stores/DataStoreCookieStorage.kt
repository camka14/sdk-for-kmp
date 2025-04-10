package io.appwrite.cookies.stores

import io.appwrite.cookies.SerializableCookie
import io.appwrite.extensions.json
import io.ktor.client.plugins.cookies.CookiesStorage
import io.ktor.http.Cookie
import io.ktor.http.Url
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import kotlinx.serialization.builtins.ListSerializer

class DataStoreCookieStorage(private val dataStoreManager: DataStoreManager) : CookiesStorage {
    private val storageMutex = Mutex()
    private suspend fun loadCookies(): List<SerializableCookie> {
        val jsonString = dataStoreManager.read()
        return if (jsonString != null) {
            try {
                json.decodeFromString(ListSerializer(SerializableCookie.serializer()), jsonString)
            } catch (e: Exception) {
                throw Exception("Error parsing cookies from DataStore", e)
            }
        } else {
            emptyList()
        }
    }

    private suspend fun saveCookies(cookies: List<SerializableCookie>) {
        val jsonString =
            json.encodeToString(ListSerializer(SerializableCookie.serializer()), cookies)
        dataStoreManager.write(jsonString)
    }

    private fun isNotExpired(cookie: SerializableCookie): Boolean {
        return cookie.expiration.let { System.currentTimeMillis() < it }
    }

    private fun domainMatches(cookieDomain: String?, requestHost: String?): Boolean {
        val cd = cookieDomain?.lowercase()
        val host = requestHost?.lowercase()
        return if (cd != null && host != null) {
            if (cd.startsWith(".")) {
                host == cd.substring(1) || host.endsWith(cd)
            } else if (requestHost.startsWith(".")){
                host == host.substring(1) || cd.endsWith(cd)
            } else {
                host == cd
            }
        } else {
            false
        }
    }

    private fun pathMatches(cookiePath: String, requestPath: String): Boolean {
        return requestPath.startsWith(cookiePath)
    }

    private fun cookieApplies(cookie: SerializableCookie, requestUrl: Url): Boolean {
        if (!isNotExpired(cookie)) return false
        val cookieDomain = cookie.domain ?: return false
        if (!domainMatches(cookieDomain, requestUrl.host)) return false

        val cookiePath = cookie.path
        val requestPath = requestUrl.encodedPath.ifEmpty { "/" }
        if (!pathMatches(cookiePath, requestPath)) return false

        if (cookie.secure && requestUrl.protocol.name != "https") return false

        return true
    }

    override suspend fun get(requestUrl: Url): List<Cookie> = storageMutex.withLock {
        return loadCookies()
            .filter { cookieApplies(it, requestUrl) }
            .map { it.toCookie() }
    }

    override suspend fun addCookie(requestUrl: Url, cookie: Cookie): Unit = storageMutex.withLock {
        val newCookie = SerializableCookie.fromCookie(cookie)
        val cookies = loadCookies().toMutableList()
        cookies.removeAll { existing ->
            existing.name == newCookie.name &&
                    domainMatches(existing.domain, newCookie.domain) &&
                    existing.path == newCookie.path
        }
        cookies.add(newCookie)
        saveCookies(cookies)
    }

    override fun close() {
        runBlocking {
            storageMutex.withLock {
                val validCookies = loadCookies().filter { isNotExpired(it) }
                saveCookies(validCookies)
            }
        }
    }
}