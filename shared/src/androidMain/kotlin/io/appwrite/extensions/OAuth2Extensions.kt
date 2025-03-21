package io.appwrite.extensions

import androidx.activity.ComponentActivity
import io.appwrite.WebAuthComponent
import io.appwrite.cookies.SerializableCookie
import io.appwrite.exceptions.AppwriteException
import io.appwrite.webInterface.UrlParser
import io.ktor.http.Url
import kotlinx.coroutines.runBlocking

suspend fun io.appwrite.services.Account.createOAuth2Session(
    activity: ComponentActivity,
    provider: io.appwrite.enums.OAuthProvider,
    success: String? = null,
    failure: String? = null,
    scopes: List<String>? = null,
    ) {
        val apiPath = "/account/sessions/oauth2/{provider}"
            .replace("{provider}", provider.value)

        val apiParams = mutableMapOf<String, Any?>(
            "success" to success,
            "failure" to failure,
            "scopes" to scopes,
            "project" to client.config["project"],
        )

        val apiQuery = mutableListOf<String>()
        apiParams.forEach {
            when (it.value) {
                null -> return@forEach
                is List<*> -> apiQuery.add("${it.key}[]=${it.value.toString()}")
                else -> apiQuery.add("${it.key}=${it.value.toString()}")
            }
        }

        val urlParser = UrlParser()
        val fullUrl = "${client.endpoint}${apiPath}?${apiQuery.joinToString("&")}"
        val apiUrl = urlParser.parse(fullUrl)
        val callbackUrlScheme = "appwrite-callback-${client.config["project"]}"

        WebAuthComponent.authenticate(activity, apiUrl.toString(), callbackUrlScheme) {
            if (it.isFailure) {
                throw it.exceptionOrNull()!!
            }

            val resultUrl = it.getOrNull()!!
            val key = urlParser.getQueryParameter(resultUrl, "key")
            val secret = urlParser.getQueryParameter(resultUrl, "secret")
            if (key == null || secret == null) {
                throw AppwriteException("Authentication cookie missing!")
            }

        val host = urlParser.getHost(client.endpoint)
        val cookie = SerializableCookie(
            name = key,
            value = secret,
            domain = host,
            httpOnly = true,
        )

        val requestUrl = Url(client.endpoint)
        runBlocking {
            client.dataStoreCookieStorage.addCookie(requestUrl, cookie.toCookie())
        }
    }
}

suspend fun io.appwrite.services.Account.createOAuth2Token(
    activity: ComponentActivity,
    provider: io.appwrite.enums.OAuthProvider,
    success: String? = null,
    failure: String? = null,
    scopes: List<String>? = null,
    ) {
        val apiPath = "/account/tokens/oauth2/{provider}"
            .replace("{provider}", provider.value)

        val apiParams = mutableMapOf<String, Any?>(
            "success" to success,
            "failure" to failure,
            "scopes" to scopes,
            "project" to client.config["project"],
        )

        val apiQuery = mutableListOf<String>()
        apiParams.forEach {
            when (it.value) {
                null -> return@forEach
                is List<*> -> apiQuery.add("${it.key}[]=${it.value.toString()}")
                else -> apiQuery.add("${it.key}=${it.value.toString()}")
            }
        }

        val urlParser = UrlParser()
        val fullUrl = "${client.endpoint}${apiPath}?${apiQuery.joinToString("&")}"
        val apiUrl = urlParser.parse(fullUrl)
        val callbackUrlScheme = "appwrite-callback-${client.config["project"]}"

        WebAuthComponent.authenticate(activity, apiUrl.toString(), callbackUrlScheme) {
            if (it.isFailure) {
                throw it.exceptionOrNull()!!
            }

            val resultUrl = it.getOrNull()!!
            val key = urlParser.getQueryParameter(resultUrl, "key")
            val secret = urlParser.getQueryParameter(resultUrl, "secret")
            if (key == null || secret == null) {
                throw AppwriteException("Authentication cookie missing!")
            }

        val host = urlParser.getHost(client.endpoint)
        val cookie = SerializableCookie(
            name = key,
            value = secret,
            domain = host,
            httpOnly = true,
        )

        val requestUrl = Url(client.endpoint)
        runBlocking {
            client.dataStoreCookieStorage.addCookie(requestUrl, cookie.toCookie())
        }
    }
}

