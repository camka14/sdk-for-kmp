package io.appwrite

import io.appwrite.cookies.IosCookieStorage
import io.ktor.http.Cookie
import io.ktor.http.Url
import kotlinx.coroutines.CancellableContinuation
import kotlinx.coroutines.suspendCancellableCoroutine
import platform.AuthenticationServices.ASPresentationAnchor
import platform.AuthenticationServices.ASWebAuthenticationPresentationContextProvidingProtocol
import platform.AuthenticationServices.ASWebAuthenticationSession
import platform.Foundation.NSArray
import platform.Foundation.NSError
import platform.Foundation.NSURL
import platform.Foundation.NSURLComponents
import platform.Foundation.NSURLQueryItem
import platform.Foundation.NSUserDefaults
import platform.Foundation.arrayWithObject
import platform.UIKit.UIApplication
import platform.UIKit.UIWindow
import platform.darwin.NSObject
import kotlin.collections.set
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException

actual class WebAuthComponent {
    actual companion object {
        private data class PendingAuth(
            val continuation: CancellableContinuation<Result<String>>,
            val session: ASWebAuthenticationSession?,
            val onComplete: ((Result<String>) -> Unit)?
        )

        private val pendingAuth = mutableMapOf<String, PendingAuth>()

        private var cookieStorage: IosCookieStorage? = null

        fun setCookieStorage(storage: IosCookieStorage) {
            if (cookieStorage != null) {
                cookieStorage = storage
            }
        }

        internal suspend fun authenticate(
            url: String,
            callbackUrlScheme: String,
            onComplete: ((Result<String>) -> Unit)?
        ): Result<String> = suspendCancellableCoroutine { cont ->
            val nsUrl = NSURL.URLWithString(url)
            if (nsUrl == null) {
                cont.resumeWithException(IllegalArgumentException("Invalid URL: $url"))
                return@suspendCancellableCoroutine
            }

            val authSession = ASWebAuthenticationSession(
                uRL = nsUrl,
                callbackURLScheme = callbackUrlScheme,
                completionHandler = { callbackURL: NSURL?, error: NSError? ->
                    val pending = pendingAuth.remove(callbackUrlScheme)

                    when {
                        error != null -> {
                            val exception =
                                IllegalStateException("Authentication failed: ${error.localizedDescription}")
                            pending?.onComplete?.invoke(Result.failure(exception))
                            if (pending?.continuation?.isActive == true) {
                                pending.continuation.resumeWithException(exception)
                            }
                        }

                        callbackURL != null -> {
                            val callbackUrlString = callbackURL.absoluteString ?: ""
                            handleIncomingCookie(callbackUrlString)
                            pending?.onComplete?.invoke(Result.success(callbackUrlString))
                            if (pending?.continuation?.isActive == true) {
                                pending.continuation.resume(Result.success(callbackUrlString))
                            }
                        }

                        else -> {
                            val exception = IllegalStateException("Authentication cancelled")
                            pending?.onComplete?.invoke(Result.failure(exception))
                            if (pending?.continuation?.isActive == true) {
                                pending.continuation.resumeWithException(exception)
                            }
                        }
                    }
                }
            )

            authSession.prefersEphemeralWebBrowserSession = true
            authSession.presentationContextProvider = PresentationContextProviderImpl()

            pendingAuth[callbackUrlScheme] = PendingAuth(cont, authSession, onComplete)

            val started = authSession.start()
            if (!started) {
                pendingAuth.remove(callbackUrlScheme)
                cont.resumeWithException(IllegalStateException("Failed to start authentication session"))
                return@suspendCancellableCoroutine
            }

            cont.invokeOnCancellation {
                pendingAuth.remove(callbackUrlScheme)?.session?.cancel()
            }
        }

        actual fun onCallback(scheme: String, url: String) {
            pendingAuth.remove(scheme)?.let { pending ->
                pending.session?.cancel()
                pending.onComplete?.invoke(Result.success(url))
                if (pending.continuation.isActive) {
                    pending.continuation.resume(Result.success(url))
                }
            }
        }

        actual fun handleIncomingCookie(url: String) {
            val nsUrl = NSURL.URLWithString(url) ?: return
            val components =
                NSURLComponents.componentsWithURL(nsUrl, resolvingAgainstBaseURL = false) ?: return
            val queryItems = components.queryItems ?: return

            val cookieParts = mutableMapOf<String, String>()
            val count = queryItems.size
            for (i in 0 until count) {
                val item = queryItems[i] as NSURLQueryItem
                cookieParts[item.name] = item.value ?: ""
            }

            val rawDomain = cookieParts["domain"] ?: return
            val key = cookieParts["key"] ?: return
            val secret = cookieParts["secret"] ?: return

            val domain = if (rawDomain.isNotEmpty()) rawDomain.substring(1) else rawDomain

            val cookie = Cookie(
                name = key,
                value = secret,
                domain = domain,
                path = cookieParts["path"] ?: "/",
                httpOnly = cookieParts.containsKey("httpOnly"),
                secure = cookieParts.containsKey("secure"),
                expires = cookieParts["expires"]?.let {
                    null // You may need to parse the date properly
                },
                maxAge = cookieParts["maxAge"]?.toIntOrNull()
            )

            if (cookieStorage != null) {
                kotlinx.coroutines.runBlocking {
                    cookieStorage!!.addCookie(
                        requestUrl = Url("https://$domain"),
                        cookie = cookie
                    )
                }
            }

            var cookieString = "$key=$secret"
            cookieParts["path"]?.let { cookieString += "; path=$it" }
            cookieParts["expires"]?.let { cookieString += "; expires=$it" }
            cookieParts["maxAge"]?.let { cookieString += "; max-age=$it" }
            cookieParts["sameSite"]?.let { cookieString += "; sameSite=$it" }
            if (cookieParts.containsKey("httpOnly")) {
                cookieString += "; httpOnly"
            }
            if (cookieParts.containsKey("secure")) {
                cookieString += "; secure"
            }

            NSUserDefaults.standardUserDefaults.setObject(
                NSArray.arrayWithObject(cookieString),
                forKey = domain
            )

            val schemeFromComponents = components.scheme ?: return
            val callbackURLString = components.URL?.absoluteString ?: return
            onCallback(schemeFromComponents, callbackURLString)
        }

        fun cleanup() {
            pendingAuth.values.forEach { pending ->
                pending.session?.cancel()
                pending.onComplete?.invoke(Result.failure(IllegalStateException("Authentication cancelled")))
                if (pending.continuation.isActive) {
                    pending.continuation.resumeWithException(IllegalStateException("Authentication cancelled"))
                }
            }
            pendingAuth.clear()
        }
    }
}

/**
 * Presentation context provider for ASWebAuthenticationSession
 */
private class PresentationContextProviderImpl : NSObject(),
    ASWebAuthenticationPresentationContextProvidingProtocol {
    override fun presentationAnchorForWebAuthenticationSession(session: ASWebAuthenticationSession): ASPresentationAnchor {
        val windows = UIApplication.sharedApplication.windows
        val count = windows.size
        for (i in 0 until count) {
            val window = windows[i] as? UIWindow
            if (window?.isKeyWindow() == true) {
                return window
            }
        }
        return UIWindow()
    }
}