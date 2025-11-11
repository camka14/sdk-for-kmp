package io.appwrite.models

import io.appwrite.enums.ExecutionStatus
import io.appwrite.enums.ExecutionTrigger
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * Execution
 */
@Serializable
data class Execution(
    /**
     * Execution ID.
     */
    @SerialName("\$id")
    val id: String,

    /**
     * Execution creation date in ISO 8601 format.
     */
    @SerialName("\$createdAt")
    val createdAt: String,

    /**
     * Execution update date in ISO 8601 format.
     */
    @SerialName("\$updatedAt")
    val updatedAt: String,

    /**
     * Execution roles.
     */
    @SerialName("\$permissions")
    val permissions: List<String>,

    /**
     * Function ID.
     */
    @SerialName("functionId")
    val functionId: String,

    /**
     * Function&#039;s deployment ID used to create the execution.
     */
    @SerialName("deploymentId")
    val deploymentId: String,

    /**
     * The trigger that caused the function to execute. Possible values can be: `http`, `schedule`, or `event`.
     */
    @SerialName("trigger")
    val trigger: ExecutionTrigger,

    /**
     * The status of the function execution. Possible values can be: `waiting`, `processing`, `completed`, `failed`, or `scheduled`.
     */
    @SerialName("status")
    val status: ExecutionStatus,

    /**
     * HTTP request method type.
     */
    @SerialName("requestMethod")
    val requestMethod: String,

    /**
     * HTTP request path and query.
     */
    @SerialName("requestPath")
    val requestPath: String,

    /**
     * HTTP request headers as a key-value object. This will return only whitelisted headers. All headers are returned if execution is created as synchronous.
     */
    @SerialName("requestHeaders")
    val requestHeaders: List<Headers>,

    /**
     * HTTP response status code.
     */
    @SerialName("responseStatusCode")
    val responseStatusCode: Long,

    /**
     * HTTP response body. This will return empty unless execution is created as synchronous.
     */
    @SerialName("responseBody")
    val responseBody: String,

    /**
     * HTTP response headers as a key-value object. This will return only whitelisted headers. All headers are returned if execution is created as synchronous.
     */
    @SerialName("responseHeaders")
    val responseHeaders: List<Headers>,

    /**
     * Function logs. Includes the last 4,000 characters. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerialName("logs")
    val logs: String,

    /**
     * Function errors. Includes the last 4,000 characters. This will return an empty string unless the response is returned using an API key or as part of a webhook payload.
     */
    @SerialName("errors")
    val errors: String,

    /**
     * Resource(function/site) execution duration in seconds.
     */
    @SerialName("duration")
    val duration: Double,

    /**
     * The scheduled time for execution. If left empty, execution will be queued immediately.
     */
    @SerialName("scheduledAt")
    var scheduledAt: String?,

    )

