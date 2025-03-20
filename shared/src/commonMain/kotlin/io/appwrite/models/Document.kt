package io.appwrite.models

import io.appwrite.extensions.jsonCast
import io.appwrite.extensions.json
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Contextual
import kotlinx.serialization.KSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.json.buildJsonObject
import kotlinx.serialization.json.encodeToJsonElement
import kotlinx.serialization.json.jsonArray
import kotlinx.serialization.json.jsonObject
import kotlinx.serialization.json.jsonPrimitive
import kotlinx.serialization.json.put

/**
 * Document
 */
@Serializable(with = DocumentSerializer::class)
data class Document<T>(
    /**
     * Document ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Collection ID.
     */
    @SerialName("\$collectionId")
    val collectionId: String,

    /**
     * Database ID.
     */
    @SerialName("\$databaseId")
    val databaseId: String,

    /**
     * Document creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Document update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Document permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("\$permissions")
    val permissions: List<String>,

    /**
     * Additional properties
     */
    @SerialName("data")
    val data: T
)

class DocumentSerializer<T>(private val dataSerializer: KSerializer<T>): KSerializer<Document<T>> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Document") {
        element("\$id", String.serializer().descriptor)
        element("\$collectionId", String.serializer().descriptor)
        element("\$databaseId", String.serializer().descriptor)
        element("\$createdAt", String.serializer().descriptor)
        element("\$updatedAt", String.serializer().descriptor)
        element("\$permissions", ListSerializer(String.serializer()).descriptor)
        element("data", dataSerializer.descriptor)
    }

    override fun deserialize(decoder: Decoder): Document<T> {
        val jsonObject = decoder.decodeSerializableValue(JsonObject.serializer())

        // Extract system fields ($ prefixed)
        val id = jsonObject["\$id"]?.jsonPrimitive?.content ?: ""
        val collectionId = jsonObject["\$collectionId"]?.jsonPrimitive?.content ?: ""
        val databaseId = jsonObject["\$databaseId"]?.jsonPrimitive?.content ?: ""
        val createdAt = jsonObject["\$createdAt"]?.jsonPrimitive?.content ?: ""
        val updatedAt = jsonObject["\$updatedAt"]?.jsonPrimitive?.content ?: ""
        val permissions = jsonObject["\$permissions"]?.jsonArray?.map { it.jsonPrimitive.content } ?: listOf()

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

        return Document(
            id = id,
            collectionId = collectionId,
            databaseId = databaseId,
            createdAt = createdAt,
            updatedAt = updatedAt,
            permissions = permissions,
            data = json.decodeFromJsonElement(dataSerializer, dataObject)
        )
    }

    override fun serialize(encoder: Encoder, value: Document<T>) {
        val combined = buildJsonObject {
            put("\$id", value.id)
            put("\$collectionId", value.collectionId)
            put("\$databaseId", value.databaseId)
            put("\$createdAt", value.createdAt)
            put("\$updatedAt", value.updatedAt)
            put("\$permissions", json.encodeToJsonElement(value.permissions))
            val jsonValues = json.encodeToJsonElement(dataSerializer, value.data).jsonObject

            // Add all data fields to root
            jsonValues.forEach { (key, value) ->
                put(key, value)
            }
        }

        return encoder.encodeSerializableValue(JsonObject.serializer(), combined)
    }
}
