package io.appwrite.webInterface

class IosParsedUrl(private val url: NSURL) : ParsedUrl {
    override fun toString(): String = url.absoluteString
}