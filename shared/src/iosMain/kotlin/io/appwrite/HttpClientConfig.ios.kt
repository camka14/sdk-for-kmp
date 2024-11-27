package io.appwrite

import io.appwrite.cookies.DarwinCookieStorage
import io.ktor.client.HttpClient
import io.ktor.client.engine.darwin.Darwin
import io.ktor.client.plugins.cookies.HttpCookies

fun createHttpClient() = HttpClient(Darwin) {
    install(HttpCookies) {
        storage = DarwinCookieStorage()
    }

    engine {
        configureRequest {
            setAllowsCellularAccess(true)
            setTLSMinimumSupportedProtocolVersion(NSURLSessionTLSProtocolVersion.TLSv1_2)
            setTLSMaximumSupportedProtocolVersion(NSURLSessionTLSProtocolVersion.TLSv1_3)
        }

        // Handle self-signed certificates
        handleChallenge { session, challenge, completionHandler ->
            completionHandler(
                NSURLSessionAuthChallengeDisposition.UseCredential,
                NSURLCredential.createWithTrust(challenge.protectionSpace.serverTrust!!)
            )
            true
        }
    }
}