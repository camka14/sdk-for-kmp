package io.appwrite.models

import java.io.File
import java.net.URLConnection
import java.nio.file.Files
import java.nio.file.Paths

actual fun guessMimeType(input: String): String {
    val file = File(input)
    return Files.probeContentType(file.toPath()) ?: 
           URLConnection.guessContentTypeFromName(file.name) ?: 
           "application/octet-stream"
}
