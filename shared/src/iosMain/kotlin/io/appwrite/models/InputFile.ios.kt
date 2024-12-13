package io.appwrite.models

import platform.UniformTypeIdentifiers.UTType

actual fun guessMimeType(filename: String): String {
    return UTType.typeWithFilenameExtension(filename)?.preferredMIMEType ?: ""
}