package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Specification
 */
@Serializable
data class Specification(
    /**
     * Memory size in MB.
     */
    @SerialName("memory")
    val memory: Long,

    /**
     * Number of CPUs.
     */
    @SerialName("cpus")
    val cpus: Double,

    /**
     * Is size enabled.
     */
    @SerialName("enabled")
    val enabled: Boolean,

    /**
     * Size slug.
     */
    @SerialName("slug")
    val slug: String,

    )

