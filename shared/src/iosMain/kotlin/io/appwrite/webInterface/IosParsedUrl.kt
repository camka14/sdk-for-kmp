package io.appwrite.webInterface

import platform.Foundation.NSURL

class IosParsedUrl(private val url: NSURL) : ParsedUrl {
    override fun toString(): String = url.absoluteString ?: ""
}
