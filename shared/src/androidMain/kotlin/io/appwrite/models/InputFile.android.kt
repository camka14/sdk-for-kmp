package io.appwrite.models

import android.os.Build
import androidx.annotation.RequiresApi
import java.io.File
import java.net.URLConnection
import java.nio.file.Files

@RequiresApi(Build.VERSION_CODES.O)
actual fun guessMimeType(input: String): String {
    val file = File(input)
    return Files.probeContentType(file.toPath())
        ?: URLConnection.guessContentTypeFromName(file.name) ?: ""
}
