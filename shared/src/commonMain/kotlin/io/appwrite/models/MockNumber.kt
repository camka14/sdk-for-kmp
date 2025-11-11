package io.appwrite.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Mock Number
 */
@Serializable
data class MockNumber(
    /**
     * Mock phone number for testing phone authentication. Useful for testing phone authentication without sending an SMS.
     */
    @SerialName("phone")
    val phone: String,

    /**
     * Mock OTP for the number.
     */
    @SerialName("otp")
    val otp: String,

    )

