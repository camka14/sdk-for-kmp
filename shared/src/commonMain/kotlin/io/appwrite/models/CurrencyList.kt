package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Currencies List
 */
@Serializable
data class CurrencyList(
    /**
     * Total number of currencies documents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of currencies.
     */
    @SerialName("currencies")
    val currencies: List<Currency>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "currencies" to currencies.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = CurrencyList(
            total = (map["total"] as Number).toLong(),
            currencies = (map["currencies"] as List<Map<String, Any>>).map { Currency.from(map = it) },
        )
    }
}