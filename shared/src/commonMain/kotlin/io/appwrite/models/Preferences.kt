package io.appwrite.models

import io.appwrite.extensions.json
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.jsonObject

/**
 * Preferences
 */
@Serializable(with = PreferencesSerializer::class)
data class Preferences<T>(
    /**
     * Additional properties
     */
    @SerialName("data")
    val data: T
)

class PreferencesSerializer<T>(private val dataSerializer: KSerializer<T>) :
    KSerializer<Preferences<T>> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Document") {
        element("data", dataSerializer.descriptor)
    }

    override fun deserialize(decoder: Decoder): Preferences<T> {
        val jsonObject = decoder.decodeSerializableValue(JsonObject.serializer())

        // Extract system fields ($ prefixed)

        // Create data object from remaining fields
        val dataObject = buildJsonObject {
            jsonObject.forEach { (key, value) ->
                if (key.startsWith("$")) {
                    // Remove $ prefix for system fields
                    put(key.substring(1), value)
                } else {
                    put(key, value)
                }
            }
        }

        return Preferences(
            data = json.decodeFromJsonElement(dataSerializer, dataObject)
        )
    }

    override fun serialize(encoder: Encoder, value: Preferences<T>) {
        val combined = buildJsonObject {
            val jsonValues = json.encodeToJsonElement(dataSerializer, value.data).jsonObject

            // Add all data fields to root
            jsonValues.forEach { (key, value) ->
                put(key, value)
            }
        }

        return encoder.encodeSerializableValue(JsonObject.serializer(), combined)
    }
}
