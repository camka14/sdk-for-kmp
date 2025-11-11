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
 * Console Variables
 */
@Serializable
data class ConsoleVariables(
    /**
     * CNAME target for your Appwrite custom domains.
     */
    @SerialName("_APP_DOMAIN_TARGET_CNAME")
    val _APP_DOMAIN_TARGET_CNAME: String,

    /**
     * A target for your Appwrite custom domains.
     */
    @SerialName("_APP_DOMAIN_TARGET_A")
    val _APP_DOMAIN_TARGET_A: String,

    /**
     * Maximum build timeout in seconds.
     */
    @SerialName("_APP_COMPUTE_BUILD_TIMEOUT")
    val _APP_COMPUTE_BUILD_TIMEOUT: Long,

    /**
     * AAAA target for your Appwrite custom domains.
     */
    @SerialName("_APP_DOMAIN_TARGET_AAAA")
    val _APP_DOMAIN_TARGET_AAAA: String,

    /**
     * CAA target for your Appwrite custom domains.
     */
    @SerialName("_APP_DOMAIN_TARGET_CAA")
    val _APP_DOMAIN_TARGET_CAA: String,

    /**
     * Maximum file size allowed for file upload in bytes.
     */
    @SerialName("_APP_STORAGE_LIMIT")
    val _APP_STORAGE_LIMIT: Long,

    /**
     * Maximum file size allowed for deployment in bytes.
     */
    @SerialName("_APP_COMPUTE_SIZE_LIMIT")
    val _APP_COMPUTE_SIZE_LIMIT: Long,

    /**
     * Defines if usage stats are enabled. This value is set to &#039;enabled&#039; by default, to disable the usage stats set the value to &#039;disabled&#039;.
     */
    @SerialName("_APP_USAGE_STATS")
    val _APP_USAGE_STATS: String,

    /**
     * Defines if VCS (Version Control System) is enabled.
     */
    @SerialName("_APP_VCS_ENABLED")
    val _APP_VCS_ENABLED: Boolean,

    /**
     * Defines if main domain is configured. If so, custom domains can be created.
     */
    @SerialName("_APP_DOMAIN_ENABLED")
    val _APP_DOMAIN_ENABLED: Boolean,

    /**
     * Defines if AI assistant is enabled.
     */
    @SerialName("_APP_ASSISTANT_ENABLED")
    val _APP_ASSISTANT_ENABLED: Boolean,

    /**
     * A domain to use for site URLs.
     */
    @SerialName("_APP_DOMAIN_SITES")
    val _APP_DOMAIN_SITES: String,

    /**
     * A domain to use for function URLs.
     */
    @SerialName("_APP_DOMAIN_FUNCTIONS")
    val _APP_DOMAIN_FUNCTIONS: String,

    /**
     * Defines if HTTPS is enforced for all requests.
     */
    @SerialName("_APP_OPTIONS_FORCE_HTTPS")
    val _APP_OPTIONS_FORCE_HTTPS: String,

    /**
     * Comma-separated list of nameservers.
     */
    @SerialName("_APP_DOMAINS_NAMESERVERS")
    val _APP_DOMAINS_NAMESERVERS: String,

)

