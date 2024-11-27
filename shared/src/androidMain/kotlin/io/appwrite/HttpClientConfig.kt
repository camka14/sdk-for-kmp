package io.appwrite

import android.content.Context
import io.appwrite.cookies.AndroidCookieStorage
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.cookies.HttpCookies
import java.security.SecureRandom
import javax.net.ssl.SSLContext

fun createHttpClient(context: Context) = HttpClient(OkHttp) {
    install(HttpCookies) {
        storage = AndroidCookieStorage(context)
    }
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
}