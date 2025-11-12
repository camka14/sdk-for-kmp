package io.appwrite.extensions

import androidx.activity.ComponentActivity
import io.appwrite.WebAuthComponent
import io.appwrite.cookies.SerializableCookie
import io.appwrite.exceptions.AppwriteException
import io.appwrite.webInterface.UrlParser
import io.ktor.http.Url
import io.ktor.http.encodeURLParameter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

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

    val apiQuery = buildList {
        apiParams.forEach { (key, value) ->
            when (value) {
                null -> Unit
                is Iterable<*> -> value.forEach { item ->
                    if (item != null) {
                        add("${key}[]=${item.toString().encodeURLParameter()}")
                    }
                }

                else -> add("$key=${value.toString().encodeURLParameter()}")
            }
        }
    }
    val urlParser = UrlParser()
    val queryString = apiQuery.joinToString("&")
    val fullUrl = buildString {
        append(client.endpoint)
        append(apiPath)
        if (queryString.isNotEmpty()) {
            append('?')
            append(queryString)
        }
    }
    val apiUrl = urlParser.parse(fullUrl)
    val callbackUrlScheme = "appwrite-callback-${client.config["project"]}"
    val webAuthScope = CoroutineScope(client.coroutineContext)

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
        webAuthScope.launch {
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

    val apiQuery = buildList {
        apiParams.forEach { (key, value) ->
            when (value) {
                null -> Unit
                is Iterable<*> -> value.forEach { item ->
                    if (item != null) {
                        add("${key}[]=${item.toString().encodeURLParameter()}")
                    }
                }

                else -> add("$key=${value.toString().encodeURLParameter()}")
            }
        }
    }
    val urlParser = UrlParser()
    val queryString = apiQuery.joinToString("&")
    val fullUrl = buildString {
        append(client.endpoint)
        append(apiPath)
        if (queryString.isNotEmpty()) {
            append('?')
            append(queryString)
        }
    }
    val apiUrl = urlParser.parse(fullUrl)
    val callbackUrlScheme = "appwrite-callback-${client.config["project"]}"
    val webAuthScope = CoroutineScope(client.coroutineContext)

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
        webAuthScope.launch {
            client.dataStoreCookieStorage.addCookie(requestUrl, cookie.toCookie())
        }
    }
}

