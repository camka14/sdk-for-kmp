package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.serializers.*

/**
 * The Messaging service allows you to send messages to any provider type (SMTP, push notification, SMS, etc.).
 **/
class Messaging(client: Client) : Service(client) {
    /**
     * List messages
     *
     * Get a list of all messages from the current Appwrite project.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: scheduledAt, deliveredAt, deliveredTotal, status, description, providerType
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listMessages(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.MessageList {
        val apiPath = "/messaging/messages"


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.MessageList::class,
            serializer = io.appwrite.models.MessageList.serializer()
        )
    }

    /**
     * Create email
     *
     * Create a new email message.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param subject Email Subject.
     * @param content Email Content.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param cc Array of target IDs to be added as CC.
     * @param bcc Array of target IDs to be added as BCC.
     * @param attachments Array of compound ID strings of bucket IDs and file IDs to be attached to the email. They should be formatted as <BUCKET_ID>:<FILE_ID>.
     * @param draft Is message a draft
     * @param html Is content of type HTML
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createEmail(
        messageId: String,
        subject: String,
        content: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        cc: List<String>? = null,
        bcc: List<String>? = null,
        attachments: List<String>? = null,
        draft: Boolean? = null,
        html: Boolean? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/email"


        val apiParams = mutableMapOf<String, Any?>(
            "messageId" to messageId,
            "subject" to subject,
            "content" to content,
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "cc" to cc,
            "bcc" to bcc,
            "attachments" to attachments,
            "draft" to draft,
            "html" to html,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * Update email
     *
     * Update an email message by its unique ID. This endpoint only works on messages that are in draft status. Messages that are already processing, sent, or failed cannot be updated.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param subject Email Subject.
     * @param content Email Content.
     * @param draft Is message a draft
     * @param html Is content of type HTML
     * @param cc Array of target IDs to be added as CC.
     * @param bcc Array of target IDs to be added as BCC.
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @param attachments Array of compound ID strings of bucket IDs and file IDs to be attached to the email. They should be formatted as <BUCKET_ID>:<FILE_ID>.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateEmail(
        messageId: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        subject: String? = null,
        content: String? = null,
        draft: Boolean? = null,
        html: Boolean? = null,
        cc: List<String>? = null,
        bcc: List<String>? = null,
        scheduledAt: String? = null,
        attachments: List<String>? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/email/{messageId}"
            .replace("{messageId}", messageId)


        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "subject" to subject,
            "content" to content,
            "draft" to draft,
            "html" to html,
            "cc" to cc,
            "bcc" to bcc,
            "scheduledAt" to scheduledAt,
            "attachments" to attachments,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * Create push notification
     *
     * Create a new push notification.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param title Title for push notification.
     * @param body Body for push notification.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param data Additional key-value pair data for push notification.
     * @param action Action for push notification.
     * @param image Image for push notification. Must be a compound bucket ID to file ID of a jpeg, png, or bmp image in Appwrite Storage. It should be formatted as <BUCKET_ID>:<FILE_ID>.
     * @param icon Icon for push notification. Available only for Android and Web Platform.
     * @param sound Sound for push notification. Available only for Android and iOS Platform.
     * @param color Color for push notification. Available only for Android Platform.
     * @param tag Tag for push notification. Available only for Android Platform.
     * @param badge Badge for push notification. Available only for iOS Platform.
     * @param draft Is message a draft
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @param contentAvailable If set to true, the notification will be delivered in the background. Available only for iOS Platform.
     * @param critical If set to true, the notification will be marked as critical. This requires the app to have the critical notification entitlement. Available only for iOS Platform.
     * @param priority Set the notification priority. "normal" will consider device state and may not deliver notifications immediately. "high" will always attempt to immediately deliver the notification.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createPush(
        messageId: String,
        title: String? = null,
        body: String? = null,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        data: Any? = null,
        action: String? = null,
        image: String? = null,
        icon: String? = null,
        sound: String? = null,
        color: String? = null,
        tag: String? = null,
        badge: Long? = null,
        draft: Boolean? = null,
        scheduledAt: String? = null,
        contentAvailable: Boolean? = null,
        critical: Boolean? = null,
        priority: io.appwrite.enums.MessagePriority? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/push"


        val apiParams = mutableMapOf<String, Any?>(
            "messageId" to messageId,
            "title" to title,
            "body" to body,
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "data" to data,
            "action" to action,
            "image" to image,
            "icon" to icon,
            "sound" to sound,
            "color" to color,
            "tag" to tag,
            "badge" to badge,
            "draft" to draft,
            "scheduledAt" to scheduledAt,
            "contentAvailable" to contentAvailable,
            "critical" to critical,
            "priority" to priority,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * Update push notification
     *
     * Update a push notification by its unique ID. This endpoint only works on messages that are in draft status. Messages that are already processing, sent, or failed cannot be updated.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param title Title for push notification.
     * @param body Body for push notification.
     * @param data Additional Data for push notification.
     * @param action Action for push notification.
     * @param image Image for push notification. Must be a compound bucket ID to file ID of a jpeg, png, or bmp image in Appwrite Storage. It should be formatted as <BUCKET_ID>:<FILE_ID>.
     * @param icon Icon for push notification. Available only for Android and Web platforms.
     * @param sound Sound for push notification. Available only for Android and iOS platforms.
     * @param color Color for push notification. Available only for Android platforms.
     * @param tag Tag for push notification. Available only for Android platforms.
     * @param badge Badge for push notification. Available only for iOS platforms.
     * @param draft Is message a draft
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     * @param contentAvailable If set to true, the notification will be delivered in the background. Available only for iOS Platform.
     * @param critical If set to true, the notification will be marked as critical. This requires the app to have the critical notification entitlement. Available only for iOS Platform.
     * @param priority Set the notification priority. "normal" will consider device battery state and may send notifications later. "high" will always attempt to immediately deliver the notification.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updatePush(
        messageId: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        title: String? = null,
        body: String? = null,
        data: Any? = null,
        action: String? = null,
        image: String? = null,
        icon: String? = null,
        sound: String? = null,
        color: String? = null,
        tag: String? = null,
        badge: Long? = null,
        draft: Boolean? = null,
        scheduledAt: String? = null,
        contentAvailable: Boolean? = null,
        critical: Boolean? = null,
        priority: io.appwrite.enums.MessagePriority? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/push/{messageId}"
            .replace("{messageId}", messageId)


        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "title" to title,
            "body" to body,
            "data" to data,
            "action" to action,
            "image" to image,
            "icon" to icon,
            "sound" to sound,
            "color" to color,
            "tag" to tag,
            "badge" to badge,
            "draft" to draft,
            "scheduledAt" to scheduledAt,
            "contentAvailable" to contentAvailable,
            "critical" to critical,
            "priority" to priority,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * createSms
     *
     * Create a new SMS message.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param content SMS Content.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param draft Is message a draft
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createSms(
        messageId: String,
        content: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        draft: Boolean? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/sms"


        val apiParams = mutableMapOf<String, Any?>(
            "messageId" to messageId,
            "content" to content,
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "draft" to draft,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * createSMS
     *
     * Create a new SMS message.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param content SMS Content.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param draft Is message a draft
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createSMS(
        messageId: String,
        content: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        draft: Boolean? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/sms"


        val apiParams = mutableMapOf<String, Any?>(
            "messageId" to messageId,
            "content" to content,
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "draft" to draft,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * updateSms
     *
     * Update an SMS message by its unique ID. This endpoint only works on messages that are in draft status. Messages that are already processing, sent, or failed cannot be updated.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param content Email Content.
     * @param draft Is message a draft
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateSms(
        messageId: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        content: String? = null,
        draft: Boolean? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/sms/{messageId}"
            .replace("{messageId}", messageId)


        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "content" to content,
            "draft" to draft,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * updateSMS
     *
     * Update an SMS message by its unique ID. This endpoint only works on messages that are in draft status. Messages that are already processing, sent, or failed cannot be updated.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID.
     * @param topics List of Topic IDs.
     * @param users List of User IDs.
     * @param targets List of Targets IDs.
     * @param content Email Content.
     * @param draft Is message a draft
     * @param scheduledAt Scheduled delivery time for message in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. DateTime value must be in future.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateSMS(
        messageId: String,
        topics: List<String>? = null,
        users: List<String>? = null,
        targets: List<String>? = null,
        content: String? = null,
        draft: Boolean? = null,
        scheduledAt: String? = null,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/sms/{messageId}"
            .replace("{messageId}", messageId)


        val apiParams = mutableMapOf<String, Any?>(
            "topics" to topics,
            "users" to users,
            "targets" to targets,
            "content" to content,
            "draft" to draft,
            "scheduledAt" to scheduledAt,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * Get message
     *
     * Get a message by its unique ID.
     *
    @Throws(Throwable::class)
     * @param messageId Message ID.
     */
    @Throws(Throwable::class)
    suspend fun getMessage(
        messageId: String,
    ): io.appwrite.models.Message {
        val apiPath = "/messaging/messages/{messageId}"
            .replace("{messageId}", messageId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Message::class,
            serializer = io.appwrite.models.Message.serializer()
        )
    }

