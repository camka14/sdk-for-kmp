package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * AlgoMD5
 */
@Serializable
data class AlgoMd5(
    /**
     * Algo type.
     */
    @SerialName("type")
    val type: String,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "type" to type as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = AlgoMd5(
            type = map["type"] as String,
        )
    }
}