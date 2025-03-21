package io.appwrite

import android.annotation.SuppressLint
import java.security.cert.X509Certificate
import javax.net.ssl.X509TrustManager

@SuppressLint("TrustAllX509TrustManager", "CustomX509TrustManager")
class AllCertsTrustManager : X509TrustManager {
    override fun checkClientTrusted(p0: Array<out X509Certificate>?, p1: String?) {
        // Empty implementation to trust all clients
    }

    override fun checkServerTrusted(p0: Array<out X509Certificate>?, p1: String?) {
        // Empty implementation to trust all servers
    }

    override fun getAcceptedIssuers(): Array<X509Certificate> = emptyArray()
}
