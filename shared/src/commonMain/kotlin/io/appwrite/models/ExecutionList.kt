package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Executions List
 */
@Serializable
data class ExecutionList(
    /**
     * Total number of executions documents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of executions.
     */
    @SerialName("executions")
    val executions: List<Execution>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "executions" to executions.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = ExecutionList(
            total = (map["total"] as Number).toLong(),
            executions = (map["executions"] as List<Map<String, Any>>).map { Execution.from(map = it) },
        )
    }
}