package io.appwrite

/**
 * Used to authenticate with external OAuth2 providers. Launches browser windows and handles
 * suspension until the user completes the process or otherwise returns to the app.
 */
expect class WebAuthComponent() {
    @Throws(Throwable::class)
    suspend fun authenticate(
        url: String,
        callbackUrlScheme: String,
        onComplete: ((Result<String>) -> Unit)?
    )

    fun onCallback(scheme: String, url: String)
}