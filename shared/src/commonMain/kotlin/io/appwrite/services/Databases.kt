package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.extensions.*
import io.appwrite.serializers.*
import kotlinx.serialization.KSerializer
import kotlin.reflect.KClass

/**
 * The Databases service allows you to create structured collections of documents, query and filter lists of documents
 **/
class Databases(client: Client) : Service(client) {
    /**
     * list
     *
     * Get a list of all databases from the current Appwrite project. You can use the search parameter to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun list(
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.DatabaseList {
        val apiPath = "/databases"


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
            responseType = io.appwrite.models.DatabaseList::class,
            serializer = io.appwrite.models.DatabaseList.serializer()
        )
    }

    /**
     * create
     *
     * Create a new Database.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Database name. Max length: 128 chars.
     * @param enabled Is the database enabled? When set to 'disabled', users cannot access the database but Server SDKs with an API key can still read and write to the database. No data is lost when this is toggled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun create(
        databaseId: String,
        name: String,
        enabled: Boolean? = null,
    ): io.appwrite.models.Database {
        val apiPath = "/databases"


        val apiParams = mutableMapOf<String, Any?>(
            "databaseId" to databaseId,
            "name" to name,
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
            responseType = io.appwrite.models.Database::class,
            serializer = io.appwrite.models.Database.serializer()
        )
    }

    /**
     * List transactions
     *
     * List transactions across all databases.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries).
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listTransactions(
        queries: List<String>? = null,
    ): io.appwrite.models.TransactionList {
        val apiPath = "/databases/transactions"


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.TransactionList::class,
            serializer = io.appwrite.models.TransactionList.serializer()
        )
    }

    /**
     * Create transaction
     *
     * Create a new transaction.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param ttl Seconds before the transaction expires.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createTransaction(
        ttl: Long? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/databases/transactions"


        val apiParams = mutableMapOf<String, Any?>(
            "ttl" to ttl,
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
            responseType = io.appwrite.models.Transaction::class,
            serializer = io.appwrite.models.Transaction.serializer()
        )
    }

    /**
     * Get transaction
     *
     * Get a transaction by its unique ID.
     *
    @Throws(Throwable::class)
     * @param transactionId Transaction ID.
     */
    @Throws(Throwable::class)
    suspend fun getTransaction(
        transactionId: String,
    ): io.appwrite.models.Transaction {
        val apiPath = "/databases/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)


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
            responseType = io.appwrite.models.Transaction::class,
            serializer = io.appwrite.models.Transaction.serializer()
        )
    }

    /**
     * Update transaction
     *
     * Update a transaction, to either commit or roll back its operations.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param transactionId Transaction ID.
     * @param commit Commit transaction?
     * @param rollback Rollback transaction?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateTransaction(
        transactionId: String,
        commit: Boolean? = null,
        rollback: Boolean? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/databases/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)


        val apiParams = mutableMapOf<String, Any?>(
            "commit" to commit,
            "rollback" to rollback,
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
            responseType = io.appwrite.models.Transaction::class,
            serializer = io.appwrite.models.Transaction.serializer()
        )
    }

    /**
     * Delete transaction
     *
     * Delete a transaction by its unique ID.
     *
    @Throws(Throwable::class)
     * @param transactionId Transaction ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteTransaction(
        transactionId: String,
    ): Any {
        val apiPath = "/databases/transactions/{transactionId}"
            .replace("{transactionId}", transactionId)


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
     * Create operations
     *
     * Create multiple operations in a single transaction.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param transactionId Transaction ID.
     * @param operations Array of staged operations.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createOperations(
        transactionId: String,
        operations: List<Any>? = null,
    ): io.appwrite.models.Transaction {
        val apiPath = "/databases/transactions/{transactionId}/operations"
            .replace("{transactionId}", transactionId)


        val apiParams = mutableMapOf<String, Any?>(
            "operations" to operations,
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
            responseType = io.appwrite.models.Transaction::class,
            serializer = io.appwrite.models.Transaction.serializer()
        )
    }

    /**
     * listUsage
     *
     * List usage metrics and statistics for all databases in the project. You can view the total number of databases, collections, documents, and storage usage. The response includes both current totals and historical data over time. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, range defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listUsage(
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageDatabases {
        val apiPath = "/databases/usage"


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
            responseType = io.appwrite.models.UsageDatabases::class,
            serializer = io.appwrite.models.UsageDatabases.serializer()
        )
    }

    /**
     * get
     *
     * Get a database by its unique ID. This endpoint response returns a JSON object with the database metadata.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     */
    @Throws(Throwable::class)
    suspend fun get(
        databaseId: String,
    ): io.appwrite.models.Database {
        val apiPath = "/databases/{databaseId}"
            .replace("{databaseId}", databaseId)


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
            responseType = io.appwrite.models.Database::class,
            serializer = io.appwrite.models.Database.serializer()
        )
    }

    /**
     * update
     *
     * Update a database by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param name Database name. Max length: 128 chars.
     * @param enabled Is database enabled? When set to 'disabled', users cannot access the database but Server SDKs with an API key can still read and write to the database. No data is lost when this is toggled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun update(
        databaseId: String,
        name: String,
        enabled: Boolean? = null,
    ): io.appwrite.models.Database {
        val apiPath = "/databases/{databaseId}"
            .replace("{databaseId}", databaseId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "enabled" to enabled,
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
            responseType = io.appwrite.models.Database::class,
            serializer = io.appwrite.models.Database.serializer()
        )
    }

    /**
     * delete
     *
     * Delete a database by its unique ID. Only API keys with with databases.write scope can delete a database.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     */
    @Throws(Throwable::class)
    suspend fun delete(
        databaseId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}"
            .replace("{databaseId}", databaseId)


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
     * List collections
     *
     * Get a list of all collections that belong to the provided databaseId. You can use the search parameter to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: name, enabled, documentSecurity
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listCollections(
        databaseId: String,
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.CollectionList {
        val apiPath = "/databases/{databaseId}/collections"
            .replace("{databaseId}", databaseId)


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
            responseType = io.appwrite.models.CollectionList::class,
            serializer = io.appwrite.models.CollectionList.serializer()
        )
    }

    /**
     * Create collections
     *
     * Create a new Collection. Before using this route, you should create a new database resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Collection name. Max length: 128 chars.
     * @param permissions An array of permissions strings. By default, no user is granted with any permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param documentSecurity Enables configuring permissions for individual documents. A user needs one of document or collection level permissions to access a document. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is collection enabled? When set to 'disabled', users cannot access the collection but Server SDKs with and API key can still read and write to the collection. No data is lost when this is toggled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createCollection(
        databaseId: String,
        collectionId: String,
        name: String,
        permissions: List<String>? = null,
        documentSecurity: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Collection {
        val apiPath = "/databases/{databaseId}/collections"
            .replace("{databaseId}", databaseId)


        val apiParams = mutableMapOf<String, Any?>(
            "collectionId" to collectionId,
            "name" to name,
            "permissions" to permissions,
            "documentSecurity" to documentSecurity,
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
            responseType = io.appwrite.models.Collection::class,
            serializer = io.appwrite.models.Collection.serializer()
        )
    }

    /**
     * Get collection
     *
     * Get a collection by its unique ID. This endpoint response returns a JSON object with the collection metadata.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     */
    @Throws(Throwable::class)
    suspend fun getCollection(
        databaseId: String,
        collectionId: String,
    ): io.appwrite.models.Collection {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


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
            responseType = io.appwrite.models.Collection::class,
            serializer = io.appwrite.models.Collection.serializer()
        )
    }

    /**
     * Update collection
     *
     * Update a collection by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param name Collection name. Max length: 128 chars.
     * @param permissions An array of permission strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param documentSecurity Enables configuring permissions for individual documents. A user needs one of document or collection level permissions to access a document. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is collection enabled? When set to 'disabled', users cannot access the collection but Server SDKs with and API key can still read and write to the collection. No data is lost when this is toggled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateCollection(
        databaseId: String,
        collectionId: String,
        name: String,
        permissions: List<String>? = null,
        documentSecurity: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Collection {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
            "documentSecurity" to documentSecurity,
            "enabled" to enabled,
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
            responseType = io.appwrite.models.Collection::class,
            serializer = io.appwrite.models.Collection.serializer()
        )
    }

    /**
     * Delete collection
     *
     * Delete a collection by its unique ID. Only users with write permissions have access to delete this resource.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteCollection(
        databaseId: String,
        collectionId: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


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
     * List attributes
     *
     * List attributes in the collection.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, type, size, required, array, status, error
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listAttributes(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.AttributeList {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


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
            responseType = io.appwrite.models.AttributeList::class,
            serializer = io.appwrite.models.AttributeList.serializer()
        )
    }

    /**
     * Create boolean attribute
     *
     * Create a boolean attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createBooleanAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeBoolean {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/boolean"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
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
            responseType = io.appwrite.models.AttributeBoolean::class,
            serializer = io.appwrite.models.AttributeBoolean.serializer()
        )
    }

    /**
     * Update boolean attribute
     *
     * Update a boolean attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateBooleanAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeBoolean {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/boolean/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeBoolean::class,
            serializer = io.appwrite.models.AttributeBoolean.serializer()
        )
    }

    /**
     * Create datetime attribute
     *
     * Create a date time attribute according to the ISO 8601 standard.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for the attribute in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createDatetimeAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeDatetime {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/datetime"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
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
            responseType = io.appwrite.models.AttributeDatetime::class,
            serializer = io.appwrite.models.AttributeDatetime.serializer()
        )
    }

    /**
     * Update datetime attribute
     *
     * Update a date time attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateDatetimeAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeDatetime {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/datetime/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeDatetime::class,
            serializer = io.appwrite.models.AttributeDatetime.serializer()
        )
    }

    /**
     * Create email attribute
     *
     * Create an email attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createEmailAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeEmail {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/email"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
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
            responseType = io.appwrite.models.AttributeEmail::class,
            serializer = io.appwrite.models.AttributeEmail.serializer()
        )
    }

    /**
     * Update email attribute
     *
     * Update an email attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New Attribute Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateEmailAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeEmail {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/email/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeEmail::class,
            serializer = io.appwrite.models.AttributeEmail.serializer()
        )
    }

    /**
     * Create enum attribute
     *
     * Create an enum attribute. The `elements` param acts as a white-list of accepted values for this attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param elements Array of enum values.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createEnumAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeEnum {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/enum"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "elements" to elements,
            "required" to required,
            "default" to default,
            "array" to array,
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
            responseType = io.appwrite.models.AttributeEnum::class,
            serializer = io.appwrite.models.AttributeEnum.serializer()
        )
    }

    /**
     * Update enum attribute
     *
     * Update an enum attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param elements Updated list of enum values.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New Attribute Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateEnumAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeEnum {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/enum/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "elements" to elements,
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeEnum::class,
            serializer = io.appwrite.models.AttributeEnum.serializer()
        )
    }

    /**
     * Create float attribute
     *
     * Create a float attribute. Optionally, minimum and maximum values can be provided.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value.
     * @param max Maximum value.
     * @param default Default value. Cannot be set when required.
     * @param array Is attribute an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createFloatAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        min: Double? = null,
        max: Double? = null,
        default: Double? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeFloat {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/float"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array,
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
            responseType = io.appwrite.models.AttributeFloat::class,
            serializer = io.appwrite.models.AttributeFloat.serializer()
        )
    }

    /**
     * Update float attribute
     *
     * Update a float attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value. Cannot be set when required.
     * @param min Minimum value.
     * @param max Maximum value.
     * @param newKey New Attribute Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateFloatAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Double? = null,
        min: Double? = null,
        max: Double? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeFloat {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/float/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeFloat::class,
            serializer = io.appwrite.models.AttributeFloat.serializer()
        )
    }

    /**
     * Create integer attribute
     *
     * Create an integer attribute. Optionally, minimum and maximum values can be provided.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param min Minimum value
     * @param max Maximum value
     * @param default Default value. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createIntegerAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        min: Long? = null,
        max: Long? = null,
        default: Long? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeInteger {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/integer"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "array" to array,
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
            responseType = io.appwrite.models.AttributeInteger::class,
            serializer = io.appwrite.models.AttributeInteger.serializer()
        )
    }

    /**
     * Update integer attribute
     *
     * Update an integer attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value. Cannot be set when attribute is required.
     * @param min Minimum value
     * @param max Maximum value
     * @param newKey New Attribute Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateIntegerAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: Long? = null,
        min: Long? = null,
        max: Long? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeInteger {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/integer/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "min" to min,
            "max" to max,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeInteger::class,
            serializer = io.appwrite.models.AttributeInteger.serializer()
        )
    }

    /**
     * Create IP address attribute
     *
     * Create IP address attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createIpAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeIp {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/ip"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
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
            responseType = io.appwrite.models.AttributeIp::class,
            serializer = io.appwrite.models.AttributeIp.serializer()
        )
    }

    /**
     * Update IP address attribute
     *
     * Update an ip attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value. Cannot be set when attribute is required.
     * @param newKey New Attribute Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateIpAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeIp {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/ip/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeIp::class,
            serializer = io.appwrite.models.AttributeIp.serializer()
        )
    }

    /**
     * Create line attribute
     *
     * Create a geometric line attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, two-dimensional array of coordinate pairs, [[longitude, latitude], [longitude, latitude], …], listing the vertices of the line in order. Cannot be set when attribute is required.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createLineAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.AttributeLine {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/line"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
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
            responseType = io.appwrite.models.AttributeLine::class,
            serializer = io.appwrite.models.AttributeLine.serializer()
        )
    }

    /**
     * Update line attribute
     *
     * Update a line attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, two-dimensional array of coordinate pairs, [[longitude, latitude], [longitude, latitude], …], listing the vertices of the line in order. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateLineAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeLine {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/line/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeLine::class,
            serializer = io.appwrite.models.AttributeLine.serializer()
        )
    }

    /**
     * Create point attribute
     *
     * Create a geometric point attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, array of two numbers [longitude, latitude], representing a single coordinate. Cannot be set when attribute is required.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createPointAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.AttributePoint {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/point"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
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
            responseType = io.appwrite.models.AttributePoint::class,
            serializer = io.appwrite.models.AttributePoint.serializer()
        )
    }

    /**
     * Update point attribute
     *
     * Update a point attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, array of two numbers [longitude, latitude], representing a single coordinate. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updatePointAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributePoint {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/point/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributePoint::class,
            serializer = io.appwrite.models.AttributePoint.serializer()
        )
    }

    /**
     * Create polygon attribute
     *
     * Create a geometric polygon attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, three-dimensional array where the outer array holds one or more linear rings, [[[longitude, latitude], …], …], the first ring is the exterior boundary, any additional rings are interior holes, and each ring must start and end with the same coordinate pair. Cannot be set when attribute is required.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createPolygonAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.AttributePolygon {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/polygon"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
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
            responseType = io.appwrite.models.AttributePolygon::class,
            serializer = io.appwrite.models.AttributePolygon.serializer()
        )
    }

    /**
     * Update polygon attribute
     *
     * Update a polygon attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#createCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided, three-dimensional array where the outer array holds one or more linear rings, [[[longitude, latitude], …], …], the first ring is the exterior boundary, any additional rings are interior holes, and each ring must start and end with the same coordinate pair. Cannot be set when attribute is required.
     * @param newKey New attribute key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updatePolygonAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributePolygon {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/polygon/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributePolygon::class,
            serializer = io.appwrite.models.AttributePolygon.serializer()
        )
    }

    /**
     * Create relationship attribute
     *
     * Create relationship attribute. [Learn more about relationship attributes](https://appwrite.io/docs/databases-relationships#relationship-attributes).
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param relatedCollectionId Related Collection ID.
     * @param type Relation type
     * @param twoWay Is Two Way?
     * @param key Attribute Key.
     * @param twoWayKey Two Way Attribute Key.
     * @param onDelete Constraints option
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createRelationshipAttribute(
        databaseId: String,
        collectionId: String,
        relatedCollectionId: String,
        type: io.appwrite.enums.RelationshipType,
        twoWay: Boolean? = null,
        key: String? = null,
        twoWayKey: String? = null,
        onDelete: io.appwrite.enums.RelationMutate? = null,
    ): io.appwrite.models.AttributeRelationship {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/relationship"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "relatedCollectionId" to relatedCollectionId,
            "type" to type,
            "twoWay" to twoWay,
            "key" to key,
            "twoWayKey" to twoWayKey,
            "onDelete" to onDelete,
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
            responseType = io.appwrite.models.AttributeRelationship::class,
            serializer = io.appwrite.models.AttributeRelationship.serializer()
        )
    }

    /**
     * Create string attribute
     *
     * Create a string attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param size Attribute size for text attributes, in number of characters.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     * @param encrypt Toggle encryption for the attribute. Encryption enhances security by not storing any plain text values in the database. However, encrypted attributes cannot be queried.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createStringAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        size: Long,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
        encrypt: Boolean? = null,
    ): io.appwrite.models.AttributeString {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/string"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "size" to size,
            "required" to required,
            "default" to default,
            "array" to array,
            "encrypt" to encrypt,
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
            responseType = io.appwrite.models.AttributeString::class,
            serializer = io.appwrite.models.AttributeString.serializer()
        )
    }

    /**
     * Update string attribute
     *
     * Update a string attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param size Maximum size of the string attribute.
     * @param newKey New Attribute Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateStringAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        size: Long? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeString {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/string/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "size" to size,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeString::class,
            serializer = io.appwrite.models.AttributeString.serializer()
        )
    }

    /**
     * Create URL attribute
     *
     * Create a URL attribute.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param array Is attribute an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createUrlAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.AttributeUrl {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/url"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "required" to required,
            "default" to default,
            "array" to array,
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
            responseType = io.appwrite.models.AttributeUrl::class,
            serializer = io.appwrite.models.AttributeUrl.serializer()
        )
    }

    /**
     * Update URL attribute
     *
     * Update an url attribute. Changing the `default` value will not update already existing documents.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param required Is attribute required?
     * @param default Default value for attribute when not provided. Cannot be set when attribute is required.
     * @param newKey New Attribute Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateUrlAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeUrl {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/url/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "required" to required,
            "default" to default,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeUrl::class,
            serializer = io.appwrite.models.AttributeUrl.serializer()
        )
    }

    /**
     * Get attribute
     *
     * Get attribute by ID.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     */
    @Throws(Throwable::class)
    suspend fun getAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


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
            responseType = Any::class,
            serializer = DynamicLookupSerializer
        )
    }

    /**
     * Delete attribute
     *
     * Deletes an attribute.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     */
    @Throws(Throwable::class)
    suspend fun deleteAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/attributes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


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
     * Update relationship attribute
     *
     * Update relationship attribute. [Learn more about relationship attributes](https://appwrite.io/docs/databases-relationships#relationship-attributes).
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param key Attribute Key.
     * @param onDelete Constraints option
     * @param newKey New Attribute Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateRelationshipAttribute(
        databaseId: String,
        collectionId: String,
        key: String,
        onDelete: io.appwrite.enums.RelationMutate? = null,
        newKey: String? = null,
    ): io.appwrite.models.AttributeRelationship {
        val apiPath =
            "/databases/{databaseId}/collections/{collectionId}/attributes/{key}/relationship"
                .replace("{databaseId}", databaseId)
                .replace("{collectionId}", collectionId)
                .replace("{key}", key)


        val apiParams = mutableMapOf<String, Any?>(
            "onDelete" to onDelete,
            "newKey" to newKey,
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
            responseType = io.appwrite.models.AttributeRelationship::class,
            serializer = io.appwrite.models.AttributeRelationship.serializer()
        )
    }

    /**
     * List documents
     *
     * Get a list of all the user&#039;s documents in a given collection. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> listDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.DocumentList.serializer(actualSerializer)
        )
    }

    /**
     * List documents
     *
     * Get a list of all the user&#039;s documents in a given collection. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = listDocuments(
        databaseId,
        collectionId,
        queries,
        transactionId,
        total,
        nestedType = classOf(),
    )

    /**
     * createDocument
     *
     * Create a new Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> createDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "documentId" to documentId,
            "data" to json.encodeToString(actualSerializer, data as T),
            "permissions" to permissions,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.Document.serializer(actualSerializer)
        )
    }

    /**
     * createDocument
     *
     * Create a new Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documentId Document ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Document data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = createDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * createDocuments
     *
     * Create new Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documents Array of documents data as JSON objects.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> createDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "documents" to documents,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.DocumentList.serializer(actualSerializer)
        )
    }

    /**
     * createDocuments
     *
     * Create new Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection). Make sure to define attributes before creating documents.
     * @param documents Array of documents data as JSON objects.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        transactionId: String? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = createDocuments(
        databaseId,
        collectionId,
        documents,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * upsertDocuments
     *
     * Create or update Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documents Array of document data as JSON objects. May contain partial documents.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> upsertDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "documents" to documents,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.DocumentList.serializer(actualSerializer)
        )
    }

    /**
     * upsertDocuments
     *
     * Create or update Documents. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documents Array of document data as JSON objects. May contain partial documents.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun upsertDocuments(
        databaseId: String,
        collectionId: String,
        documents: List<Any>,
        transactionId: String? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = upsertDocuments(
        databaseId,
        collectionId,
        documents,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Update documents
     *
     * Update all documents that match your queries, if no queries are submitted then all documents are updated. You can pass only specific fields to be updated.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> updateDocuments(
        databaseId: String,
        collectionId: String,
        data: Any? = null,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to json.encodeToString(actualSerializer, data as T),
            "queries" to queries,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.DocumentList.serializer(actualSerializer)
        )
    }

    /**
     * Update documents
     *
     * Update all documents that match your queries, if no queries are submitted then all documents are updated. You can pass only specific fields to be updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateDocuments(
        databaseId: String,
        collectionId: String,
        data: Any? = null,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = updateDocuments(
        databaseId,
        collectionId,
        data,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Delete documents
     *
     * Bulk delete documents using queries, if no queries are passed then all documents are deleted.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> deleteDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.DocumentList<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.DocumentList.serializer(actualSerializer)
        )
    }

    /**
     * Delete documents
     *
     * Bulk delete documents using queries, if no queries are passed then all documents are deleted.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun deleteDocuments(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.DocumentList<Map<String, Any>> = deleteDocuments(
        databaseId,
        collectionId,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Get document
     *
     * Get a document by its unique ID. This endpoint response returns a JSON object with the document data.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> getDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
            "transactionId" to transactionId,
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )

        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = classOf(),
            serializer = io.appwrite.models.Document.serializer(actualSerializer)
        )
    }

    /**
     * Get document
     *
     * Get a document by its unique ID. This endpoint response returns a JSON object with the document data.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = getDocument(
        databaseId,
        collectionId,
        documentId,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * upsertDocument
     *
     * Create or update a Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include all required attributes of the document to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> upsertDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to json.encodeToString(actualSerializer, data as T),
            "permissions" to permissions,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.Document.serializer(actualSerializer)
        )
    }

    /**
     * upsertDocument
     *
     * Create or update a Document. Before using this route, you should create a new collection resource using either a [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include all required attributes of the document to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun upsertDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = upsertDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Update document
     *
     * Update a document by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> updateDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Document<T> {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "data" to json.encodeToString(actualSerializer, data as T),
            "permissions" to permissions,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.Document.serializer(actualSerializer)
        )
    }

    /**
     * Update document
     *
     * Update a document by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param data Document data as JSON object. Include only attribute and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = updateDocument(
        databaseId,
        collectionId,
        documentId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Delete document
     *
     * Delete a document by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param documentId Document ID.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun deleteDocument(
        databaseId: String,
        collectionId: String,
        documentId: String,
        transactionId: String? = null,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{documentId}", documentId)


        val apiParams = mutableMapOf<String, Any?>(
            "transactionId" to transactionId,
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
     * List document logs
     *
     * Get the document activity logs list by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listDocumentLogs(
        databaseId: String,
        collectionId: String,
        documentId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath =
            "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}/logs"
                .replace("{databaseId}", databaseId)
                .replace("{collectionId}", collectionId)
                .replace("{documentId}", documentId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
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
     * Decrement document attribute
     *
     * Decrement a specific attribute of a document by a given value.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param min Minimum value for the attribute. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> decrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Document<T> {
        val apiPath =
            "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}/{attribute}/decrement"
                .replace("{databaseId}", databaseId)
                .replace("{collectionId}", collectionId)
                .replace("{documentId}", documentId)
                .replace("{attribute}", attribute)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "min" to min,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.Document.serializer(actualSerializer)
        )
    }

    /**
     * Decrement document attribute
     *
     * Decrement a specific attribute of a document by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param min Minimum value for the attribute. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun decrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = decrementDocumentAttribute(
        databaseId,
        collectionId,
        documentId,
        attribute,
        value,
        min,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Increment document attribute
     *
     * Increment a specific attribute of a document by a given value.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param max Maximum value for the attribute. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> incrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Document<T> {
        val apiPath =
            "/databases/{databaseId}/collections/{collectionId}/documents/{documentId}/{attribute}/increment"
                .replace("{databaseId}", databaseId)
                .replace("{collectionId}", collectionId)
                .replace("{documentId}", documentId)
                .replace("{attribute}", attribute)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "value" to value,
            "max" to max,
            "transactionId" to transactionId,
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
            responseType = classOf(),
            serializer = io.appwrite.models.Document.serializer(actualSerializer)
        )
    }

    /**
     * Increment document attribute
     *
     * Increment a specific attribute of a document by a given value.
     *
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param documentId Document ID.
     * @param attribute Attribute key.
     * @param value Value to increment the attribute by. The value must be a number.
     * @param max Maximum value for the attribute. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun incrementDocumentAttribute(
        databaseId: String,
        collectionId: String,
        documentId: String,
        attribute: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Document<Map<String, Any>> = incrementDocumentAttribute(
        databaseId,
        collectionId,
        documentId,
        attribute,
        value,
        max,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * List indexes
     *
     * List indexes in the collection.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following attributes: key, type, status, attributes, error
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listIndexes(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.IndexList {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


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
            responseType = io.appwrite.models.IndexList::class,
            serializer = io.appwrite.models.IndexList.serializer()
        )
    }

    /**
     * Create index
     *
     * Creates an index on the attributes listed. Your index should include all the attributes you will query in a single request.Attributes can be `key`, `fulltext`, and `unique`.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     * @param type Index type.
     * @param attributes Array of attributes to index. Maximum of 100 attributes are allowed, each 32 characters long.
     * @param orders Array of index orders. Maximum of 100 orders are allowed.
     * @param lengths Length of index. Maximum of 100
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createIndex(
        databaseId: String,
        collectionId: String,
        key: String,
        type: io.appwrite.enums.IndexType,
        attributes: List<String>,
        orders: List<String>? = null,
        lengths: List<Long>? = null,
    ): io.appwrite.models.Index {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "type" to type,
            "attributes" to attributes,
            "orders" to orders,
            "lengths" to lengths,
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
            responseType = io.appwrite.models.Index::class,
            serializer = io.appwrite.models.Index.serializer()
        )
    }

    /**
     * Get index
     *
     * Get an index by its unique ID.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     */
    @Throws(Throwable::class)
    suspend fun getIndex(
        databaseId: String,
        collectionId: String,
        key: String,
    ): io.appwrite.models.Index {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


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
            responseType = io.appwrite.models.Index::class,
            serializer = io.appwrite.models.Index.serializer()
        )
    }

    /**
     * Delete index
     *
     * Delete an index.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID. You can create a new collection using the Database service [server integration](https://appwrite.io/docs/server/databases#databasesCreateCollection).
     * @param key Index Key.
     */
    @Throws(Throwable::class)
    suspend fun deleteIndex(
        databaseId: String,
        collectionId: String,
        key: String,
    ): Any {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/indexes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)
            .replace("{key}", key)


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
     * List collection logs
     *
     * Get the collection activity logs list by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listCollectionLogs(
        databaseId: String,
        collectionId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/logs"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
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
     * Get collection usage stats
     *
     * Get usage metrics and statistics for a collection. Returning the total number of documents. The response includes both current totals and historical data over time. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, range defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param collectionId Collection ID.
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getCollectionUsage(
        databaseId: String,
        collectionId: String,
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageCollection {
        val apiPath = "/databases/{databaseId}/collections/{collectionId}/usage"
            .replace("{databaseId}", databaseId)
            .replace("{collectionId}", collectionId)


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
            responseType = io.appwrite.models.UsageCollection::class,
            serializer = io.appwrite.models.UsageCollection.serializer()
        )
    }

    /**
     * listLogs
     *
     * Get the database activity logs list by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listLogs(
        databaseId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/databases/{databaseId}/logs"
            .replace("{databaseId}", databaseId)


        val apiParams = mutableMapOf<String, Any?>(
            "queries" to queries,
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
     * getUsage
     *
     * Get usage metrics and statistics for a database. You can view the total number of collections, documents, and storage usage. The response includes both current totals and historical data over time. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, range defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getUsage(
        databaseId: String,
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageDatabase {
        val apiPath = "/databases/{databaseId}/usage"
            .replace("{databaseId}", databaseId)


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
            responseType = io.appwrite.models.UsageDatabase::class,
            serializer = io.appwrite.models.UsageDatabase.serializer()
        )
    }

}
