package io.appwrite.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Attributes List
 */
@Serializable
data class AttributeList(
    /**
     * Total number of attributes in the given collection.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of attributes.
     */
    @SerialName("attributes")
    val attributes: List<@Contextual Any>,

    )

