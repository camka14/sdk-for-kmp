package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/**
 * Countries List
 */
@Serializable
data class CountryList(
    /**
     * Total number of countries documents that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of countries.
     */
    @SerialName("countries")
    val countries: List<Country>,

) {
    fun toMap(): Map<String, Any> = mapOf(
        "total" to total as Any,
        "countries" to countries.map { it.toMap() } as Any,
    )

    companion object {

        @Suppress("UNCHECKED_CAST")
        fun from(
            map: Map<String, Any>,
        ) = CountryList(
            total = (map["total"] as Number).toLong(),
            countries = (map["countries"] as List<Map<String, Any>>).map { Country.from(map = it) },
        )
    }
}