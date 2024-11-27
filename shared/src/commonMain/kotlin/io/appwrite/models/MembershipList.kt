package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Memberships List
 */
@Serializable
data class MembershipList(
    /**
     * Total number of memberships documents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of memberships.
     */
    @SerialName("memberships")
    val memberships: List<Membership>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "memberships" to memberships.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = MembershipList(
            total = (map["total"] as Number).toLong(),
            memberships = (map["memberships"] as List<Map<String, Any>>).map { Membership.from(map = it) },
        )
    }
}