package io.appwrite.enums

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
enum class PasswordHash(val value: String) {
    @SerialName("sha1")
    SHA1("sha1"),

    @SerialName("sha224")
    SHA224("sha224"),

    @SerialName("sha256")
    SHA256("sha256"),

    @SerialName("sha384")
    SHA384("sha384"),

    @SerialName("sha512/224")
    SHA512_224("sha512/224"),

    @SerialName("sha512/256")
    SHA512_256("sha512/256"),

    @SerialName("sha512")
    SHA512("sha512"),

    @SerialName("sha3-224")
    SHA3_224("sha3-224"),

    @SerialName("sha3-256")
    SHA3_256("sha3-256"),

    @SerialName("sha3-384")
    SHA3_384("sha3-384"),

    @SerialName("sha3-512")
    SHA3_512("sha3-512");

    override fun toString() = value
}
