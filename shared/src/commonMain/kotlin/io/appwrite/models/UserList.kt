package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Users List
 */
@Serializable
data class UserList<T>(
    /**
     * Total number of users that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of users.
     */
    @SerialName("users")
    val users: List<User<T>>,

    )

