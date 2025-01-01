package io.appwrite.fileOperations

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.refTo
import kotlinx.cinterop.usePinned
import platform.Foundation.NSFileHandle
import platform.Foundation.closeFile
import platform.Foundation.fileHandleForReadingAtPath
import platform.Foundation.offsetInFile
import platform.Foundation.readDataOfLength
import platform.Foundation.seekToEndOfFile
import platform.Foundation.seekToFileOffset
import platform.posix.memcpy

actual fun readFileSize(path: String): Long {
    val fileHandle = NSFileHandle.fileHandleForReadingAtPath(path)
    return try {
        fileHandle?.seekToEndOfFile()
        fileHandle?.offsetInFile()?.toLong() ?: 0L
    } finally {
        fileHandle?.closeFile()
    }
}

@OptIn(ExperimentalForeignApi::class)
actual fun readFileChunk(path: String, offset: Long, buffer: ByteArray, length: Int) {
    val fileHandle = NSFileHandle.fileHandleForReadingAtPath(path)
    try {
        fileHandle?.seekToFileOffset(offset.toULong())
        val data = fileHandle?.readDataOfLength(length.toULong())
        data?.bytes?.usePinned { pinned ->
            memcpy(buffer.refTo(0), pinned.get(), length.toULong())
        }
    } finally {
        fileHandle?.closeFile()
    }
}

@OptIn(ExperimentalForeignApi::class)
actual fun readFileBytes(path: String, offset: Long, length: Long): ByteArray {
    val fileHandle = NSFileHandle.fileHandleForReadingAtPath(path)
    return try {
        fileHandle?.seekToFileOffset(offset.toULong())
        val data = fileHandle?.readDataOfLength(length.toULong())
        ByteArray(length.toInt()).also { buffer ->
            data?.bytes?.usePinned { pinned ->
                memcpy(buffer.refTo(0), pinned.get(), length.toULong())
            }
        }
    } finally {
        fileHandle?.closeFile()
    }
}

