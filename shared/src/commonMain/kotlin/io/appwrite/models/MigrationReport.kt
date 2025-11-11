package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Migration Report
 */
@Serializable
data class MigrationReport(
    /**
     * Number of users to be migrated.
     */
    @SerialName("user")
    val user: Long,

    /**
     * Number of teams to be migrated.
     */
    @SerialName("team")
    val team: Long,

    /**
     * Number of databases to be migrated.
     */
    @SerialName("database")
    val database: Long,

    /**
     * Number of rows to be migrated.
     */
    @SerialName("row")
    val row: Long,

    /**
     * Number of files to be migrated.
     */
    @SerialName("file")
    val file: Long,

    /**
     * Number of buckets to be migrated.
     */
    @SerialName("bucket")
    val bucket: Long,

    /**
     * Number of functions to be migrated.
     */
    @SerialName("function")
    val function: Long,

    /**
     * Size of files to be migrated in mb.
     */
    @SerialName("size")
    val size: Long,

    /**
     * Version of the Appwrite instance to be migrated.
     */
    @SerialName("version")
    val version: String,

    )

