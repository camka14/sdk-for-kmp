package io.appwrite.models

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Migration
 */
@Serializable
data class Migration(
    /**
     * Migration ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Migration creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Variable creation date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Migration status ( pending, processing, failed, completed )
     */
    @SerialName("status")
    val status: String,

    /**
     * Migration stage ( init, processing, source-check, destination-check, migrating, finished )
     */
    @SerialName("stage")
    val stage: String,

    /**
     * A string containing the type of source of the migration.
     */
    @SerialName("source")
    val source: String,

    /**
     * A string containing the type of destination of the migration.
     */
    @SerialName("destination")
    val destination: String,

    /**
     * Resources to migrate.
     */
    @SerialName("resources")
    val resources: List<String>,

    /**
     * Id of the resource to migrate.
     */
    @SerialName("resourceId")
    val resourceId: String,

    /**
     * A group of counters that represent the total progress of the migration.
     */
    @SerialName("statusCounters")
    @Contextual
    val statusCounters: Any,

    /**
     * An array of objects containing the report data of the resources that were migrated.
     */
    @SerialName("resourceData")
    @Contextual
    val resourceData: Any,

    /**
     * All errors that occurred during the migration process.
     */
    @SerialName("errors")
    val errors: List<String>,

    /**
     * Migration options used during the migration process.
     */
    @SerialName("options")
    @Contextual
    val options: Any,

    )

