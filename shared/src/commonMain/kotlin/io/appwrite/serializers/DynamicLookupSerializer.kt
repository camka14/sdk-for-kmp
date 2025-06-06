package io.appwrite.serializers

import io.appwrite.Query
import kotlinx.serialization.ContextualSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonNull
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.boolean
import kotlinx.serialization.json.booleanOrNull
import kotlinx.serialization.json.double
import kotlinx.serialization.json.doubleOrNull
import kotlinx.serialization.json.int
import kotlinx.serialization.json.intOrNull
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.long
import kotlinx.serialization.json.longOrNull

@Suppress("UNCHECKED_CAST")
@OptIn(ExperimentalSerializationApi::class)
object DynamicLookupSerializer : KSerializer<Any> {
    override val descriptor: SerialDescriptor =
        ContextualSerializer(Any::class, null, emptyArray()).descriptor

    override fun serialize(encoder: Encoder, value: Any) {
        when (value) {
            is String -> encoder.encodeString(value)
            is Int -> encoder.encodeInt(value)
            is Long -> encoder.encodeLong(value)
            is Float -> encoder.encodeFloat(value)
            is Double -> encoder.encodeDouble(value)
            is Boolean -> encoder.encodeBoolean(value)
            is Map<*, *> -> {
                val mapSerializer = MapSerializer(String.serializer(), this)
                encoder.encodeSerializableValue(mapSerializer, value as Map<String, Any>)
            }

            is List<*> -> {
                val listSerializer = ListSerializer(this)
                encoder.encodeSerializableValue(listSerializer, value as List<Any>)
            }

            is Query -> {
                // Handle Query serialization directly
                val querySerializer = Query.serializer()
                encoder.encodeSerializableValue(querySerializer, value)
            }

            else -> encoder.encodeString(value.toString())
        }
    }

    override fun deserialize(decoder: Decoder): Any {
        val element = decoder.decodeSerializableValue(JsonElement.serializer())
        return deserializeJsonElement(element) ?: Unit
    }

    private fun deserializeJsonElement(element: JsonElement): Any? {
        return when (element) {
            is JsonPrimitive -> when {
                element.isString -> element.jsonPrimitive.content
                element.intOrNull != null -> element.int
                element.longOrNull != null -> element.long
                element.doubleOrNull != null -> element.double
                element.booleanOrNull != null -> element.boolean
                else -> element.content
            }

            is JsonObject -> element.toDeserializedMap()
            is JsonArray -> element.map { deserializeJsonElement(it) }
            JsonNull -> null
        }
    }

    private fun JsonObject.toDeserializedMap(): Map<String, Any?> {
        return mapValues { (_, value) -> deserializeJsonElement(value) }
    }

}
