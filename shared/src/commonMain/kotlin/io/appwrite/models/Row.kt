package io.appwrite.models

import io.appwrite.extensions.json
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
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
import kotlinx.serialization.json.long
import kotlinx.serialization.json.put

/**
 * Row
 */
@Serializable(with = RowSerializer::class)
data class Row<T>(
    /**
     * Row ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Row automatically incrementing ID.
     */
    @SerialName("\$sequence")
    val sequence: Long,

    /**
     * Table ID.
     */
    @SerialName("\$tableId")
    val tableId: String,

    /**
     * Database ID.
     */
    @SerialName("\$databaseId")
    val databaseId: String,

    /**
     * Row creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Row update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Row permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @SerialName("\$permissions")
    val permissions: List<String>,

    /**
     * Additional properties
     */
    @SerialName("data")
    val data: T
)

class RowSerializer<T>(private val dataSerializer: KSerializer<T>) : KSerializer<Row<T>> {
    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("Document") {
        element("\$id", String.serializer().descriptor)
        element("\$sequence", Long.serializer().descriptor)
        element("\$tableId", String.serializer().descriptor)
        element("\$databaseId", String.serializer().descriptor)
        element("\$createdAt", String.serializer().descriptor)
        element("\$updatedAt", String.serializer().descriptor)
        element("\$permissions", ListSerializer(String.serializer()).descriptor)
        element("data", dataSerializer.descriptor)
    }

    override fun deserialize(decoder: Decoder): Row<T> {
        val jsonObject = decoder.decodeSerializableValue(JsonObject.serializer())

        // Extract system fields ($ prefixed)
        val id = jsonObject["\$id"]!!.jsonPrimitive.content
        val sequence = jsonObject["\$sequence"]!!.jsonPrimitive.long
        val tableId = jsonObject["\$tableId"]!!.jsonPrimitive.content
        val databaseId = jsonObject["\$databaseId"]!!.jsonPrimitive.content
        val createdAt = jsonObject["\$createdAt"]!!.jsonPrimitive.content
        val updatedAt = jsonObject["\$updatedAt"]!!.jsonPrimitive.content
        val permissions = jsonObject["\$permissions"]!!.jsonArray.map { it.jsonPrimitive.content }

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

        return Row(
            id = id,
            sequence = sequence,
            tableId = tableId,
            databaseId = databaseId,
            createdAt = createdAt,
            updatedAt = updatedAt,
            permissions = permissions,
            data = json.decodeFromJsonElement(dataSerializer, dataObject)
        )
    }

    override fun serialize(encoder: Encoder, value: Row<T>) {
        val combined = buildJsonObject {
            put("\$id", value.id)
            put("\$sequence", value.sequence)
            put("\$tableId", value.tableId)
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
