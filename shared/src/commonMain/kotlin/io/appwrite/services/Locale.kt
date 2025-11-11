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

/**
 * The Locale service allows you to customize your app based on your users&#039; location.
 **/
class Locale(client: Client) : Service(client) {
        /**
     * Get user locale
     *
     * Get the current user location based on IP. Returns an object with user country code, country name, continent name, continent code, ip address and suggested currency. You can use the locale header to get the data in a supported language.([IP Geolocation by DB-IP](https://db-ip.com))
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun get(
    ): io.appwrite.models.Locale {
        val apiPath = "/locale"


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
            responseType = io.appwrite.models.Locale::class,
            serializer = io.appwrite.models.Locale.serializer()
        )
    }

            /**
     * List locale codes
     *
     * List of all locale codes in [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listCodes(
    ): io.appwrite.models.LocaleCodeList {
        val apiPath = "/locale/codes"


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
            responseType = io.appwrite.models.LocaleCodeList::class,
            serializer = io.appwrite.models.LocaleCodeList.serializer()
        )
    }

            /**
     * List continents
     *
     * List of all continents. You can use the locale header to get the data in a supported language.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listContinents(
    ): io.appwrite.models.ContinentList {
        val apiPath = "/locale/continents"


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
            responseType = io.appwrite.models.ContinentList::class,
            serializer = io.appwrite.models.ContinentList.serializer()
        )
    }

            /**
     * List countries
     *
     * List of all countries. You can use the locale header to get the data in a supported language.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listCountries(
    ): io.appwrite.models.CountryList {
        val apiPath = "/locale/countries"


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
            responseType = io.appwrite.models.CountryList::class,
            serializer = io.appwrite.models.CountryList.serializer()
        )
    }

            /**
     * List EU countries
     *
     * List of all countries that are currently members of the EU. You can use the locale header to get the data in a supported language.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listCountriesEU(
    ): io.appwrite.models.CountryList {
        val apiPath = "/locale/countries/eu"


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
            responseType = io.appwrite.models.CountryList::class,
            serializer = io.appwrite.models.CountryList.serializer()
        )
    }

            /**
     * List countries phone codes
     *
     * List of all countries phone codes. You can use the locale header to get the data in a supported language.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listCountriesPhones(
    ): io.appwrite.models.PhoneList {
        val apiPath = "/locale/countries/phones"


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
            responseType = io.appwrite.models.PhoneList::class,
            serializer = io.appwrite.models.PhoneList.serializer()
        )
    }

            /**
     * List currencies
     *
     * List of all currencies, including currency symbol, name, plural, and decimal digits for all major and minor currencies. You can use the locale header to get the data in a supported language.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listCurrencies(
    ): io.appwrite.models.CurrencyList {
        val apiPath = "/locale/currencies"


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
            responseType = io.appwrite.models.CurrencyList::class,
            serializer = io.appwrite.models.CurrencyList.serializer()
        )
    }

            /**
     * List languages
     *
     * List of all languages classified by ISO 639-1 including 2-letter code, name in English, and name in the respective language.
     *
    @Throws(Throwable::class)
     */
    @Throws(Throwable::class)
    suspend fun listLanguages(
    ): io.appwrite.models.LanguageList {
        val apiPath = "/locale/languages"


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
            responseType = io.appwrite.models.LanguageList::class,
            serializer = io.appwrite.models.LanguageList.serializer()
        )
    }

    }
