package io.appwrite

import android.content.Context
import io.appwrite.cookies.AndroidCookieStorage
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
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager
import kotlin.time.Duration.Companion.seconds

fun createHttpClient(context: Context, selfSigned: Boolean) = HttpClient(OkHttp) {
    install(HttpCookies) {
        storage = AndroidCookieStorage(context)
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
                val trustManager = AllCertsTrustManager()
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