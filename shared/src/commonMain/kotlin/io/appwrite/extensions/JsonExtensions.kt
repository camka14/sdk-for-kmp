package io.appwrite.extensions

import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

val json = Json {
    ignoreUnknownKeys = true
    isLenient = true
    useAlternativeNames = false
}

fun Any.toJson(): String =
    json.encodeToString(this)

@OptIn(InternalSerializationApi::class)
fun <T : Any> String.fromJson(clazz: KClass<T>): T =
    json.decodeFromString(clazz.serializer(), this)

inline fun <reified T> String.fromJson(): T =
    json.decodeFromString<T>(this)

fun <T : Any> Any.jsonCast(to: KClass<T>): T =
    toJson().fromJson(to)

inline fun <reified T> Any.jsonCast(): T =
    toJson().fromJson<T>()

fun <T : Any> Any.tryJsonCast(to: KClass<T>): T? = try {
    toJson().fromJson(to)
} catch (ex: Exception) {
    ex.printStackTrace()
    null
}

inline fun <reified T> Any.tryJsonCast(): T? = try {
    toJson().fromJson<T>()
} catch (ex: Exception) {
    ex.printStackTrace()
    null
}
