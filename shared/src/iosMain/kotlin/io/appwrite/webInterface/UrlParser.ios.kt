package io.appwrite.webInterface

import platform.Foundation.NSURL
import platform.Foundation.NSURLComponents
import platform.Foundation.NSURLQueryItem

actual class UrlParser {
    actual fun parse(url: String): ParsedUrl {
        val nsUrl = NSURL(string = url)
        return IosParsedUrl(nsUrl)
    }

    actual fun getQueryParameter(url: String, name: String): String? {
        val components = NSURLComponents(string = url)
        return components.queryItems?.firstOrNull { queryItem ->
            (queryItem as NSURLQueryItem).name == name
        }?.let { (it as NSURLQueryItem).value }
    }

    actual fun getHost(url: String): String {
        val components = NSURLComponents(string = url)
        return components.host ?: throw IllegalArgumentException("Invalid URL")
    }
}



