package io.appwrite

expect class WebAuthComponent {
    companion object {
        fun onCallback(scheme: String, url: String)
        fun handleIncomingCookie(url: String)
    }
}