package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Transaction
 */
@Serializable
data class Transaction(
    /**
     * Transaction ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Transaction creation time in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Transaction update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Current status of the transaction. One of: pending, committing, committed, rolled_back, failed.
     */
    @SerialName("status")
    val status: String,

    /**
     * Number of operations in the transaction.
     */
    @SerialName("operations")
    val operations: Long,

    /**
     * Expiration time in ISO 8601 format.
     */
    @SerialName("expiresAt")
    val expiresAt: String,

    )

