package io.appwrite

import io.appwrite.cookies.IosCookieStorage
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.cookies.HttpCookies
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.pingInterval
import io.ktor.serialization.kotlinx.json.json
import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.convert
import platform.Foundation.NSURLCredential
import platform.Foundation.NSURLSessionAuthChallengePerformDefaultHandling
import platform.Foundation.NSURLSessionAuthChallengeUseCredential
import platform.Foundation.credentialForTrust
import platform.Foundation.serverTrust
import kotlin.time.Duration.Companion.seconds

@OptIn(ExperimentalForeignApi::class)
fun createHttpClient(selfSigned: Boolean, iosCookieStorage: IosCookieStorage) = HttpClient(Darwin) {
    install(HttpCookies) {
        storage = iosCookieStorage
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
            handleChallenge { _, _, challenge, completionHandler ->
                val disposition = NSURLSessionAuthChallengeUseCredential
                val credential =
                    NSURLCredential.credentialForTrust(challenge.protectionSpace.serverTrust!!)
                completionHandler(disposition.convert(), credential)
            }
        }
    } else {
        engine {
            // Use default SSL configuration for secure connections
            handleChallenge { session, task, challenge, completionHandler ->
                val disposition = NSURLSessionAuthChallengePerformDefaultHandling
                completionHandler(disposition.convert(), null)
            }
        }
    }
}
