package io.appwrite

import javax.net.ssl.X509TrustManager

class AllCertsTrustManager : X509TrustManager {
    @Suppress("TrustAllX509TrustManager")
    override fun checkClientTrusted(
        chain: Array<out java.security.cert.X509Certificate>?,
        authType: String?
    ) {
    }

    @Suppress("TrustAllX509TrustManager")
    override fun checkServerTrusted(
        chain: Array<out java.security.cert.X509Certificate>?,
        authType: String?
    ) {
    }

    override fun getAcceptedIssuers(): Array<out java.security.cert.X509Certificate> = arrayOf()
}
