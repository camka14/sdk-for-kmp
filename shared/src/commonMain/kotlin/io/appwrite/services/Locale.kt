package io.appwrite.services

import io.appwrite.Client
import io.appwrite.Service
import io.appwrite.models.*
import io.appwrite.enums.*

/**
 * The Locale service allows you to customize your app based on your users&#039; location.
**/
class Locale(client: Client) : Service(client) {

    /**
     * Get user locale
     *
     * Get the current user location based on IP. Returns an object with user country code, country name, continent name, continent code, ip address and suggested currency. You can use the locale header to get the data in a supported language.([IP Geolocation by DB-IP](https://db-ip.com))
     *
     * @return [Locale]
     */
    suspend fun get(
    ): io.appwrite.models.Locale {
        val apiPath = "/locale"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> io.appwrite.models.Locale = {
            @Suppress("UNCHECKED_CAST")
            io.appwrite.models.Locale.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = io.appwrite.models.Locale::class,
            converter,
        )
    }


    /**
     * List Locale Codes
     *
     * List of all locale codes in [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes).
     *
     * @return [LocaleCodeList]
     */
    suspend fun listCodes(
    ): LocaleCodeList {
        val apiPath = "/locale/codes"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> LocaleCodeList = {
            @Suppress("UNCHECKED_CAST")
            LocaleCodeList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = LocaleCodeList::class,
            converter,
        )
    }


    /**
     * List continents
     *
     * List of all continents. You can use the locale header to get the data in a supported language.
     *
     * @return [ContinentList]
     */
    suspend fun listContinents(
    ): ContinentList {
        val apiPath = "/locale/continents"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> ContinentList = {
            @Suppress("UNCHECKED_CAST")
            ContinentList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = ContinentList::class,
            converter,
        )
    }


    /**
     * List countries
     *
     * List of all countries. You can use the locale header to get the data in a supported language.
     *
     * @return [CountryList]
     */
    suspend fun listCountries(
    ): CountryList {
        val apiPath = "/locale/countries"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> CountryList = {
            @Suppress("UNCHECKED_CAST")
            CountryList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = CountryList::class,
            converter,
        )
    }


    /**
     * List EU countries
     *
     * List of all countries that are currently members of the EU. You can use the locale header to get the data in a supported language.
     *
     * @return [CountryList]
     */
    suspend fun listCountriesEU(
    ): CountryList {
        val apiPath = "/locale/countries/eu"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> CountryList = {
            @Suppress("UNCHECKED_CAST")
            CountryList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = CountryList::class,
            converter,
        )
    }


    /**
     * List countries phone codes
     *
     * List of all countries phone codes. You can use the locale header to get the data in a supported language.
     *
     * @return [PhoneList]
     */
    suspend fun listCountriesPhones(
    ): PhoneList {
        val apiPath = "/locale/countries/phones"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> PhoneList = {
            @Suppress("UNCHECKED_CAST")
            PhoneList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = PhoneList::class,
            converter,
        )
    }


    /**
     * List currencies
     *
     * List of all currencies, including currency symbol, name, plural, and decimal digits for all major and minor currencies. You can use the locale header to get the data in a supported language.
     *
     * @return [CurrencyList]
     */
    suspend fun listCurrencies(
    ): CurrencyList {
        val apiPath = "/locale/currencies"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> CurrencyList = {
            @Suppress("UNCHECKED_CAST")
            CurrencyList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = CurrencyList::class,
            converter,
        )
    }


    /**
     * List languages
     *
     * List of all languages classified by ISO 639-1 including 2-letter code, name in English, and name in the respective language.
     *
     * @return [LanguageList]
     */
    suspend fun listLanguages(
    ): LanguageList {
        val apiPath = "/locale/languages"

        val apiParams = mutableMapOf<String, Any?>(
        )
        val apiHeaders = mutableMapOf(
            "content-type" to "application/json",
        )
        val converter: (Any) -> LanguageList = {
            @Suppress("UNCHECKED_CAST")
            LanguageList.from(map = it as Map<String, Any>)
        }
        return client.call(
            "GET",
            apiPath,
            apiHeaders,
            apiParams,
            responseType = LanguageList::class,
            converter,
        )
    }


}