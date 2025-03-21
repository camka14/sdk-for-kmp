package io.appwrite.fileOperations

import okio.FileSystem
import okio.Path.Companion.toPath
import okio.SYSTEM
import okio.buffer
import okio.use

fun readFileSize(filePath: String): Long =
    FileSystem.SYSTEM.metadata(filePath.toPath()).size!!

// Helper function to read the entire file as bytes using Okio
fun readFileBytes(filePath: String): ByteArray =
    FileSystem.SYSTEM.read(filePath.toPath()) { readByteArray() }

// Helper function to read a chunk given an offset and length using Okio
fun readFileChunk(filePath: String, offset: Long, length: Int): ByteArray =
    FileSystem.SYSTEM.source(filePath.toPath()).use { source ->
        val bufferedSource = source.buffer()
        bufferedSource.skip(offset)
        bufferedSource.readByteArray(length.toLong())
    }
