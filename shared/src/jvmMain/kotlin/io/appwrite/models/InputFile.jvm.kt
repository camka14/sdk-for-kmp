package io.appwrite.models

import java.net.URLConnection

actual fun guessMimeType(filename: String): String {
    return URLConnection.guessContentTypeFromName(filename) ?: ""
}
