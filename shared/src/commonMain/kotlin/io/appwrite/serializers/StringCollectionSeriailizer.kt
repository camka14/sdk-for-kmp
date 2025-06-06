package io.appwrite.serializers

import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.jsonPrimitive

class StringCollectionSerializer : KSerializer<Collection<String>> {
    override val descriptor = ListSerializer(String.serializer()).descriptor

    override fun deserialize(decoder: Decoder): Collection<String> {
        val array = decoder.decodeSerializableValue(JsonArray.serializer())
        return array.map { it.jsonPrimitive.content }
    }

    override fun serialize(encoder: Encoder, value: Collection<String>) {
        encoder.encodeSerializableValue(
            JsonArray.serializer(),
            JsonArray(value.map { JsonPrimitive(it) })
        )
    }
}
