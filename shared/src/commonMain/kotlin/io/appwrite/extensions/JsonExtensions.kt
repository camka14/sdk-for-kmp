package io.appwrite.extensions

import io.appwrite.serializers.DynamicLookupSerializer
import kotlinx.serialization.Contextual
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.serializer
import kotlin.reflect.KClass

var json = Json {
    encodeDefaults = true
    isLenient = true
    allowSpecialFloatingPointValues = true
    allowStructuredMapKeys = true
    prettyPrint = false
    useArrayPolymorphism = false
    ignoreUnknownKeys = true
    coerceInputValues = true
    serializersModule = SerializersModule {
        contextual(Any::class, DynamicLookupSerializer)
    }
    explicitNulls = false
}

@Suppress("UNCHECKED_CAST")
@OptIn(InternalSerializationApi::class)
fun <T : Any> getSerializer(kClass: KClass<T>): KSerializer<T> = when (kClass) {
    Map::class -> MapSerializer(String.serializer(), JsonElement.serializer()) as KSerializer<T>
    JsonObject::class -> JsonObject.serializer() as KSerializer<T>
    else -> kClass.serializer()
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
