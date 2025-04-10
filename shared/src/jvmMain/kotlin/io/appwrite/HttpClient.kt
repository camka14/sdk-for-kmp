package io.appwrite

import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.AcceptAllCookiesStorage
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.pingInterval
import io.ktor.serialization.kotlinx.json.json
import java.security.KeyStore
import java.security.SecureRandom
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import kotlin.time.Duration.Companion.seconds

fun createHttpClient(selfSigned: Boolean) = HttpClient(Java) {
    install(HttpCookies) {
        storage = AcceptAllCookiesStorage()
    }

    install(WebSockets) {
        pingInterval = 30.seconds
    }

    install(HttpTimeout) {
        requestTimeoutMillis = 60000
        connectTimeoutMillis = 30000
        socketTimeoutMillis = 30000
    }

    install(ContentNegotiation) {
        json(io.appwrite.extensions.json)
    }

    if (selfSigned) {
        engine {
            config {
                sslContext(SSLContext.getInstance("TLS").apply {
                    init(null, arrayOf(AllCertsTrustManager()), SecureRandom())
                })
            }
        }
    } else {
        engine {
            config {
                val trustManagerFactory = TrustManagerFactory.getInstance(
                    TrustManagerFactory.getDefaultAlgorithm()
                ).apply {
                    init(null as KeyStore?)
                }

                sslContext(SSLContext.getInstance("TLS").apply {
                    init(
                        null,
                        trustManagerFactory.trustManagers,
                        SecureRandom()
                    )
                })
            }
        }
    }
}
