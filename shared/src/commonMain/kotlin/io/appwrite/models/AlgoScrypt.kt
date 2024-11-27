package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * AlgoScrypt
 */
@Serializable
data class AlgoScrypt(
    /**
     * Algo type.
     */
    @SerialName("type")
    val type: String,

    /**
     * CPU complexity of computed hash.
     */
    @SerialName("costCpu")
    val costCpu: Long,

    /**
     * Memory complexity of computed hash.
     */
    @SerialName("costMemory")
    val costMemory: Long,

    /**
     * Parallelization of computed hash.
     */
    @SerialName("costParallel")
    val costParallel: Long,

    /**
     * Length used to compute hash.
     */
    @SerialName("length")
    val length: Long,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "type" to type as Any,
        "costCpu" to costCpu as Any,
        "costMemory" to costMemory as Any,
        "costParallel" to costParallel as Any,
        "length" to length as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AlgoScrypt(
            type = map["type"] as String,
            costCpu = (map["costCpu"] as Number).toLong(),
            costMemory = (map["costMemory"] as Number).toLong(),
            costParallel = (map["costParallel"] as Number).toLong(),
            length = (map["length"] as Number).toLong(),
        )
    }
}