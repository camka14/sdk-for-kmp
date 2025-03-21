package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class RelationshipType(val value: String) {
    @SerialName("oneToOne")
    ONETOONE("oneToOne"),
    @SerialName("manyToOne")
    MANYTOONE("manyToOne"),
    @SerialName("manyToMany")
    MANYTOMANY("manyToMany"),
    @SerialName("oneToMany")
    ONETOMANY("oneToMany");

    override fun toString() = value
}
