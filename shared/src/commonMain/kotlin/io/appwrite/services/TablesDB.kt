package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.extensions.*
import io.appwrite.serializers.*
import kotlinx.serialization.KSerializer
import kotlin.reflect.KClass

/**
 *
 **/
class TablesDB(client: Client) : Service(client) {
    /**
     * List databases
     *
     * Get a list of all databases from the current Appwrite project. You can use the search parameter to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following columns: name
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
        val apiPath = "/tablesdb"


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
     * Create database
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
        val apiPath = "/tablesdb"


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
        val apiPath = "/tablesdb/transactions"


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
        val apiPath = "/tablesdb/transactions"


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
        val apiPath = "/tablesdb/transactions/{transactionId}"
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
        val apiPath = "/tablesdb/transactions/{transactionId}"
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
        val apiPath = "/tablesdb/transactions/{transactionId}"
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
        val apiPath = "/tablesdb/transactions/{transactionId}/operations"
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
     * List usage metrics and statistics for all databases in the project. You can view the total number of databases, tables, rows, and storage usage. The response includes both current totals and historical data over time. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, range defaults to 30 days.
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
        val apiPath = "/tablesdb/usage"


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
     * Get database
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
        val apiPath = "/tablesdb/{databaseId}"
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
     * Update database
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
        val apiPath = "/tablesdb/{databaseId}"
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
     * Delete database
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
        val apiPath = "/tablesdb/{databaseId}"
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
     * List tables
     *
     * Get a list of all tables that belong to the provided databaseId. You can use the search parameter to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following columns: name, enabled, rowSecurity
     * @param search Search term to filter your list results. Max length: 256 chars.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listTables(
        databaseId: String,
        queries: List<String>? = null,
        search: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.TableList {
        val apiPath = "/tablesdb/{databaseId}/tables"
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
            responseType = io.appwrite.models.TableList::class,
            serializer = io.appwrite.models.TableList.serializer()
        )
    }

    /**
     * Create table
     *
     * Create a new Table. Before using this route, you should create a new database resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Unique Id. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param name Table name. Max length: 128 chars.
     * @param permissions An array of permissions strings. By default, no user is granted with any permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param rowSecurity Enables configuring permissions for individual rows. A user needs one of row or table level permissions to access a row. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is table enabled? When set to 'disabled', users cannot access the table but Server SDKs with and API key can still read and write to the table. No data is lost when this is toggled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createTable(
        databaseId: String,
        tableId: String,
        name: String,
        permissions: List<String>? = null,
        rowSecurity: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Table {
        val apiPath = "/tablesdb/{databaseId}/tables"
            .replace("{databaseId}", databaseId)


        val apiParams = mutableMapOf<String, Any?>(
            "tableId" to tableId,
            "name" to name,
            "permissions" to permissions,
            "rowSecurity" to rowSecurity,
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
            responseType = io.appwrite.models.Table::class,
            serializer = io.appwrite.models.Table.serializer()
        )
    }

    /**
     * Get table
     *
     * Get a table by its unique ID. This endpoint response returns a JSON object with the table metadata.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     */
    @Throws(Throwable::class)
    suspend fun getTable(
        databaseId: String,
        tableId: String,
    ): io.appwrite.models.Table {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.Table::class,
            serializer = io.appwrite.models.Table.serializer()
        )
    }

    /**
     * Update table
     *
     * Update a table by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param name Table name. Max length: 128 chars.
     * @param permissions An array of permission strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param rowSecurity Enables configuring permissions for individual rows. A user needs one of row or table level permissions to access a document. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param enabled Is table enabled? When set to 'disabled', users cannot access the table but Server SDKs with and API key can still read and write to the table. No data is lost when this is toggled.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateTable(
        databaseId: String,
        tableId: String,
        name: String,
        permissions: List<String>? = null,
        rowSecurity: Boolean? = null,
        enabled: Boolean? = null,
    ): io.appwrite.models.Table {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


        val apiParams = mutableMapOf<String, Any?>(
            "name" to name,
            "permissions" to permissions,
            "rowSecurity" to rowSecurity,
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
            responseType = io.appwrite.models.Table::class,
            serializer = io.appwrite.models.Table.serializer()
        )
    }

    /**
     * Delete table
     *
     * Delete a table by its unique ID. Only users with write permissions have access to delete this resource.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     */
    @Throws(Throwable::class)
    suspend fun deleteTable(
        databaseId: String,
        tableId: String,
    ): Any {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
     * List columns
     *
     * List columns in the table.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following columns: key, type, size, required, array, status, error
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listColumns(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ColumnList {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnList::class,
            serializer = io.appwrite.models.ColumnList.serializer()
        )
    }

    /**
     * Create boolean column
     *
     * Create a boolean column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createBooleanColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnBoolean {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/boolean"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnBoolean::class,
            serializer = io.appwrite.models.ColumnBoolean.serializer()
        )
    }

    /**
     * Update boolean column
     *
     * Update a boolean column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateBooleanColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: Boolean? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnBoolean {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/boolean/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnBoolean::class,
            serializer = io.appwrite.models.ColumnBoolean.serializer()
        )
    }

    /**
     * Create datetime column
     *
     * Create a date time column according to the ISO 8601 standard.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for the column in [ISO 8601](https://www.iso.org/iso-8601-date-and-time-format.html) format. Cannot be set when column is required.
     * @param array Is column an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createDatetimeColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnDatetime {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/datetime"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnDatetime::class,
            serializer = io.appwrite.models.ColumnDatetime.serializer()
        )
    }

    /**
     * Update dateTime column
     *
     * Update a date time column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateDatetimeColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnDatetime {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/datetime/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnDatetime::class,
            serializer = io.appwrite.models.ColumnDatetime.serializer()
        )
    }

    /**
     * Create email column
     *
     * Create an email column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createEmailColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnEmail {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/email"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnEmail::class,
            serializer = io.appwrite.models.ColumnEmail.serializer()
        )
    }

    /**
     * Update email column
     *
     * Update an email column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateEmailColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnEmail {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/email/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnEmail::class,
            serializer = io.appwrite.models.ColumnEmail.serializer()
        )
    }

    /**
     * Create enum column
     *
     * Create an enumeration column. The `elements` param acts as a white-list of accepted values for this column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param elements Array of enum values.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createEnumColumn(
        databaseId: String,
        tableId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnEnum {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/enum"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnEnum::class,
            serializer = io.appwrite.models.ColumnEnum.serializer()
        )
    }

    /**
     * Update enum column
     *
     * Update an enum column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param elements Updated list of enum values.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateEnumColumn(
        databaseId: String,
        tableId: String,
        key: String,
        elements: List<String>,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnEnum {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/enum/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnEnum::class,
            serializer = io.appwrite.models.ColumnEnum.serializer()
        )
    }

    /**
     * Create float column
     *
     * Create a float column. Optionally, minimum and maximum values can be provided.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param min Minimum value
     * @param max Maximum value
     * @param default Default value. Cannot be set when required.
     * @param array Is column an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createFloatColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        min: Double? = null,
        max: Double? = null,
        default: Double? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnFloat {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/float"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnFloat::class,
            serializer = io.appwrite.models.ColumnFloat.serializer()
        )
    }

    /**
     * Update float column
     *
     * Update a float column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value. Cannot be set when required.
     * @param min Minimum value
     * @param max Maximum value
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateFloatColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: Double? = null,
        min: Double? = null,
        max: Double? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnFloat {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/float/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnFloat::class,
            serializer = io.appwrite.models.ColumnFloat.serializer()
        )
    }

    /**
     * Create integer column
     *
     * Create an integer column. Optionally, minimum and maximum values can be provided.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param min Minimum value
     * @param max Maximum value
     * @param default Default value. Cannot be set when column is required.
     * @param array Is column an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createIntegerColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        min: Long? = null,
        max: Long? = null,
        default: Long? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnInteger {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/integer"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnInteger::class,
            serializer = io.appwrite.models.ColumnInteger.serializer()
        )
    }

    /**
     * Update integer column
     *
     * Update an integer column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value. Cannot be set when column is required.
     * @param min Minimum value
     * @param max Maximum value
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateIntegerColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: Long? = null,
        min: Long? = null,
        max: Long? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnInteger {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/integer/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnInteger::class,
            serializer = io.appwrite.models.ColumnInteger.serializer()
        )
    }

    /**
     * Create IP address column
     *
     * Create IP address column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value. Cannot be set when column is required.
     * @param array Is column an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createIpColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnIp {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/ip"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnIp::class,
            serializer = io.appwrite.models.ColumnIp.serializer()
        )
    }

    /**
     * Update IP address column
     *
     * Update an ip column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateIpColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnIp {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/ip/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnIp::class,
            serializer = io.appwrite.models.ColumnIp.serializer()
        )
    }

    /**
     * Create line column
     *
     * Create a geometric line column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided, two-dimensional array of coordinate pairs, [[longitude, latitude], [longitude, latitude], …], listing the vertices of the line in order. Cannot be set when column is required.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createLineColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.ColumnLine {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/line"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnLine::class,
            serializer = io.appwrite.models.ColumnLine.serializer()
        )
    }

    /**
     * Update line column
     *
     * Update a line column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided, two-dimensional array of coordinate pairs, [[longitude, latitude], [longitude, latitude], …], listing the vertices of the line in order. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateLineColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnLine {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/line/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnLine::class,
            serializer = io.appwrite.models.ColumnLine.serializer()
        )
    }

    /**
     * Create point column
     *
     * Create a geometric point column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided, array of two numbers [longitude, latitude], representing a single coordinate. Cannot be set when column is required.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createPointColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.ColumnPoint {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/point"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnPoint::class,
            serializer = io.appwrite.models.ColumnPoint.serializer()
        )
    }

    /**
     * Update point column
     *
     * Update a point column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided, array of two numbers [longitude, latitude], representing a single coordinate. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updatePointColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnPoint {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/point/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnPoint::class,
            serializer = io.appwrite.models.ColumnPoint.serializer()
        )
    }

    /**
     * Create polygon column
     *
     * Create a geometric polygon column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided, three-dimensional array where the outer array holds one or more linear rings, [[[longitude, latitude], …], …], the first ring is the exterior boundary, any additional rings are interior holes, and each ring must start and end with the same coordinate pair. Cannot be set when column is required.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createPolygonColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
    ): io.appwrite.models.ColumnPolygon {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/polygon"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnPolygon::class,
            serializer = io.appwrite.models.ColumnPolygon.serializer()
        )
    }

    /**
     * Update polygon column
     *
     * Update a polygon column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided, three-dimensional array where the outer array holds one or more linear rings, [[[longitude, latitude], …], …], the first ring is the exterior boundary, any additional rings are interior holes, and each ring must start and end with the same coordinate pair. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updatePolygonColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: List<Any>? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnPolygon {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/polygon/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnPolygon::class,
            serializer = io.appwrite.models.ColumnPolygon.serializer()
        )
    }

    /**
     * Create relationship column
     *
     * Create relationship column. [Learn more about relationship columns](https://appwrite.io/docs/databases-relationships#relationship-columns).
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param relatedTableId Related Table ID.
     * @param type Relation type
     * @param twoWay Is Two Way?
     * @param key Column Key.
     * @param twoWayKey Two Way Column Key.
     * @param onDelete Constraints option
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createRelationshipColumn(
        databaseId: String,
        tableId: String,
        relatedTableId: String,
        type: io.appwrite.enums.RelationshipType,
        twoWay: Boolean? = null,
        key: String? = null,
        twoWayKey: String? = null,
        onDelete: io.appwrite.enums.RelationMutate? = null,
    ): io.appwrite.models.ColumnRelationship {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/relationship"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


        val apiParams = mutableMapOf<String, Any?>(
            "relatedTableId" to relatedTableId,
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
            responseType = io.appwrite.models.ColumnRelationship::class,
            serializer = io.appwrite.models.ColumnRelationship.serializer()
        )
    }

    /**
     * Create string column
     *
     * Create a string column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param size Column size for text columns, in number of characters.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     * @param encrypt Toggle encryption for the column. Encryption enhances security by not storing any plain text values in the database. However, encrypted columns cannot be queried.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createStringColumn(
        databaseId: String,
        tableId: String,
        key: String,
        size: Long,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
        encrypt: Boolean? = null,
    ): io.appwrite.models.ColumnString {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/string"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnString::class,
            serializer = io.appwrite.models.ColumnString.serializer()
        )
    }

    /**
     * Update string column
     *
     * Update a string column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param size Maximum size of the string column.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateStringColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        size: Long? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnString {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/string/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnString::class,
            serializer = io.appwrite.models.ColumnString.serializer()
        )
    }

    /**
     * Create URL column
     *
     * Create a URL column.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param array Is column an array?
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createUrlColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        array: Boolean? = null,
    ): io.appwrite.models.ColumnUrl {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/url"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnUrl::class,
            serializer = io.appwrite.models.ColumnUrl.serializer()
        )
    }

    /**
     * Update URL column
     *
     * Update an url column. Changing the `default` value will not update already existing rows.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param required Is column required?
     * @param default Default value for column when not provided. Cannot be set when column is required.
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateUrlColumn(
        databaseId: String,
        tableId: String,
        key: String,
        required: Boolean,
        default: String? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnUrl {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/url/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnUrl::class,
            serializer = io.appwrite.models.ColumnUrl.serializer()
        )
    }

    /**
     * Get column
     *
     * Get column by ID.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     */
    @Throws(Throwable::class)
    suspend fun getColumn(
        databaseId: String,
        tableId: String,
        key: String,
    ): Any {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
     * Delete column
     *
     * Deletes a column.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     */
    @Throws(Throwable::class)
    suspend fun deleteColumn(
        databaseId: String,
        tableId: String,
        key: String,
    ): Any {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
     * Update relationship column
     *
     * Update relationship column. [Learn more about relationship columns](https://appwrite.io/docs/databases-relationships#relationship-columns).
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param key Column Key.
     * @param onDelete Constraints option
     * @param newKey New Column Key.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateRelationshipColumn(
        databaseId: String,
        tableId: String,
        key: String,
        onDelete: io.appwrite.enums.RelationMutate? = null,
        newKey: String? = null,
    ): io.appwrite.models.ColumnRelationship {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/columns/{key}/relationship"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnRelationship::class,
            serializer = io.appwrite.models.ColumnRelationship.serializer()
        )
    }

    /**
     * List indexes
     *
     * List indexes on the table.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long. You may filter on the following columns: key, type, status, attributes, error
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listIndexes(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        total: Boolean? = null,
    ): io.appwrite.models.ColumnIndexList {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.ColumnIndexList::class,
            serializer = io.appwrite.models.ColumnIndexList.serializer()
        )
    }

    /**
     * Create index
     *
     * Creates an index on the columns listed. Your index should include all the columns you will query in a single request.Type can be `key`, `fulltext`, or `unique`.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Index Key.
     * @param type Index type.
     * @param columns Array of columns to index. Maximum of 100 columns are allowed, each 32 characters long.
     * @param orders Array of index orders. Maximum of 100 orders are allowed.
     * @param lengths Length of index. Maximum of 100
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createIndex(
        databaseId: String,
        tableId: String,
        key: String,
        type: io.appwrite.enums.IndexType,
        columns: List<String>,
        orders: List<String>? = null,
        lengths: List<Long>? = null,
    ): io.appwrite.models.ColumnIndex {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/indexes"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


        val apiParams = mutableMapOf<String, Any?>(
            "key" to key,
            "type" to type,
            "columns" to columns,
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
            responseType = io.appwrite.models.ColumnIndex::class,
            serializer = io.appwrite.models.ColumnIndex.serializer()
        )
    }

    /**
     * Get index
     *
     * Get index by ID.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Index Key.
     */
    @Throws(Throwable::class)
    suspend fun getIndex(
        databaseId: String,
        tableId: String,
        key: String,
    ): io.appwrite.models.ColumnIndex {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/indexes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
            responseType = io.appwrite.models.ColumnIndex::class,
            serializer = io.appwrite.models.ColumnIndex.serializer()
        )
    }

    /**
     * Delete index
     *
     * Delete an index.
     *
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param key Index Key.
     */
    @Throws(Throwable::class)
    suspend fun deleteIndex(
        databaseId: String,
        tableId: String,
        key: String,
    ): Any {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/indexes/{key}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
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
     * List table logs
     *
     * Get the table activity logs list by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listTableLogs(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/logs"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
     * List rows
     *
     * Get a list of all the user&#039;s rows in a given table. You can use the query params to filter your results.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/products/databases/tables#create-table).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> listRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

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
            serializer = io.appwrite.models.RowList.serializer(actualSerializer)
        )
    }

    /**
     * List rows
     *
     * Get a list of all the user&#039;s rows in a given table. You can use the query params to filter your results.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the TablesDB service [server integration](https://appwrite.io/docs/products/databases/tables#create-table).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     * @param total When set to false, the total count returned will be 0 and will not be calculated.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        total: Boolean? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = listRows(
        databaseId,
        tableId,
        queries,
        transactionId,
        total,
        nestedType = classOf(),
    )

    /**
     * createRow
     *
     * Create a new Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable). Make sure to define columns before creating rows.
     * @param rowId Row ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Row data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> createRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "rowId" to rowId,
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
            serializer = io.appwrite.models.Row.serializer(actualSerializer)
        )
    }

    /**
     * createRow
     *
     * Create a new Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable). Make sure to define columns before creating rows.
     * @param rowId Row ID. Choose a custom ID or generate a random ID with `ID.unique()`. Valid chars are a-z, A-Z, 0-9, period, hyphen, and underscore. Can't start with a special char. Max length is 36 chars.
     * @param data Row data as JSON object.
     * @param permissions An array of permissions strings. By default, only the current user is granted all permissions. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = createRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * createRows
     *
     * Create new Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable). Make sure to define columns before creating rows.
     * @param rows Array of rows data as JSON objects.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> createRows(
        databaseId: String,
        tableId: String,
        rows: List<Any>,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "rows" to rows,
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
            serializer = io.appwrite.models.RowList.serializer(actualSerializer)
        )
    }

    /**
     * createRows
     *
     * Create new Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable). Make sure to define columns before creating rows.
     * @param rows Array of rows data as JSON objects.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun createRows(
        databaseId: String,
        tableId: String,
        rows: List<Any>,
        transactionId: String? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = createRows(
        databaseId,
        tableId,
        rows,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * upsertRows
     *
     * Create or update Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rows Array of row data as JSON objects. May contain partial rows.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> upsertRows(
        databaseId: String,
        tableId: String,
        rows: List<Any>,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

        val actualSerializer = genericSerializer ?: getSerializer(T::class)

        val apiParams = mutableMapOf<String, Any?>(
            "rows" to rows,
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
            serializer = io.appwrite.models.RowList.serializer(actualSerializer)
        )
    }

    /**
     * upsertRows
     *
     * Create or update Rows. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rows Array of row data as JSON objects. May contain partial rows.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun upsertRows(
        databaseId: String,
        tableId: String,
        rows: List<Any>,
        transactionId: String? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = upsertRows(
        databaseId,
        tableId,
        rows,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Update rows
     *
     * Update all rows that match your queries, if no queries are submitted then all rows are updated. You can pass only specific fields to be updated.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param data Row data as JSON object. Include only column and value pairs to be updated.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> updateRows(
        databaseId: String,
        tableId: String,
        data: Any? = null,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

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
            serializer = io.appwrite.models.RowList.serializer(actualSerializer)
        )
    }

    /**
     * Update rows
     *
     * Update all rows that match your queries, if no queries are submitted then all rows are updated. You can pass only specific fields to be updated.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param data Row data as JSON object. Include only column and value pairs to be updated.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateRows(
        databaseId: String,
        tableId: String,
        data: Any? = null,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = updateRows(
        databaseId,
        tableId,
        data,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Delete rows
     *
     * Bulk delete rows using queries, if no queries are passed then all rows are deleted.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> deleteRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.RowList<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)

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
            serializer = io.appwrite.models.RowList.serializer(actualSerializer)
        )
    }

    /**
     * Delete rows
     *
     * Bulk delete rows using queries, if no queries are passed then all rows are deleted.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun deleteRows(
        databaseId: String,
        tableId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.RowList<Map<String, Any>> = deleteRows(
        databaseId,
        tableId,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Get row
     *
     * Get a row by its unique ID. This endpoint response returns a JSON object with the row data.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param rowId Row ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> getRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

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
            serializer = io.appwrite.models.Row.serializer(actualSerializer)
        )
    }

    /**
     * Get row
     *
     * Get a row by its unique ID. This endpoint response returns a JSON object with the row data.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param rowId Row ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Maximum of 100 queries are allowed, each 4096 characters long.
     * @param transactionId Transaction ID to read uncommitted changes within the transaction.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = getRow(
        databaseId,
        tableId,
        rowId,
        queries,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * upsertRow
     *
     * Create or update a Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include all required columns of the row to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

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
            serializer = io.appwrite.models.Row.serializer(actualSerializer)
        )
    }

    /**
     * upsertRow
     *
     * Create or update a Row. Before using this route, you should create a new table resource using either a [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable) API or directly from your database console.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include all required columns of the row to be created or updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun upsertRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = upsertRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Update row
     *
     * Update a row by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include only columns and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> updateRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)

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
            serializer = io.appwrite.models.Row.serializer(actualSerializer)
        )
    }

    /**
     * Update row
     *
     * Update a row by its unique ID. Using the patch method you can pass only specific fields that will get updated.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param data Row data as JSON object. Include only columns and value pairs to be updated.
     * @param permissions An array of permissions strings. By default, the current permissions are inherited. [Learn more about permissions](https://appwrite.io/docs/permissions).
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun updateRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        data: Any? = null,
        permissions: List<String>? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = updateRow(
        databaseId,
        tableId,
        rowId,
        data,
        permissions,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Delete row
     *
     * Delete a row by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID. You can create a new table using the Database service [server integration](https://appwrite.io/docs/references/cloud/server-dart/tablesDB#createTable).
     * @param rowId Row ID.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun deleteRow(
        databaseId: String,
        tableId: String,
        rowId: String,
        transactionId: String? = null,
    ): Any {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)


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
     * List row logs
     *
     * Get the row activity logs list by its unique ID.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param queries Array of query strings generated using the Query class provided by the SDK. [Learn more about queries](https://appwrite.io/docs/queries). Only supported methods are limit and offset
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun listRowLogs(
        databaseId: String,
        tableId: String,
        rowId: String,
        queries: List<String>? = null,
    ): io.appwrite.models.LogList {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}/logs"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)


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
     * Decrement row column
     *
     * Decrement a specific column of a row by a given value.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param min Minimum value for the column. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> decrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}/{column}/decrement"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)
            .replace("{column}", column)

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
            serializer = io.appwrite.models.Row.serializer(actualSerializer)
        )
    }

    /**
     * Decrement row column
     *
     * Decrement a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param min Minimum value for the column. If the current value is lesser than this value, an exception will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun decrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        min: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = decrementRowColumn(
        databaseId,
        tableId,
        rowId,
        column,
        value,
        min,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Increment row column
     *
     * Increment a specific column of a row by a given value.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param max Maximum value for the column. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend inline fun <reified T : Any> incrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
        nestedType: KClass<T>?,
        genericSerializer: KSerializer<T>? = null,
    ): io.appwrite.models.Row<T> {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/rows/{rowId}/{column}/increment"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)
            .replace("{rowId}", rowId)
            .replace("{column}", column)

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
            serializer = io.appwrite.models.Row.serializer(actualSerializer)
        )
    }

    /**
     * Increment row column
     *
     * Increment a specific column of a row by a given value.
     *
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param rowId Row ID.
     * @param column Column key.
     * @param value Value to increment the column by. The value must be a number.
     * @param max Maximum value for the column. If the current value is greater than this value, an error will be thrown.
     * @param transactionId Transaction ID for staging the operation.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun incrementRowColumn(
        databaseId: String,
        tableId: String,
        rowId: String,
        column: String,
        value: Double? = null,
        max: Double? = null,
        transactionId: String? = null,
    ): io.appwrite.models.Row<Map<String, Any>> = incrementRowColumn(
        databaseId,
        tableId,
        rowId,
        column,
        value,
        max,
        transactionId,
        nestedType = classOf(),
    )

    /**
     * Get table usage stats
     *
     * Get usage metrics and statistics for a table. Returning the total number of rows. The response includes both current totals and historical data over time. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, range defaults to 30 days.
     *
    @JvmOverloads
    @Throws(Throwable::class)
     * @param databaseId Database ID.
     * @param tableId Table ID.
     * @param range Date range.
     */
    @Throws(Throwable::class)
    @JvmOverloads
    suspend fun getTableUsage(
        databaseId: String,
        tableId: String,
        range: io.appwrite.enums.UsageRange? = null,
    ): io.appwrite.models.UsageTable {
        val apiPath = "/tablesdb/{databaseId}/tables/{tableId}/usage"
            .replace("{databaseId}", databaseId)
            .replace("{tableId}", tableId)


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
            responseType = io.appwrite.models.UsageTable::class,
            serializer = io.appwrite.models.UsageTable.serializer()
        )
    }

    /**
     * getUsage
     *
     * Get usage metrics and statistics for a database. You can view the total number of tables, rows, and storage usage. The response includes both current totals and historical data over time. Use the optional range parameter to specify the time window for historical data: 24h (last 24 hours), 30d (last 30 days), or 90d (last 90 days). If not specified, range defaults to 30 days.
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
        val apiPath = "/tablesdb/{databaseId}/usage"
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
