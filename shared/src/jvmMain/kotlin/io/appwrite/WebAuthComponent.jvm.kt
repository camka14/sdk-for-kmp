package io.appwrite

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.awt.Desktop
import java.net.URI

actual class WebAuthComponent {
    actual companion object {
        private var suspended = false
        private val callbacks = mutableMapOf<String, (((Result<String>) -> Unit)?)>()

        suspend fun authenticate(
            url: String,
            callbackUrlScheme: String,
            onComplete: ((Result<String>) -> Unit)?
        ) {
            callbacks[callbackUrlScheme] = onComplete

            try {
                val desktop = if (Desktop.isDesktopSupported()) Desktop.getDesktop() else null

                if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
                    withContext(Dispatchers.IO) {
                        desktop.browse(URI(url))
                    }
                } else {
                    // Fallback for systems where Desktop is not supported
                    val runtime = Runtime.getRuntime()
                    when {
                        System.getProperty("os.name").lowercase().contains("mac") -> {
                            withContext(Dispatchers.IO) {
                                runtime.exec(arrayOf("open", url))
                            }
                        }

                        System.getProperty("os.name").lowercase().contains("win") -> {
                            withContext(Dispatchers.IO) {
                                runtime.exec(
                                    arrayOf(
                                        "rundll32",
                                        "url.dll,FileProtocolHandler",
                                        url
                                    )
                                )
                            }
                        }

                        else -> {
                            withContext(Dispatchers.IO) {
                                runtime.exec(arrayOf("xdg-open", url))
                            }
                        }
                    }
                }

                suspended = true
                while (suspended) {
                    delay(200)
                }
            } catch (e: Exception) {
                onComplete?.invoke(Result.failure(e))
                cleanUp()
            }
        }

        private fun cleanUp() {
            callbacks.forEach { (_, danglingResultCallback) ->
                danglingResultCallback?.invoke(
                    Result.failure(IllegalStateException("User cancelled login"))
                )
            }
            callbacks.clear()
            suspended = false
        }

        actual fun onCallback(scheme: String, url: String) {
            callbacks.remove(scheme)?.invoke(
                Result.success(url)
            )
            suspended = false
        }
        
        actual fun handleIncomingCookie(url: String) {}
    }
}
