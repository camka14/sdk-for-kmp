package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Framework
 */
@Serializable
data class Framework(
    /**
     * Framework key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Framework Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Default runtime version.
     */
    @SerialName("buildRuntime")
    val buildRuntime: String,

    /**
     * List of supported runtime versions.
     */
    @SerialName("runtimes")
    val runtimes: List<String>,

    /**
     * List of supported adapters.
     */
    @SerialName("adapters")
    val adapters: List<FrameworkAdapter>,

    )

