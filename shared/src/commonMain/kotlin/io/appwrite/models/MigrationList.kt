package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Migrations List
 */
@Serializable
data class MigrationList(
    /**
     * Total number of migrations that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of migrations.
     */
    @SerialName("migrations")
    val migrations: List<Migration>,

    )

