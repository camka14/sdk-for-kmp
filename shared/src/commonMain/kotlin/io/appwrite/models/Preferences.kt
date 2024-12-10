package io.appwrite.models

import io.appwrite.extensions.jsonCast
import io.appwrite.serializers.DynamicLookupSerializer
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.InternalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.MapSerializer
import kotlinx.serialization.builtins.serializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.StructureKind
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.buildSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlin.reflect.KClass

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

class PreferencesSerializer<T>(private val dataSerializer: KSerializer<T>) : KSerializer<Preferences<T>> {
    override val descriptor: SerialDescriptor = dataSerializer.descriptor
    override fun serialize(encoder: Encoder, value: Preferences<T>) = dataSerializer.serialize(encoder, value.data)
    override fun deserialize(decoder: Decoder) = Preferences(dataSerializer.deserialize(decoder))
}