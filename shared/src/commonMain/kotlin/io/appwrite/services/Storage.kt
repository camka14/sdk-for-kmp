package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.exceptions.AppwriteException
import io.appwrite.extensions.*
import io.appwrite.serializers.*
import io.appwrite.webInterface.UrlParser
import kotlinx.serialization.KSerializer
import kotlin.jvm.JvmOverloads
import kotlin.reflect.KClass
import kotlinx.serialization.serializer
import io.ktor.client.plugins.cookies.cookies
import io.ktor.client.request.cookie
import io.ktor.client.request.get
import io.ktor.http.Cookie

/**
 * The Storage service allows you to manage your project files.
 **/
class Storage(client: Client) : Service(client) {
        /**
     * List buckets
     *
     * Get a list of all the storage buckets. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: enabled, name, fileSecurity, maximumFileSize, encryption, antivirus
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listBuckets(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.BucketList {
        val apiPath = "/storage/buckets"


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
            responseType = io.appwrite.models.BucketList::class,
            serializer = io.appwrite.models.BucketList.serializer()
        )
    }

            /**
     * Create bucket
     *
     * Create a new storage bucket.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Bucket name
     * @param permissions An array of permission strings. By default, no user is granted with any permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param fileSecurity Enables configuring permissions for individual file. A user needs one of file or bucket level permissions to access a file. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is bucket enabled? When set to 'disabled', users cannot access the files in this bucket but Server SDKs with and API key can still access the bucket. No files are lost when this is toggled.
     * @param maximumFileSize Maximum file size allowed in bytes. Maximum allowed value is 30MB.
     * @param allowedFileExtensions Allowed file extensions. Maximum of 100 extensions are allowed, each 64 characters long.
     * @param compression Compression algorithm choosen for compression. Can be one of none,  [gzip](https://en.wikipedia.org/wiki/Gzip), or [zstd](https://en.wikipedia.org/wiki/Zstd), For file size above 20MB compression is skipped even if it's enabled
     * @param encryption Is encryption enabled? For file size above 20MB encryption is skipped even if it's enabled
     * @param antivirus Is virus scanning enabled? For file size above 20MB AntiVirus scanning is skipped even if it's enabled
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createBucket(
        bucketId: String,
        name: String,
        permissions: List<String>? = null,
        fileSecurity: Boolean? = null,
        enabled: Boolean? = null,
        maximumFileSize: Long? = null,
        allowedFileExtensions: List<String>? = null,
        compression: io.appwrite.enums.Compression? = null,
        encryption: Boolean? = null,
        antivirus: Boolean? = null,
    ): io.appwrite.models.Bucket {
        val apiPath = "/storage/buckets"


        val apiParams = mutableMapOf<String, Any?>(
            "bucketId" to bucketId,
            "name" to name,
            "permissions" to permissions,
            "fileSecurity" to fileSecurity,
            "enabled" to enabled,
            "maximumFileSize" to maximumFileSize,
            "allowedFileExtensions" to allowedFileExtensions,
            "compression" to compression,
            "encryption" to encryption,
            "antivirus" to antivirus,
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
            responseType = io.appwrite.models.Bucket::class,
            serializer = io.appwrite.models.Bucket.serializer()
        )
    }

            /**
     * Get bucket
     *
     * Get a storage bucket by its unique ID. This endpoint response returns a JSON object with the storage bucket metadata.
     *
    @Throws(Throwable::class)
     * @param bucketId Bucket unique ID.
     */
    @Throws(Throwable::class)
    suspend fun getBucket(
        bucketId: String,
    ): io.appwrite.models.Bucket {
        val apiPath = "/storage/buckets/{bucketId}"
            .replace("{bucketId}", bucketId)


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
            responseType = io.appwrite.models.Bucket::class,
            serializer = io.appwrite.models.Bucket.serializer()
        )
    }

            /**
     * Update bucket
     *
     * Update a storage bucket by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Bucket unique ID.
     * @param name Bucket name
     * @param permissions An array of permission strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param fileSecurity Enables configuring permissions for individual file. A user needs one of file or bucket level permissions to access a file. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is bucket enabled? When set to 'disabled', users cannot access the files in this bucket but Server SDKs with and API key can still access the bucket. No files are lost when this is toggled.
     * @param maximumFileSize Maximum file size allowed in bytes. Maximum allowed value is 30MB.
     * @param allowedFileExtensions Allowed file extensions. Maximum of 100 extensions are allowed, each 64 characters long.
     * @param compression Compression algorithm choosen for compression. Can be one of none, [gzip](https://en.wikipedia.org/wiki/Gzip), or [zstd](https://en.wikipedia.org/wiki/Zstd), For file size above 20MB compression is skipped even if it's enabled
     * @param encryption Is encryption enabled? For file size above 20MB encryption is skipped even if it's enabled
     * @param antivirus Is virus scanning enabled? For file size above 20MB AntiVirus scanning is skipped even if it's enabled
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateBucket(
        bucketId: String,
        name: String,
        permissions: List<String>? = null,
        fileSecurity: Boolean? = null,
        enabled: Boolean? = null,
        maximumFileSize: Long? = null,
        allowedFileExtensions: List<String>? = null,
        compression: io.appwrite.enums.Compression? = null,
        encryption: Boolean? = null,
        antivirus: Boolean? = null,
    ): io.appwrite.models.Bucket {
        val apiPath = "/storage/buckets/{bucketId}"
            .replace("{bucketId}", bucketId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
            "fileSecurity" to fileSecurity,
            "enabled" to enabled,
            "maximumFileSize" to maximumFileSize,
            "allowedFileExtensions" to allowedFileExtensions,
            "compression" to compression,
            "encryption" to encryption,
            "antivirus" to antivirus,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Bucket::class,
            serializer = io.appwrite.models.Bucket.serializer()
        )
    }

            /**
     * Delete bucket
     *
     * Delete a storage bucket by its unique ID.
     *
    @Throws(Throwable::class)
     * @param bucketId Bucket unique ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteBucket(
        bucketId: String,
    ): Any {
        val apiPath = "/storage/buckets/{bucketId}"
            .replace("{bucketId}", bucketId)


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
     * List files
     *
     * Get a list of all the user files. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, signature, mimeType, sizeOriginal, chunksTotal, chunksUploaded
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listFiles(
        bucketId: String,
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.FileList {
        val apiPath = "/storage/buckets/{bucketId}/files"
            .replace("{bucketId}", bucketId)


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
            responseType = io.appwrite.models.FileList::class,
            serializer = io.appwrite.models.FileList.serializer()
        )
    }

            /**
     * Create file
     *
     * Create a new file. Before using this route, you should create a new bucket resource using either a [server integration](https://appwrite.io/docs/server/storage#storageCreateBucket) API or directly from your Appwrite console.Larger files should be uploaded using multiple requests with the [content-range](https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Range) header to send a partial request with a maximum supported chunk of `5MB`. The `content-range` header values should always be in bytes.When the first request is sent, the server will return the **File** object, and the subsequent part request must include the file&#039;s **id** in `x-appwrite-id` header to allow the server to know that the partial upload is for the existing file and not for a new one.If you&#039;re creating a new file using one of the Appwrite SDKs, all the chunking logic will be managed by the SDK internally.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param file Binary file. Appwrite SDKs provide helpers to handle file input. [Learn about file input](https://appwrite.io/docs/products/storage/upload-download#input-file).
     * @param permissions An array of permission strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createFile(
        bucketId: String,
        fileId: String,
        file: InputFile,
        permissions: List<String>? = null,
        onProgress: ((UploadProgress) -> Unit)? = null
    ): io.appwrite.models.File {
        val apiPath = "/storage/buckets/{bucketId}/files"
            .replace("{bucketId}", bucketId)


        val apiParams = mutableMapOf<String, Any?>(
            "fileId" to fileId,
            "file" to file,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "multipart/form-data",
        )

        val idParamName: String? ="fileId"
        val paramName = "file"

        return client.chunkedUpload(
            apiPath,
            apiHeaders,
            apiParams,
            file,
            responseType = io.appwrite.models.File::class,
            io.appwrite.models.File.serializer(),
            paramName,
            idParamName,
            onProgress
        )
    }

            /**
     * Get file
     *
     * Get a file by its unique ID. This endpoint response returns a JSON object with the file metadata.
     *
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File ID.
     */
    @Throws(Throwable::class)
    suspend fun getFile(
        bucketId: String,
        fileId: String,
    ): io.appwrite.models.File {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)


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
            responseType = io.appwrite.models.File::class,
            serializer = io.appwrite.models.File.serializer()
        )
    }

            /**
     * Update file
     *
     * Update a file by its unique ID. Only users with write permissions have access to update this resource.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File unique ID.
     * @param name Name of the file
     * @param permissions An array of permission string. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateFile(
        bucketId: String,
        fileId: String,
        name: String? = null,
        permissions: List<String>? = null,
    ): io.appwrite.models.File {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
            "content-type" to "application/json",
        )

        return client.call(
            "PUT",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.File::class,
            serializer = io.appwrite.models.File.serializer()
        )
    }

            /**
     * Delete file
     *
     * Delete a file by its unique ID. Only users with write permissions have access to delete this resource.
     *
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteFile(
        bucketId: String,
        fileId: String,
    ): Any {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)


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
     * Get file for download
     *
     * Get a file content by its unique ID. The endpoint response return with a &#039;Content-Disposition: attachment&#039; header that tells the browser to start downloading the file to user downloads directory.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Storage bucket ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @param token File token for accessing this file.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getFileDownload(
        bucketId: String,
        fileId: String,
        token: String? = null,
    ): ByteArray {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}/download"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)


        val apiParams = mutableMapOf<String, Any?>(
            "token" to token,
            "project" to client.config["project"],
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class
        )
    }

            /**
     * Get file preview
     *
     * Get a file preview image. Currently, this method supports preview for image files (jpg, png, and gif), other supported formats, like pdf, docs, slides, and spreadsheets, will return the file icon image. You can also pass query string arguments for cutting and resizing your preview image. Preview is supported only for image files smaller than 10MB.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File ID
     * @param width Resize preview image width, Pass an integer between 0 to 4000.
     * @param height Resize preview image height, Pass an integer between 0 to 4000.
     * @param gravity Image crop gravity. Can be one of center,top-left,top,top-right,left,right,bottom-left,bottom,bottom-right
     * @param quality Preview image quality. Pass an integer between 0 to 100. Defaults to keep existing image quality.
     * @param borderWidth Preview image border in pixels. Pass an integer between 0 to 100. Defaults to 0.
     * @param borderColor Preview image border color. Use a valid HEX color, no # is needed for prefix.
     * @param borderRadius Preview image border radius in pixels. Pass an integer between 0 to 4000.
     * @param opacity Preview image opacity. Only works with images having an alpha channel (like png). Pass a number between 0 to 1.
     * @param rotation Preview image rotation in degrees. Pass an integer between -360 and 360.
     * @param background Preview image background color. Only works with transparent images (png). Use a valid HEX color, no # is needed for prefix.
     * @param output Output format type (jpeg, jpg, png, gif and webp).
     * @param token File token for accessing this file.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getFilePreview(
        bucketId: String,
        fileId: String,
        width: Long? = null,
        height: Long? = null,
        gravity: io.appwrite.enums.ImageGravity? = null,
        quality: Long? = null,
        borderWidth: Long? = null,
        borderColor: String? = null,
        borderRadius: Long? = null,
        opacity: Double? = null,
        rotation: Long? = null,
        background: String? = null,
        output: io.appwrite.enums.ImageFormat? = null,
        token: String? = null,
    ): ByteArray {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}/preview"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)


        val apiParams = mutableMapOf<String, Any?>(
            "width" to width,
            "height" to height,
            "gravity" to gravity,
            "quality" to quality,
            "borderWidth" to borderWidth,
            "borderColor" to borderColor,
            "borderRadius" to borderRadius,
            "opacity" to opacity,
            "rotation" to rotation,
            "background" to background,
            "output" to output,
            "token" to token,
            "project" to client.config["project"],
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class
        )
    }

            /**
     * Get file for view
     *
     * Get a file content by its unique ID. This endpoint is similar to the download method but returns with no  &#039;Content-Disposition: attachment&#039; header.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Storage bucket unique ID. You can create a new storage bucket using the Storage service [server integration](https://appwrite.io/docs/server/storage#createBucket).
     * @param fileId File ID.
     * @param token File token for accessing this file.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getFileView(
        bucketId: String,
        fileId: String,
        token: String? = null,
    ): ByteArray {
        val apiPath = "/storage/buckets/{bucketId}/files/{fileId}/view"
            .replace("{bucketId}", bucketId)
            .replace("{fileId}", fileId)


        val apiParams = mutableMapOf<String, Any?>(
            "token" to token,
            "project" to client.config["project"],
        )
        return client.call(
            "GET",
            apiPath,
            params = apiParams,
            responseType = ByteArray::class
        )
    }

            /**
     * Get storage usage stats
     *
     * Get usage metrics and statistics for all buckets in the project. You can view the total number of buckets, files, storage usage. The response includes both current totals and historical data over time. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, range defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getUsage(
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageStorage {
        val apiPath = "/storage/usage"


        val apiParams = mutableMapOf<String, Any?>(
            "range" to range,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.UsageStorage::class,
            serializer = io.appwrite.models.UsageStorage.serializer()
        )
    }

            /**
     * Get bucket usage stats
     *
     * Get usage metrics and statistics a specific bucket in the project. You can view the total number of files, storage usage. The response includes both current totals and historical data over time. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, range defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param bucketId Bucket ID.
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getBucketUsage(
        bucketId: String,
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageBuckets {
        val apiPath = "/storage/{bucketId}/usage"
            .replace("{bucketId}", bucketId)


        val apiParams = mutableMapOf<String, Any?>(
            "range" to range,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.UsageBuckets::class,
            serializer = io.appwrite.models.UsageBuckets.serializer()
        )
    }

    }
