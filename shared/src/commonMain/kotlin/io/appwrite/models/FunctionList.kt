package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Functions List
 */
@Serializable
data class FunctionList(
    /**
     * Total number of functions that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of functions.
     */
    @SerialName("functions")
    val functions: List<Function>,

    )

