package io.appwrite.webInterface

import java.net.URI

class JvmParsedUrl(private val uri: URI) : ParsedUrl {
    override fun toString(): String = uri.toString()
}
