package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Identities List
 */
@Serializable
data class IdentityList(
    /**
     * Total number of identities documents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of identities.
     */
    @SerialName("identities")
    val identities: List<Identity>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "identities" to identities.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = IdentityList(
            total = (map["total"] as Number).toLong(),
            identities = (map["identities"] as List<Map<String, Any>>).map { Identity.from(map = it) },
        )
    }
}