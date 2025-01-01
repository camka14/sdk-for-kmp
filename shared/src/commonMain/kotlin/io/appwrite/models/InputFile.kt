package io.appwrite.models

import kotlinx.serialization.Serializable

@Serializable
class InputFile private constructor() {
    lateinit var path: String
    lateinit var filename: String
    lateinit var mimeType: String
    lateinit var sourceType: String
    lateinit var data: ByteArray

    companion object {
        fun fromPath(path: String) = InputFile().apply {
            this.path = path
            this.filename = path.split("/").last()
            this.mimeType = guessMimeType(filename)
            this.sourceType = "path"
        }

        fun fromBytes(
            bytes: ByteArray,
            filename: String = "",
            mimeType: String = ""
        ) = InputFile().apply {
            this.filename = filename
            this.mimeType = mimeType.ifEmpty { guessMimeType(filename) }
            this.data = bytes
            this.sourceType = "bytes"
        }
    }
}

expect fun guessMimeType(filename: String): String