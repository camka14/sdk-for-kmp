package io.appwrite

import android.content.Context
import android.content.pm.PackageManager
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import io.appwrite.cookies.stores.DataStoreCookieStorage
import io.appwrite.cookies.stores.DataStoreManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import okio.Path.Companion.toPath

actual class Client(
    private val context: Context,
    endpoint: String = "https://cloud.appwrite.io/v1",
    endpointRealtime: String? = null,
    selfSigned: Boolean = false,
) : BaseClient<Client>(endpoint, endpointRealtime) {
    actual override val coroutineContext = Job() + Dispatchers.Default

    private val dataStoreManager = DataStoreManager(
        PreferenceDataStoreFactory.createWithPath(
            produceFile = { context.filesDir.resolve("appwriteCookies.preferences_pb").absolutePath.toPath() }
        ))
    val dataStoreCookieStorage = DataStoreCookieStorage(dataStoreManager)

    private val appVersion by lazy {
        try {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0)
            return@lazy pInfo.versionName
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
            return@lazy ""
        }
    }

    init {
        httpClient = createHttpClient(selfSigned, dataStoreCookieStorage)
        headers = mutableMapOf(
            "content-type" to "application/json",
            "origin" to "appwrite-android://${context.packageName}",
            "user-agent" to "${context.packageName}/${appVersion}, ${System.getProperty("http.agent")}",
            "x-sdk-name" to "KMP",
            "x-sdk-platform" to "client",
            "x-sdk-language" to "kmp",
            "x-sdk-version" to "0.0.0-SNAPSHOT",
            "x-appwrite-response-format" to "1.6.0"
        )
    }

    actual fun setSelfSigned(value: Boolean): Client {
        httpClient = createHttpClient(value, dataStoreCookieStorage)
        return this
    }
}