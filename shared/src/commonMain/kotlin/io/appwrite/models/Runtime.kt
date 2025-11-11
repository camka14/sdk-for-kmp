package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Runtime
 */
@Serializable
data class Runtime(
    /**
     * Runtime ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Parent runtime key.
     */
    @SerialName("key")
    val key: String,

    /**
     * Runtime Name.
     */
    @SerialName("name")
    val name: String,

    /**
     * Runtime version.
     */
    @SerialName("version")
    val version: String,

    /**
     * Base Docker image used to build the runtime.
     */
    @SerialName("base")
    val base: String,

    /**
     * Image name of Docker Hub.
     */
    @SerialName("image")
    val image: String,

    /**
     * Name of the logo image.
     */
    @SerialName("logo")
    val logo: String,

    /**
     * List of supported architectures.
     */
    @SerialName("supports")
    val supports: List<String>,

    )