    /**
     * Delete message
     *
     * Delete a message. If the message is not a draft or scheduled, but has been sent, this will not recall the message.
     *
    @Throws(Throwable::class)
     * @param messageId Message ID.
     */
    @Throws(Throwable::class)
    suspend fun delete(
        messageId: String,
    ): Any {
        val apiPath = "/messaging/messages/{messageId}"
            .replace("{messageId}", messageId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

    /**
     * List message logs
     *
     * Get the message activity logs listed by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listMessageLogs(
        messageId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/messaging/messages/{messageId}/logs"
            .replace("{messageId}", messageId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class,
            serializer = io.appwrite.models.LogList.serializer()
        )
    }

    /**
     * List message targets
     *
     * Get a list of the targets associated with a message.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param messageId Message ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: userId, providerId, identifier, providerType
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listTargets(
        messageId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.TargetList {
        val apiPath = "/messaging/messages/{messageId}/targets"
            .replace("{messageId}", messageId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TargetList::class,
            serializer = io.appwrite.models.TargetList.serializer()
        )
    }

    /**
     * List providers
     *
     * Get a list of all providers from the current Appwrite project.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, provider, type, enabled
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listProviders(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ProviderList {
        val apiPath = "/messaging/providers"


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.ProviderList::class,
            serializer = io.appwrite.models.ProviderList.serializer()
        )
    }

    /**
     * createApnsProvider
     *
     * Create a new Apple Push Notification service provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param authKey APNS authentication key.
     * @param authKeyId APNS authentication key ID.
     * @param teamId APNS team ID.
     * @param bundleId APNS bundle ID.
     * @param sandbox Use APNS sandbox environment.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createApnsProvider(
        providerId: String,
        name: String,
        authKey: String? = null,
        authKeyId: String? = null,
        teamId: String? = null,
        bundleId: String? = null,
        sandbox: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/apns"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "authKey" to authKey,
            "authKeyId" to authKeyId,
            "teamId" to teamId,
            "bundleId" to bundleId,
            "sandbox" to sandbox,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * createAPNSProvider
     *
     * Create a new Apple Push Notification service provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param authKey APNS authentication key.
     * @param authKeyId APNS authentication key ID.
     * @param teamId APNS team ID.
     * @param bundleId APNS bundle ID.
     * @param sandbox Use APNS sandbox environment.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createAPNSProvider(
        providerId: String,
        name: String,
        authKey: String? = null,
        authKeyId: String? = null,
        teamId: String? = null,
        bundleId: String? = null,
        sandbox: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/apns"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "authKey" to authKey,
            "authKeyId" to authKeyId,
            "teamId" to teamId,
            "bundleId" to bundleId,
            "sandbox" to sandbox,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * updateApnsProvider
     *
     * Update a Apple Push Notification service provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param authKey APNS authentication key.
     * @param authKeyId APNS authentication key ID.
     * @param teamId APNS team ID.
     * @param bundleId APNS bundle ID.
     * @param sandbox Use APNS sandbox environment.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateApnsProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        authKey: String? = null,
        authKeyId: String? = null,
        teamId: String? = null,
        bundleId: String? = null,
        sandbox: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/apns/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "authKey" to authKey,
            "authKeyId" to authKeyId,
            "teamId" to teamId,
            "bundleId" to bundleId,
            "sandbox" to sandbox,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * updateAPNSProvider
     *
     * Update a Apple Push Notification service provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param authKey APNS authentication key.
     * @param authKeyId APNS authentication key ID.
     * @param teamId APNS team ID.
     * @param bundleId APNS bundle ID.
     * @param sandbox Use APNS sandbox environment.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateAPNSProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        authKey: String? = null,
        authKeyId: String? = null,
        teamId: String? = null,
        bundleId: String? = null,
        sandbox: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/apns/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "authKey" to authKey,
            "authKeyId" to authKeyId,
            "teamId" to teamId,
            "bundleId" to bundleId,
            "sandbox" to sandbox,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * createFcmProvider
     *
     * Create a new Firebase Cloud Messaging provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param serviceAccountJSON FCM service account JSON.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createFcmProvider(
        providerId: String,
        name: String,
        serviceAccountJSON: Any? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/fcm"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "serviceAccountJSON" to serviceAccountJSON,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * createFCMProvider
     *
     * Create a new Firebase Cloud Messaging provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param serviceAccountJSON FCM service account JSON.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createFCMProvider(
        providerId: String,
        name: String,
        serviceAccountJSON: Any? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/fcm"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "serviceAccountJSON" to serviceAccountJSON,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * updateFcmProvider
     *
     * Update a Firebase Cloud Messaging provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param serviceAccountJSON FCM service account JSON.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateFcmProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        serviceAccountJSON: Any? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/fcm/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "serviceAccountJSON" to serviceAccountJSON,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * updateFCMProvider
     *
     * Update a Firebase Cloud Messaging provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param serviceAccountJSON FCM service account JSON.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateFCMProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        serviceAccountJSON: Any? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/fcm/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "serviceAccountJSON" to serviceAccountJSON,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Create Mailgun provider
     *
     * Create a new Mailgun provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param apiKey Mailgun API Key.
     * @param domain Mailgun Domain.
     * @param isEuRegion Set as EU region.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name. Reply to name must have reply to email as well.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email. Reply to email must have reply to name as well.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createMailgunProvider(
        providerId: String,
        name: String,
        apiKey: String? = null,
        domain: String? = null,
        isEuRegion: Boolean? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/mailgun"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "apiKey" to apiKey,
            "domain" to domain,
            "isEuRegion" to isEuRegion,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Update Mailgun provider
     *
     * Update a Mailgun provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param apiKey Mailgun API Key.
     * @param domain Mailgun Domain.
     * @param isEuRegion Set as EU region.
     * @param enabled Set as enabled.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateMailgunProvider(
        providerId: String,
        name: String? = null,
        apiKey: String? = null,
        domain: String? = null,
        isEuRegion: Boolean? = null,
        enabled: Boolean? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/mailgun/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "apiKey" to apiKey,
            "domain" to domain,
            "isEuRegion" to isEuRegion,
            "enabled" to enabled,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Create Msg91 provider
     *
     * Create a new MSG91 provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param templateId Msg91 template ID
     * @param senderId Msg91 sender ID.
     * @param authKey Msg91 auth key.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createMsg91Provider(
        providerId: String,
        name: String,
        templateId: String? = null,
        senderId: String? = null,
        authKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/msg91"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "templateId" to templateId,
            "senderId" to senderId,
            "authKey" to authKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Update Msg91 provider
     *
     * Update a MSG91 provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param templateId Msg91 template ID.
     * @param senderId Msg91 sender ID.
     * @param authKey Msg91 auth key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateMsg91Provider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        templateId: String? = null,
        senderId: String? = null,
        authKey: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/msg91/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "templateId" to templateId,
            "senderId" to senderId,
            "authKey" to authKey,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Create Resend provider
     *
     * Create a new Resend provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param apiKey Resend API key.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createResendProvider(
        providerId: String,
        name: String,
        apiKey: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/resend"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "apiKey" to apiKey,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Update Resend provider
     *
     * Update a Resend provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param apiKey Resend API key.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the Reply To field for the mail. Default value is Sender Name.
     * @param replyToEmail Email set in the Reply To field for the mail. Default value is Sender Email.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateResendProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        apiKey: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/resend/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "apiKey" to apiKey,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Create Sendgrid provider
     *
     * Create a new Sendgrid provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param apiKey Sendgrid API key.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createSendgridProvider(
        providerId: String,
        name: String,
        apiKey: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/sendgrid"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "apiKey" to apiKey,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Update Sendgrid provider
     *
     * Update a Sendgrid provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param apiKey Sendgrid API key.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the Reply To field for the mail. Default value is Sender Name.
     * @param replyToEmail Email set in the Reply To field for the mail. Default value is Sender Email.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateSendgridProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        apiKey: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/sendgrid/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "apiKey" to apiKey,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * createSmtpProvider
     *
     * Create a new SMTP provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param host SMTP hosts. Either a single hostname or multiple semicolon-delimited hostnames. You can also specify a different port for each host such as `smtp1.example.com:25;smtp2.example.com`. You can also specify encryption type, for example: `tls://smtp1.example.com:587;ssl://smtp2.example.com:465"`. Hosts will be tried in order.
     * @param port The default SMTP server port.
     * @param username Authentication username.
     * @param password Authentication password.
     * @param encryption Encryption type. Can be omitted, 'ssl', or 'tls'
     * @param autoTLS Enable SMTP AutoTLS feature.
     * @param mailer The value to use for the X-Mailer header.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createSmtpProvider(
        providerId: String,
        name: String,
        host: String,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        encryption: io.appwrite.enums.SmtpEncryption? = null,
        autoTLS: Boolean? = null,
        mailer: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/smtp"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "encryption" to encryption,
            "autoTLS" to autoTLS,
            "mailer" to mailer,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * createSMTPProvider
     *
     * Create a new SMTP provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param host SMTP hosts. Either a single hostname or multiple semicolon-delimited hostnames. You can also specify a different port for each host such as `smtp1.example.com:25;smtp2.example.com`. You can also specify encryption type, for example: `tls://smtp1.example.com:587;ssl://smtp2.example.com:465"`. Hosts will be tried in order.
     * @param port The default SMTP server port.
     * @param username Authentication username.
     * @param password Authentication password.
     * @param encryption Encryption type. Can be omitted, 'ssl', or 'tls'
     * @param autoTLS Enable SMTP AutoTLS feature.
     * @param mailer The value to use for the X-Mailer header.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the reply to field for the mail. Default value is sender name.
     * @param replyToEmail Email set in the reply to field for the mail. Default value is sender email.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createSMTPProvider(
        providerId: String,
        name: String,
        host: String,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        encryption: io.appwrite.enums.SmtpEncryption? = null,
        autoTLS: Boolean? = null,
        mailer: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/smtp"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "encryption" to encryption,
            "autoTLS" to autoTLS,
            "mailer" to mailer,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * updateSmtpProvider
     *
     * Update a SMTP provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param host SMTP hosts. Either a single hostname or multiple semicolon-delimited hostnames. You can also specify a different port for each host such as `smtp1.example.com:25;smtp2.example.com`. You can also specify encryption type, for example: `tls://smtp1.example.com:587;ssl://smtp2.example.com:465"`. Hosts will be tried in order.
     * @param port SMTP port.
     * @param username Authentication username.
     * @param password Authentication password.
     * @param encryption Encryption type. Can be 'ssl' or 'tls'
     * @param autoTLS Enable SMTP AutoTLS feature.
     * @param mailer The value to use for the X-Mailer header.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the Reply To field for the mail. Default value is Sender Name.
     * @param replyToEmail Email set in the Reply To field for the mail. Default value is Sender Email.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateSmtpProvider(
        providerId: String,
        name: String? = null,
        host: String? = null,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        encryption: io.appwrite.enums.SmtpEncryption? = null,
        autoTLS: Boolean? = null,
        mailer: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/smtp/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "encryption" to encryption,
            "autoTLS" to autoTLS,
            "mailer" to mailer,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * updateSMTPProvider
     *
     * Update a SMTP provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param host SMTP hosts. Either a single hostname or multiple semicolon-delimited hostnames. You can also specify a different port for each host such as `smtp1.example.com:25;smtp2.example.com`. You can also specify encryption type, for example: `tls://smtp1.example.com:587;ssl://smtp2.example.com:465"`. Hosts will be tried in order.
     * @param port SMTP port.
     * @param username Authentication username.
     * @param password Authentication password.
     * @param encryption Encryption type. Can be 'ssl' or 'tls'
     * @param autoTLS Enable SMTP AutoTLS feature.
     * @param mailer The value to use for the X-Mailer header.
     * @param fromName Sender Name.
     * @param fromEmail Sender email address.
     * @param replyToName Name set in the Reply To field for the mail. Default value is Sender Name.
     * @param replyToEmail Email set in the Reply To field for the mail. Default value is Sender Email.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateSMTPProvider(
        providerId: String,
        name: String? = null,
        host: String? = null,
        port: Long? = null,
        username: String? = null,
        password: String? = null,
        encryption: io.appwrite.enums.SmtpEncryption? = null,
        autoTLS: Boolean? = null,
        mailer: String? = null,
        fromName: String? = null,
        fromEmail: String? = null,
        replyToName: String? = null,
        replyToEmail: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/smtp/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "host" to host,
            "port" to port,
            "username" to username,
            "password" to password,
            "encryption" to encryption,
            "autoTLS" to autoTLS,
            "mailer" to mailer,
            "fromName" to fromName,
            "fromEmail" to fromEmail,
            "replyToName" to replyToName,
            "replyToEmail" to replyToEmail,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Create Telesign provider
     *
     * Create a new Telesign provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param customerId Telesign customer ID.
     * @param apiKey Telesign API key.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createTelesignProvider(
        providerId: String,
        name: String,
        from: String? = null,
        customerId: String? = null,
        apiKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/telesign"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "customerId" to customerId,
            "apiKey" to apiKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Update Telesign provider
     *
     * Update a Telesign provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param customerId Telesign customer ID.
     * @param apiKey Telesign API key.
     * @param from Sender number.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateTelesignProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        customerId: String? = null,
        apiKey: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/telesign/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "customerId" to customerId,
            "apiKey" to apiKey,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Create Textmagic provider
     *
     * Create a new Textmagic provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param username Textmagic username.
     * @param apiKey Textmagic apiKey.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createTextmagicProvider(
        providerId: String,
        name: String,
        from: String? = null,
        username: String? = null,
        apiKey: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/textmagic"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "username" to username,
            "apiKey" to apiKey,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Update Textmagic provider
     *
     * Update a Textmagic provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param username Textmagic username.
     * @param apiKey Textmagic apiKey.
     * @param from Sender number.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateTextmagicProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        username: String? = null,
        apiKey: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/textmagic/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "username" to username,
            "apiKey" to apiKey,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Create Twilio provider
     *
     * Create a new Twilio provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param accountSid Twilio account secret ID.
     * @param authToken Twilio authentication token.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createTwilioProvider(
        providerId: String,
        name: String,
        from: String? = null,
        accountSid: String? = null,
        authToken: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/twilio"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "accountSid" to accountSid,
            "authToken" to authToken,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Update Twilio provider
     *
     * Update a Twilio provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param accountSid Twilio account secret ID.
     * @param authToken Twilio authentication token.
     * @param from Sender number.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateTwilioProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        accountSid: String? = null,
        authToken: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/twilio/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "accountSid" to accountSid,
            "authToken" to authToken,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Create Vonage provider
     *
     * Create a new Vonage provider.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Provider name.
     * @param from Sender Phone number. Format this number with a leading '+' and a country code, e.g., +16175551212.
     * @param apiKey Vonage API key.
     * @param apiSecret Vonage API secret.
     * @param enabled Set as enabled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createVonageProvider(
        providerId: String,
        name: String,
        from: String? = null,
        apiKey: String? = null,
        apiSecret: String? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/vonage"


        val apiParams = mutableMapOf<String, Any?>(
            "providerId" to providerId,
            "name" to name,
            "from" to from,
            "apiKey" to apiKey,
            "apiSecret" to apiSecret,
            "enabled" to enabled,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Update Vonage provider
     *
     * Update a Vonage provider by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param name Provider name.
     * @param enabled Set as enabled.
     * @param apiKey Vonage API key.
     * @param apiSecret Vonage API secret.
     * @param from Sender number.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateVonageProvider(
        providerId: String,
        name: String? = null,
        enabled: Boolean? = null,
        apiKey: String? = null,
        apiSecret: String? = null,
        from: String? = null,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/vonage/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
            "apiKey" to apiKey,
            "apiSecret" to apiSecret,
            "from" to from,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Get provider
     *
     * Get a provider by its unique ID.
     *
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     */
    @Throws(Throwable::class)
    suspend fun getProvider(
        providerId: String,
    ): io.appwrite.models.Provider {
        val apiPath = "/messaging/providers/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Provider::class,
            serializer = io.appwrite.models.Provider.serializer()
        )
    }

    /**
     * Delete provider
     *
     * Delete a provider by its unique ID.
     *
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteProvider(
        providerId: String,
    ): Any {
        val apiPath = "/messaging/providers/{providerId}"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

    /**
     * List provider logs
     *
     * Get the provider activity logs listed by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param providerId Provider ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listProviderLogs(
        providerId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/messaging/providers/{providerId}/logs"
            .replace("{providerId}", providerId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class,
            serializer = io.appwrite.models.LogList.serializer()
        )
    }

    /**
     * List subscriber logs
     *
     * Get the subscriber activity logs listed by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param subscriberId Subscriber ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listSubscriberLogs(
        subscriberId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/messaging/subscribers/{subscriberId}/logs"
            .replace("{subscriberId}", subscriberId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class,
            serializer = io.appwrite.models.LogList.serializer()
        )
    }

    /**
     * List topics
     *
     * Get a list of all topics from the current Appwrite project.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, description, emailTotal, smsTotal, pushTotal
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listTopics(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.TopicList {
        val apiPath = "/messaging/topics"


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TopicList::class,
            serializer = io.appwrite.models.TopicList.serializer()
        )
    }

    /**
     * Create topic
     *
     * Create a new topic.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param topicId Topic ID. Choose a custom Topic ID or a new Topic ID.
     * @param name Topic Name.
     * @param subscribe An array of role strings with subscribe permission. By default all users are granted with any subscribe permission. [learn more about roles](https://appwrite.io/docs/permissions#permission-roles). Maximum of 100 roles are allowed, each 64 characters long.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createTopic(
        topicId: String,
        name: String,
        subscribe: List<String>? = null,
    ): io.appwrite.models.Topic {
        val apiPath = "/messaging/topics"


        val apiParams = mutableMapOf<String, Any?>(
            "topicId" to topicId,
            "name" to name,
            "subscribe" to subscribe,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Topic::class,
            serializer = io.appwrite.models.Topic.serializer()
        )
    }

    /**
     * Get topic
     *
     * Get a topic by its unique ID.
     *
    @Throws(Throwable::class)
     * @param topicId Topic ID.
     */
    @Throws(Throwable::class)
    suspend fun getTopic(
        topicId: String,
    ): io.appwrite.models.Topic {
        val apiPath = "/messaging/topics/{topicId}"
            .replace("{topicId}", topicId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Topic::class,
            serializer = io.appwrite.models.Topic.serializer()
        )
    }

    /**
     * Update topic
     *
     * Update a topic by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param topicId Topic ID.
     * @param name Topic Name.
     * @param subscribe An array of role strings with subscribe permission. By default all users are granted with any subscribe permission. [learn more about roles](https://appwrite.io/docs/permissions#permission-roles). Maximum of 100 roles are allowed, each 64 characters long.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateTopic(
        topicId: String,
        name: String? = null,
        subscribe: List<String>? = null,
    ): io.appwrite.models.Topic {
        val apiPath = "/messaging/topics/{topicId}"
            .replace("{topicId}", topicId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "subscribe" to subscribe,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PATCH",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Topic::class,
            serializer = io.appwrite.models.Topic.serializer()
        )
    }

    /**
     * Delete topic
     *
     * Delete a topic by its unique ID.
     *
    @Throws(Throwable::class)
     * @param topicId Topic ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteTopic(
        topicId: String,
    ): Any {
        val apiPath = "/messaging/topics/{topicId}"
            .replace("{topicId}", topicId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

    /**
     * List topic logs
     *
     * Get the topic activity logs listed by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param topicId Topic ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listTopicLogs(
        topicId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/messaging/topics/{topicId}/logs"
            .replace("{topicId}", topicId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.LogList::class,
            serializer = io.appwrite.models.LogList.serializer()
        )
    }

    /**
     * List subscribers
     *
     * Get a list of all subscribers from the current Appwrite project.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param topicId Topic ID. The topic ID subscribed to.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, provider, type, enabled
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listSubscribers(
        topicId: String,
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.SubscriberList {
        val apiPath = "/messaging/topics/{topicId}/subscribers"
            .replace("{topicId}", topicId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "search" to search,
            "total" to total,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.SubscriberList::class,
            serializer = io.appwrite.models.SubscriberList.serializer()
        )
    }

    /**
     * Create subscriber
     *
     * Create a new subscriber.
     *
    @Throws(Throwable::class)
     * @param topicId Topic ID. The topic ID to subscribe to.
     * @param subscriberId Subscriber ID. Choose a custom Subscriber ID or a new Subscriber ID.
     * @param targetId Target ID. The target ID to link to the specified Topic ID.
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
            "content-type" to "application/json",
        )

        return client.call(
            "POST",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Subscriber::class,
            serializer = io.appwrite.models.Subscriber.serializer()
        )
    }

    /**
     * Get subscriber
     *
     * Get a subscriber by its unique ID.
     *
    @Throws(Throwable::class)
     * @param topicId Topic ID. The topic ID subscribed to.
     * @param subscriberId Subscriber ID.
     */
    @Throws(Throwable::class)
    suspend fun getSubscriber(
        topicId: String,
        subscriberId: String,
    ): io.appwrite.models.Subscriber {
        val apiPath = "/messaging/topics/{topicId}/subscribers/{subscriberId}"
            .replace("{topicId}", topicId)
            .replace("{subscriberId}", subscriberId)


        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Subscriber::class,
            serializer = io.appwrite.models.Subscriber.serializer()
        )
    }

    /**
     * Delete subscriber
     *
     * Delete a subscriber by its unique ID.
     *
    @Throws(Throwable::class)
     * @param topicId Topic ID. The topic ID subscribed to.
     * @param subscriberId Subscriber ID.
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
            "content-type" to "application/json",
        )

        return client.call(
            "DELETE",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

}
