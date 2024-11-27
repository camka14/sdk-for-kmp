package io.appwrite.models

actual fun guessMimeType(filename: String): String {
    return UTType.typeWithFilenameExtension(filename)?.preferredMIMEType ?: ""
}