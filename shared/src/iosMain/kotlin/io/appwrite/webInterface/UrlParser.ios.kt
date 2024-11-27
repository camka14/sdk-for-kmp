package io.appwrite.webInterface

actual class UrlParser {
    actual fun parse(url: String): ParsedUrl = IosParsedUrl(NSURL(string: url))
    actual fun getQueryParameter(url: String, name: String): String? {
        // iOS implementation using URLComponents
    }
    actual fun getHost(url: String): String {
        // iOS implementation using NSURL
    }
}