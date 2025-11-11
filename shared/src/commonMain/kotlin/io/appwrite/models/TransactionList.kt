package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Transaction List
 */
@Serializable
data class TransactionList(
    /**
     * Total number of transactions that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of transactions.
     */
    @SerialName("transactions")
    val transactions: List<Transaction>,

    )

