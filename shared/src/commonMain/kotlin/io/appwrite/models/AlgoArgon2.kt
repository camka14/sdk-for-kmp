package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * AlgoArgon2
 */
@Serializable
data class AlgoArgon2(
    /**
     * Algo type.
     */
    @SerialName("type")
    val type: String,

    /**
     * Memory used to compute hash.
     */
    @SerialName("memoryCost")
    val memoryCost: Long,

    /**
     * Amount of time consumed to compute hash
     */
    @SerialName("timeCost")
    val timeCost: Long,

    /**
     * Number of threads used to compute hash.
     */
    @SerialName("threads")
    val threads: Long,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "type" to type as Any,
        "memoryCost" to memoryCost as Any,
        "timeCost" to timeCost as Any,
        "threads" to threads as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AlgoArgon2(
            type = map["type"] as String,
            memoryCost = (map["memoryCost"] as Number).toLong(),
            timeCost = (map["timeCost"] as Number).toLong(),
            threads = (map["threads"] as Number).toLong(),
        )
    }
}