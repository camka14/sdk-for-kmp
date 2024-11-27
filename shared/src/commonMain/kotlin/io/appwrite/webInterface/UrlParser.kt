package io.appwrite.webInterface

expect class UrlParser() {
    fun parse(url: String): ParsedUrl
    fun getQueryParameter(url: String, name: String): String?
    fun getHost(url: String): String
}
