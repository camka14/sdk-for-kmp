package io.appwrite.exceptions

class AppwriteException(
    override val message: String? = null,
    val code: Int? = null,
    val type: String? = null,
    val response: String? = null
) : Exception(message)