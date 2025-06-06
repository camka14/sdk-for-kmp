package io.appwrite.models

import kotlinx.cinterop.ExperimentalForeignApi
import platform.CoreFoundation.CFStringRef
import platform.CoreServices.UTTypeCopyPreferredTagWithClass
import platform.CoreServices.UTTypeCreatePreferredIdentifierForTag
import platform.CoreServices.kUTTagClassFilenameExtension
import platform.CoreServices.kUTTagClassMIMEType
import platform.Foundation.CFBridgingRelease
import platform.Foundation.NSURL
import platform.Foundation.NSString
import platform.CoreFoundation.CFStringCreateWithCString
import platform.CoreFoundation.kCFAllocatorDefault
import platform.CoreFoundation.kCFStringEncodingUTF8

@OptIn(ExperimentalForeignApi::class)
actual fun guessMimeType(input: String): String {
    val url = NSURL.fileURLWithPath(input)
    val ext = url.pathExtension
    if (ext == null || ext.isEmpty()) return "application/octet-stream"

    // Create a CFStringRef from the Kotlin String
    val cfExt: CFStringRef? = CFStringCreateWithCString(
        kCFAllocatorDefault,
        ext,
        kCFStringEncodingUTF8
    )

    // Create the UTI from the file extension.
    val utiRef = UTTypeCreatePreferredIdentifierForTag(
        kUTTagClassFilenameExtension,
        cfExt,
        null
    )?.let { CFBridgingRelease(it) } as? CFStringRef

    // Get the MIME type from the UTI.
    val mimeCF = UTTypeCopyPreferredTagWithClass(
        utiRef,
        kUTTagClassMIMEType
    )?.let { CFBridgingRelease(it) } as? CFStringRef

    // Convert the CFString (bridged to an NSString) to a Kotlin String.
    return (mimeCF as? NSString)?.toString() ?: "application/octet-stream"
}