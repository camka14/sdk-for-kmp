package io.appwrite.models

import android.os.Build
import java.io.File
import java.net.URLConnection
import java.nio.file.Files

actual fun guessMimeType(input: String): String {
    val file = File(input)
    return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
        Files.probeContentType(file.toPath()) ?: URLConnection.guessContentTypeFromName(file.name)
        ?: ""
    } else {
        URLConnection.guessContentTypeFromName(file.name) ?: ""
    }
}
