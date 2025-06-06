package io.appwrite.models

import kotlinx.io.Buffer
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem
import kotlinx.serialization.Contextual

class InputFile private constructor() {
    lateinit var path: String
    lateinit var filename: String
    lateinit var sourceType: String
    lateinit var mimeType: String

    @Contextual
    lateinit var data: Buffer

    companion object {
        fun fromPath(path: String) = InputFile().apply {
            this.path = SystemFileSystem.resolve(Path(path)).toString()
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
            this.data = Buffer().apply {
                write(bytes)
            }
            this.sourceType = "bytes"
        }
    }
}

expect fun guessMimeType(input: String): String