package io.appwrite.services

import io.appwrite.Service
import io.appwrite.Client
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.forEachAsync
import io.appwrite.extensions.fromJson
import io.appwrite.extensions.jsonCast
import io.appwrite.models.*
import io.ktor.client.HttpClient
import io.ktor.client.plugins.websocket.DefaultClientWebSocketSession
import io.ktor.client.plugins.websocket.WebSockets
import io.ktor.client.plugins.websocket.webSocketSession
import io.ktor.client.request.url
import io.ktor.websocket.CloseReason
import io.ktor.websocket.Frame
import io.ktor.websocket.close
import io.ktor.websocket.readText
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext
import kotlin.reflect.KClass

class Realtime(client: Client) : Service(client), CoroutineScope {
    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private companion object {
        private const val TYPE_ERROR = "error"
        private const val TYPE_EVENT = "event"
        private const val DEBOUNCE_MILLIS = 1L

        private var webSocketSession: DefaultClientWebSocketSession? = null
        private var activeChannels = mutableSetOf<String>()
        private var activeSubscriptions = mutableMapOf<Int, RealtimeCallback>()

        private var subCallDepth = 0
        private var reconnectAttempts = 0
        private var subscriptionsCounter = 0
        private var reconnect = true
    }

    private fun createSocket() {
        launch {

        if (activeChannels.isEmpty()) {
            reconnect = false
            closeSocket()
            return@launch
        }

        val queryParams = buildString {
            append("project=${client.config["project"]}")
            activeChannels.forEach {
                append("&channels[]=$it")
            }
        }

        if (webSocketSession != null) {
            reconnect = false
            closeSocket()
        }

        webSocketSession = client.httpClient.webSocketSession {
            url("${client.endpointRealtime}/realtime?$queryParams")
        }

                try {
                    webSocketSession?.let { session ->
                        for (frame in session.incoming) {
                            when (frame) {
                                is Frame.Text -> handleMessage(frame.readText())
                                else -> {} // Ignore other frame types
                            }
                        }
                    }
                } catch (e: Exception) {
                    handleFailure(e)
                } finally {
                    handleClosing(RealtimeCode.NORMAL_CLOSURE.value, "Connection closed")
                }
            }
    }

    private suspend fun closeSocket() {
        webSocketSession?.close(CloseReason(CloseReason.Codes.VIOLATED_POLICY, ""))
        webSocketSession = null
    }

    private fun getTimeout() = when {
        reconnectAttempts < 5 -> 1000L
        reconnectAttempts < 15 -> 5000L
        reconnectAttempts < 100 -> 10000L
        else -> 60000L
    }

    fun subscribe(
        vararg channels: String,
        callback: (RealtimeResponseEvent<Any>) -> Unit,
    ) = subscribe(
        channels = channels,
        Any::class,
        callback
    )

    fun <T : Any> subscribe(
        vararg channels: String,
        payloadType: KClass<T>,
        callback: (RealtimeResponseEvent<T>) -> Unit,
    ): RealtimeSubscription {
        val counter = subscriptionsCounter++

        activeChannels.addAll(channels)
        activeSubscriptions[counter] = RealtimeCallback(
            channels.toList(),
            payloadType,
            callback as (RealtimeResponseEvent<*>) -> Unit
        )

        launch {
            subCallDepth++
            delay(DEBOUNCE_MILLIS)
            if (subCallDepth == 1) {
                createSocket()
            }
            subCallDepth--
        }

        return RealtimeSubscription {
            activeSubscriptions.remove(counter)
            cleanUp(*channels)
            createSocket()
        }
    }

    private fun cleanUp(vararg channels: String) {
        activeChannels.removeAll { channel ->
            if (!channels.contains(channel)) {
                return@removeAll false
            }
            activeSubscriptions.values.none { callback ->
                callback.channels.contains(channel)
            }
        }
    }

    private suspend fun handleMessage(text: String) {
        val message = text.fromJson<RealtimeResponse>()
        when (message.type) {
            TYPE_ERROR -> handleResponseError(message)
            TYPE_EVENT -> handleResponseEvent(message)
        }
    }

    private fun handleResponseError(message: RealtimeResponse) {
        throw message.data.jsonCast<AppwriteException>()
    }

    private suspend fun handleResponseEvent(message: RealtimeResponse) {
        val event = message.data.jsonCast<RealtimeResponseEvent<Any>>()
        if (event.channels.isEmpty()) {
            return
        }
        if (!event.channels.any { activeChannels.contains(it) }) {
            return
        }
        activeSubscriptions.values.forEachAsync { subscription ->
            if (event.channels.any { subscription.channels.contains(it) }) {
                event.payload = event.payload.jsonCast(subscription.payloadClass)
                subscription.callback(event)
            }
        }
    }

    private suspend fun handleClosing(code: Int, reason: String) {
        if (!reconnect || code == RealtimeCode.POLICY_VIOLATION.value) {
            reconnect = true
            return
        }

        val timeout = getTimeout()
        println("Realtime disconnected. Re-connecting in ${timeout / 1000} seconds.")

        delay(timeout)
        reconnectAttempts++
        createSocket()
    }

    private fun handleFailure(error: Throwable) {
        error.printStackTrace()
    }
}