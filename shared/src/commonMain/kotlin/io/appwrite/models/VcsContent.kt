package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * VcsContents
 */
@Serializable
data class VcsContent(
    /**
     * Content size in bytes. Only files have size, and for directories, 0 is returned.
     */
    @SerialName("size")
    var size: Long?,

    /**
     * If a content is a directory. Directories can be used to check nested contents.
     */
    @SerialName("isDirectory")
    var isDirectory: Boolean?,

    /**
     * Name of directory or file.
     */
    @SerialName("name")
    val name: String,

    )

