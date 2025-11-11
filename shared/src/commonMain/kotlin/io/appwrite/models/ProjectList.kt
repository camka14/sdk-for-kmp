package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Projects List
 */
@Serializable
data class ProjectList(
    /**
     * Total number of projects that matched your query.
     */
    @SerialName("total")
    val total: Long,

    /**
     * List of projects.
     */
    @SerialName("projects")
    val projects: List<Project>,

    )

