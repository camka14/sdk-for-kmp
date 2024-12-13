import io.appwrite.Client
import io.appwrite.enums.Browser
import io.appwrite.enums.CreditCard
import io.appwrite.enums.Flag

interface Avatars {
    @Throws(Throwable::class)
    suspend fun getBrowser(
        code: Browser,
        width: Long? = null,
        height: Long? = null,
        quality: Long? = null
    ): ByteArray

    @Throws(Throwable::class)
    suspend fun getCreditCard(
        code: CreditCard,
        width: Long? = null,
        height: Long? = null,
        quality: Long? = null
    ): ByteArray

    @Throws(Throwable::class)
    suspend fun getFavicon(url: String): ByteArray

    @Throws(Throwable::class)
    suspend fun getFlag(
        code: Flag,
        width: Long? = null,
        height: Long? = null,
        quality: Long? = null
    ): ByteArray

    @Throws(Throwable::class)
    suspend fun getImage(
        url: String,
        width: Long? = null,
        height: Long? = null
    ): ByteArray

    @Throws(Throwable::class)
    suspend fun getInitials(
        name: String? = null,
        width: Long? = null,
        height: Long? = null,
        background: String? = null
    ): ByteArray

    @Throws(Throwable::class)
    suspend fun getQR(
        text: String,
        size: Long? = null,
        margin: Long? = null,
        download: Boolean? = null
    ): ByteArray
}

class AvatarsImpl(private val client: Client) : Avatars {
    override suspend fun getBrowser(
        code: Browser,
        width: Long?,
        height: Long?,
        quality: Long?
    ): ByteArray {
        val params = mutableMapOf(
            "width" to width,
            "height" to height,
            "quality" to quality,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            "/avatars/browsers/${code.value}",
            params = params,
            responseType = ByteArray::class,
        )
    }

    override suspend fun getCreditCard(
        code: CreditCard,
        width: Long?,
        height: Long?,
        quality: Long?,
    ): ByteArray {
        val params = mutableMapOf(
            "width" to width,
            "height" to height,
            "quality" to quality,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            "/avatars/credit-cards/${code.value}",
            params = params,
            responseType = ByteArray::class,
        )
    }

    override suspend fun getFavicon(url: String): ByteArray {
        val params = mutableMapOf(
            "url" to url,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            "/avatars/favicon",
            params = params,
            responseType = ByteArray::class
        )
    }

    override suspend fun getFlag(
        code: Flag,
        width: Long?,
        height: Long?,
        quality: Long?
    ): ByteArray {
        val params = mutableMapOf(
            "width" to width,
            "height" to height,
            "quality" to quality,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            "/avatars/flags/${code.value}",
            params = params,
            responseType = ByteArray::class
        )
    }

    override suspend fun getImage(
        url: String,
        width: Long?,
        height: Long?
    ): ByteArray {
        val params = mutableMapOf(
            "url" to url,
            "width" to width,
            "height" to height,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            "/avatars/image",
            params = params,
            responseType = ByteArray::class
        )
    }

    override suspend fun getInitials(
        name: String?,
        width: Long?,
        height: Long?,
        background: String?
    ): ByteArray {
        val params = mutableMapOf(
            "name" to name,
            "width" to width,
            "height" to height,
            "background" to background,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            "/avatars/initials",
            params = params,
            responseType = ByteArray::class
        )
    }

    override suspend fun getQR(
        text: String,
        size: Long?,
        margin: Long?,
        download: Boolean?
    ): ByteArray {
        val params = mutableMapOf(
            "text" to text,
            "size" to size,
            "margin" to margin,
            "download" to download,
            "project" to client.config["project"]
        )
        return client.call(
            "GET",
            "/avatars/qr",
            params = params,
            responseType = ByteArray::class
        )
    }
}