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
import java.net.HttpCookie.domainMatches

class DataStoreCookieStorage(private val dataStoreManager: DataStoreManager) : CookiesStorage {
    private val storageMutex = Mutex()
    private suspend fun loadCookies(): List<SerializableCookie> {
        val jsonString = dataStoreManager.read()
        return if (jsonString != null) {
            try {
                val cookies = json.decodeFromString(
                    ListSerializer(SerializableCookie.serializer()),
                    jsonString
                ).filter { it.isNotExpired() }
                saveCookies(cookies)
                cookies
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

    override suspend fun get(requestUrl: Url): List<Cookie> = storageMutex.withLock {
        return loadCookies()
            .filter { it.cookieApplies(requestUrl) }
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
                val validCookies = loadCookies().filter { it.isNotExpired() }
                saveCookies(validCookies)
            }
        }
    }
}