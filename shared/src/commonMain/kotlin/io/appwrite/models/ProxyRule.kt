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
 * Rule
 */
@Serializable
data class ProxyRule(
    /**
     * Rule ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Rule creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Rule update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Domain name.
     */
    @SerialName("domain")
    val domain: String,

    /**
     * Action definition for the rule. Possible values are &quot;api&quot;, &quot;function&quot;, or &quot;redirect&quot;
     */
    @SerialName("resourceType")
    val resourceType: String,

    /**
     * ID of resource for the action type. If resourceType is &quot;api&quot; or &quot;url&quot;, it is empty. If resourceType is &quot;function&quot;, it is ID of the function.
     */
    @SerialName("resourceId")
    val resourceId: String,

    /**
     * Domain verification status. Possible values are &quot;created&quot;, &quot;verifying&quot;, &quot;verified&quot; and &quot;unverified&quot;
     */
    @SerialName("status")
    val status: String,

    /**
     * Certificate generation logs. This will return an empty string if generation did not run, or succeeded.
     */
    @SerialName("logs")
    val logs: String,

    /**
     * Certificate auto-renewal date in ISO 8601 format.
     */
    @SerialName("renewAt")
    val renewAt: String,

)

