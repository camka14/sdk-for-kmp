package io.appwrite.webInterface

import android.net.Uri

actual class UrlParser {
    actual fun parse(url: String): ParsedUrl = AndroidParsedUrl(Uri.parse(url))
    actual fun getQueryParameter(url: String, name: String): String? =
        Uri.parse(url).getQueryParameter(name)
    actual fun getHost(url: String): String =
        Uri.parse(url).host ?: throw IllegalArgumentException("Invalid URL")
}
