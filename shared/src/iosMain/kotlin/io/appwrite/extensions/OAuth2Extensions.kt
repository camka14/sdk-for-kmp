package io.appwrite.extensions

import io.appwrite.WebAuthComponent
import io.appwrite.exceptions.AppwriteException
import io.appwrite.webInterface.UrlParser
import io.ktor.http.Cookie
import io.ktor.http.Url
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

suspend fun io.appwrite.services.Account.createOAuth2Session(
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
    val webAuthScope = CoroutineScope(client.coroutineContext)

    WebAuthComponent.setCookieStorage(client.iosCookieStorage, webAuthScope)
    WebAuthComponent.authenticate(apiUrl.toString(), callbackUrlScheme) { result ->
        if (result.isFailure) {
            throw AppwriteException("OAuth authentication failed: ${result.exceptionOrNull()?.message}")
        }

        result.getOrNull()?.let { callbackUrl ->
            webAuthScope.launch {
                val key = urlParser.getQueryParameter(callbackUrl, "key")
                val secret = urlParser.getQueryParameter(callbackUrl, "secret")

                if (key == null || secret == null) {
                    throw AppwriteException("Authentication cookie missing!")
                }
                val cookie = Cookie(
                    name = key,
                    value = secret,
                    domain = urlParser.getHost(client.endpoint),
                    path = "/",
                    httpOnly = true,
                    secure = client.endpoint.startsWith("https")
                )

                client.iosCookieStorage.addCookie(
                    requestUrl = Url(fullUrl),
                    cookie = cookie
                )
            }
        }
    }
}


suspend fun io.appwrite.services.Account.createOAuth2Token(
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
    val webAuthScope = CoroutineScope(client.coroutineContext)

    WebAuthComponent.setCookieStorage(client.iosCookieStorage, webAuthScope)
    WebAuthComponent.authenticate(apiUrl.toString(), callbackUrlScheme) { result ->
        if (result.isFailure) {
            throw AppwriteException("OAuth authentication failed: ${result.exceptionOrNull()?.message}")
        }

        result.getOrNull()?.let { callbackUrl ->
            webAuthScope.launch {
                val key = urlParser.getQueryParameter(callbackUrl, "key")
                val secret = urlParser.getQueryParameter(callbackUrl, "secret")

                if (key == null || secret == null) {
                    throw AppwriteException("Authentication cookie missing!")
                }
                val cookie = Cookie(
                    name = key,
                    value = secret,
                    domain = urlParser.getHost(client.endpoint),
                    path = "/",
                    httpOnly = true,
                    secure = client.endpoint.startsWith("https")
                )

                client.iosCookieStorage.addCookie(
                    requestUrl = Url(fullUrl),
                    cookie = cookie
                )
            }
        }
    }
}


