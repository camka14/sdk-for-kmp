package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Variable
 */
@Serializable
data class Variable(
    /**
     * Variable ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Variable creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Variable creation date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Variable key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Variable value.
     */
    @SerialName("value")
    val value: String,

    /**
     * Variable secret flag. Secret variables can only be updated or deleted, but never read.
     */
    @SerialName("secret")
    val secret: Boolean,

    /**
     * Service to which the variable belongs. Possible values are &quot;project&quot;, &quot;function&quot;
     */
    @SerialName("resourceType")
    val resourceType: String,

    /**
     * ID of resource to which the variable belongs. If resourceType is &quot;project&quot;, it is empty. If resourceType is &quot;function&quot;, it is ID of the function.
     */
    @SerialName("resourceId")
    val resourceId: String,

    )

