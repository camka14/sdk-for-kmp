package io.appwrite.FileOperations

actual fun readFileSize(path: String): Long {
    return NSFileManager.defaultManager.attributesOfItemAtPath(path, null)?.fileSize()?.toLong() ?: 0L
}

actual fun readFileChunk(path: String, offset: Long, buffer: ByteArray, length: Int) {
    NSFileHandle.fileHandleForReadingAtPath(path)?.use { handle ->
        handle.seekToFileOffset(offset.toULong())
        handle.readDataOfLength(length.toUInt()).toByteArray().copyInto(buffer)
    }
}

actual fun readFileBytes(path: String, offset: Long, length: Long): ByteArray {
    return NSFileHandle.fileHandleForReadingAtPath(path)?.use { handle ->
        handle.seekToFileOffset(offset.toULong())
        handle.readDataOfLength(length.toUInt()).toByteArray()
    } ?: ByteArray(0)
}