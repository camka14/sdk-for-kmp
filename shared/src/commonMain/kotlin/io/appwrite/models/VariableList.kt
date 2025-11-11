package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Variables List
 */
@Serializable
data class VariableList(
    /**
     * Total number of variables that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of variables.
     */
    @SerialName("variables")
    val variables: List<Variable>,

    )

