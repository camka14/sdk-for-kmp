package io.appwrite

import kotlinx.coroutines.suspendCancellableCoroutine
import platform.Foundation.NSArray
import platform.Foundation.NSURL
import platform.Foundation.NSURLComponents
import platform.Foundation.NSURLQueryItem
import platform.Foundation.NSUserDefaults
import platform.Foundation.arrayWithObject
import platform.UIKit.UIApplication
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

actual class WebAuthComponent {

    actual companion object {
        private data class PendingAuth(
            val continuation: kotlinx.coroutines.CancellableContinuation<String>,
            val onComplete: ((Result<String>) -> Unit)?
        )

        private val pendingAuth = mutableMapOf<String, PendingAuth>()

        /**
         * Initiates authentication by opening the URL.
         * The suspend function will resume once onCallback is invoked.
         */
        internal suspend fun authenticate(
            url: String,
            callbackUrlScheme: String,
            onComplete: ((Result<String>) -> Unit)?
        ): String = suspendCancellableCoroutine { cont ->
            pendingAuth[callbackUrlScheme] = PendingAuth(cont, onComplete)

            val nsUrl = NSURL.URLWithString(url)
            if (nsUrl == null) {
                pendingAuth.remove(callbackUrlScheme)
                cont.resumeWithException(IllegalArgumentException("Invalid URL: $url"))
                return@suspendCancellableCoroutine
            }

            UIApplication.sharedApplication.openURL(nsUrl, options = emptyMap<Any?, Any>()) { success ->
                if (!success) {
                    pendingAuth.remove(callbackUrlScheme)?.let { pending ->
                        pending.onComplete?.invoke(Result.failure(IllegalStateException("Failed to open URL")))
                    }
                    cont.resumeWithException(IllegalStateException("Failed to open URL"))
                }
            }

            cont.invokeOnCancellation {
                pendingAuth.remove(callbackUrlScheme)
            }
        }

        /**
         * Called when the app receives the callback URL.
         * This method resumes the suspended coroutine associated with the given scheme.
         */
        actual fun onCallback(scheme: String, url: String) {
            pendingAuth.remove(scheme)?.let { pending ->
                pending.onComplete?.invoke(Result.success(url))
                pending.continuation.resume(url)
            }
        }

        /**
         * Process an incoming URL callback by parsing its query parameters to extract cookie details.
         * Saves the cookie and then calls onCallback.
         */
        actual fun handleIncomingCookie(url: String) {
            // Construct URL components from the callback URL.
            val components = NSURLComponents(url)
            val queryItems = components.queryItems ?: return

            // Map query items into key-value pairs.
            val cookieParts = queryItems.mapNotNull { item ->
                when (item) {
                    is NSURLQueryItem -> Pair(item.name, item.value ?: "")
                    else -> null
                }
            }.toMap()

            // Ensure required parameters are present.
            val rawDomain = cookieParts["domain"] ?: return
            val key = cookieParts["key"] ?: return
            val secret = cookieParts["secret"] ?: return

            // Remove the first character from the domain (as done in Swift).
            val domain = if (rawDomain.isNotEmpty()) rawDomain.substring(1) else rawDomain

            // Optional cookie attributes.
            val path = cookieParts["path"]
            val expires = cookieParts["expires"]
            val maxAge = cookieParts["maxAge"]
            val sameSite = cookieParts["sameSite"]
            val httpOnly = cookieParts.containsKey("httpOnly")
            val secure = cookieParts.containsKey("secure")

            // Build the cookie string.
            var cookie = "$key=$secret"
            path?.let { cookie += "; path=$it" }
            expires?.let { cookie += "; expires=$it" }
            maxAge?.let { cookie += "; max-age=$it" }
            sameSite?.let { cookie += "; sameSite=$it" }
            if (httpOnly) { cookie += "; httpOnly" }
            if (secure) { cookie += "; secure" }

            // Save the cookie in UserDefaults.
            NSUserDefaults.standardUserDefaults.setObject(NSArray.arrayWithObject(cookie), forKey = domain)

            // Retrieve the callback scheme from the URL components and resume the pending auth.
            val schemeFromComponents = components.scheme ?: return
            val callbackURLString = components.URL?.absoluteString ?: return
            onCallback(schemeFromComponents, callbackURLString)
        }
    }
}