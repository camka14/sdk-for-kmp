package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service

/**
 * The Messaging service allows you to send messages to any provider type (SMTP, push notification, SMS, etc.).
 **/
class Messaging(client: Client) : Service(client) {

    /**
     * Create subscriber
     *
     * Create a new subscriber.
     *
     * @param topicId Topic ID. The topic ID to subscribe to.
     * @param subscriberId Subscriber ID. Choose a custom Subscriber ID or a new Subscriber ID.
     * @param targetId Target ID. The target ID to link to the specified Topic ID.
     * @return [io.appwrite.models.Subscriber]
     */
    @Throws(Throwable::class)
    suspend fun createSubscriber(
        topicId: String,
        subscriberId: String,
        targetId: String,
    ): io.appwrite.models.Subscriber {
        val apiPath = "/messaging/topics/{topicId}/subscribers"
            .replace("{topicId}", topicId)

        val apiParams = mutableMapOf<String, Any?>(
            "subscriberId" to subscriberId,
            "targetId" to targetId,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Subscriber::class,
        )
    }


    /**
     * Delete subscriber
     *
     * Delete a subscriber by its unique ID.
     *
     * @param topicId Topic ID. The topic ID subscribed to.
     * @param subscriberId Subscriber ID.
     * @return [Any]
     */
    @Throws(Throwable::class)
    suspend fun deleteSubscriber(
        topicId: String,
        subscriberId: String,
    ): Any {
        val apiPath = "/messaging/topics/{topicId}/subscribers/{subscriberId}"
            .replace("{topicId}", topicId)
            .replace("{subscriberId}", subscriberId)

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
        )
    }
}