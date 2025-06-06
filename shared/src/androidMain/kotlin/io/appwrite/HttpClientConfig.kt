package io.appwrite

import io.appwrite.cookies.stores.DataStoreCookieStorage
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.pingInterval
import io.ktor.serialization.kotlinx.json.json
import java.security.KeyStore
import java.security.SecureRandom
import java.security.cert.X509Certificate
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager
import kotlin.time.Duration.Companion.seconds

fun createHttpClient(selfSigned: Boolean, dataStoreCookieStorage: DataStoreCookieStorage) = HttpClient(OkHttp) {
    install(HttpCookies) {
        storage = dataStoreCookieStorage
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
                val trustManager = object : X509TrustManager {
                        override fun checkClientTrusted(
                            chain: Array<out X509Certificate>?,
                            authType: String?
                        ) {
                            // Empty implementation to trust all clients
                        }

                        override fun checkServerTrusted(
                            chain: Array<out X509Certificate>?,
                            authType: String?
                        ) {
                            // Empty implementation to trust all servers
                        }

                        override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
                    }
                val sslContext = SSLContext.getInstance("TLS").apply {
                    init(null, arrayOf(trustManager), SecureRandom())
                }
                sslSocketFactory(sslContext.socketFactory, trustManager)
                hostnameVerifier { _, _ -> true }
            }
        }
    } else {
        engine {
            config {
                val trustManagerFactory =
                    TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm())
                trustManagerFactory.init(null as KeyStore?)
                val sslContext = SSLContext.getInstance("TLS").apply {
                    init(null, trustManagerFactory.trustManagers, SecureRandom())
                }
                sslSocketFactory(
                    sslContext.socketFactory,
                    trustManagerFactory.trustManagers[0] as X509TrustManager
                )
            }
        }
    }
}
