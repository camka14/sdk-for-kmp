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
import kotlinx.serialization.json.long
import kotlinx.serialization.json.put

/**
 * Template Variable
 */
@Serializable
data class TemplateVariable(
    /**
     * Variable Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Variable Description.
     */
    @SerialName("description")
    val description: String,

    /**
     * Variable Value.
     */
    @SerialName("value")
    val value: String,

    /**
     * Variable secret flag. Secret variables can only be updated or deleted, but never read.
     */
    @SerialName("secret")
    val secret: Boolean,

    /**
     * Variable Placeholder.
     */
    @SerialName("placeholder")
    val placeholder: String,

    /**
     * Is the variable required?
     */
    @SerialName("required")
    val required: Boolean,

    /**
     * Variable Type.
     */
    @SerialName("type")
    val type: String,

)

