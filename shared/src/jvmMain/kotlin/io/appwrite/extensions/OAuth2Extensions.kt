package io.appwrite.extensions

import io.appwrite.WebAuthComponent
import io.appwrite.exceptions.AppwriteException
import io.appwrite.services.Account
import io.appwrite.webInterface.UrlParser
import io.ktor.client.plugins.cookies.cookies
import io.ktor.client.request.cookie
import io.ktor.client.request.get
import io.ktor.http.Cookie

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

        WebAuthComponent.authenticate(apiUrl.toString(), callbackUrlScheme) {
            if (it.isFailure) {
                throw it.exceptionOrNull()!!
            }

            val resultUrl = it.getOrNull()!!
            val key = urlParser.getQueryParameter(resultUrl, "key")
            val secret = urlParser.getQueryParameter(resultUrl, "secret")
            if (key == null || secret == null) {
                throw AppwriteException("Authentication cookie missing!")
            }

            kotlinx.coroutines.runBlocking {
                val existingCookies = client.httpClient.cookies(client.endpoint)
                if (existingCookies.any { cookie: Cookie -> cookie.name == key }) {
                    return@runBlocking
                }

                client.httpClient.get(client.endpoint) {
                    cookie(
                        name = key,
                        value = secret,
                        domain = urlParser.getHost(client.endpoint),
                        path = "/",
                        httpOnly = true
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

        WebAuthComponent.authenticate(apiUrl.toString(), callbackUrlScheme) {
            if (it.isFailure) {
                throw it.exceptionOrNull()!!
            }

            val resultUrl = it.getOrNull()!!
            val key = urlParser.getQueryParameter(resultUrl, "key")
            val secret = urlParser.getQueryParameter(resultUrl, "secret")
            if (key == null || secret == null) {
                throw AppwriteException("Authentication cookie missing!")
            }

            kotlinx.coroutines.runBlocking {
                val existingCookies = client.httpClient.cookies(client.endpoint)
                if (existingCookies.any { cookie: Cookie -> cookie.name == key }) {
                    return@runBlocking
                }

                client.httpClient.get(client.endpoint) {
                    cookie(
                        name = key,
                        value = secret,
                        domain = urlParser.getHost(client.endpoint),
                        path = "/",
                        httpOnly = true
                    )
                }
            }
        }
}

