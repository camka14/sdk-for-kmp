package io.appwrite

import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.browser.customtabs.CustomTabsIntent
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import kotlinx.coroutines.delay
import kotlin.collections.component1
import kotlin.collections.component2
import kotlin.collections.forEach
import kotlin.collections.mutableMapOf
import kotlin.collections.set

/**
 * Used to authenticate with external OAuth2 providers. Launches browser windows and handles
 * suspension until the user completes the process or otherwise returns to the app.
 */
actual class WebAuthComponent {
    actual companion object : DefaultLifecycleObserver {
        private var suspended = false
        private val callbacks = mutableMapOf<String, ((Result<String>) -> Unit)?>()

        override fun onResume(owner: LifecycleOwner) {
            // When the activity resumes, end the suspension so that the caller can continue.
            suspended = false
        }

        /**
         * Authenticate session using OAuth2.
         *
         * Launches a Chrome Custom Tab from the provided activity to open the given URL.
         * Once the user returns to the app (resuming the activity), the provided callback is invoked.
         *
         * @param activity          The activity used to launch the browser and observe lifecycle events.
         * @param url               The URL to open.
         * @param callbackUrlScheme The URL scheme to match for the authentication callback.
         * @param onComplete        The callback to run with the authentication result.
         */
        internal suspend fun authenticate(
            activity: ComponentActivity,
            url: String,
            callbackUrlScheme: String,
            onComplete: ((Result<String>) -> Unit)?
        ) {
            val intent = CustomTabsIntent.Builder().build()
            val keepAliveIntent = Intent(activity, KeepAliveService::class.java)

            callbacks[callbackUrlScheme] = onComplete

            intent.intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.intent.putExtra("android.support.customtabs.extra.KEEP_ALIVE", keepAliveIntent)
            intent.launchUrl(activity, Uri.parse(url))

            // Add this as a lifecycle observer so that we know when the user returns to the app.
            activity.runOnUiThread {
                activity.lifecycle.addObserver(this)
            }

            // Poll until the authentication has been resumed.
            suspended = true
            while (suspended) {
                delay(200)
            }
            cleanUp()
        }

        /**
         * Invoke the callback for the provided scheme.
         *
         * This method ends the suspension, allowing any waiting coroutines to resume.
         *
         * @param scheme The callback scheme key.
         * @param url    The URL provided in the callback.
         */
        actual fun onCallback(scheme: String, url: String) {
            callbacks.remove(scheme)?.invoke(Result.success(url))
            suspended = false
        }

        private fun cleanUp() {
            callbacks.forEach { (_, callback) ->
                callback?.invoke(Result.failure(IllegalStateException("User cancelled login")))
            }
            callbacks.clear()
        }

        actual fun handleIncomingCookie(url: String) {}
    }
}
