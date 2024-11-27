package io.appwrite.cookies.stores

actual class KeyValueStorage(
    private val userDefaults: NSUserDefaults = NSUserDefaults.standardUserDefaults
)  {
    actual fun getAll(): Map<String, Any?> =
        userDefaults.dictionaryRepresentation().toMap()

    actual fun putString(key: String, value: String) {
        userDefaults.setObject(value, key)
    }

    actual fun remove(key: String) {
        userDefaults.removeObjectForKey(key)
    }

    actual fun clear() {
        userDefaults.dictionaryRepresentation().keys.forEach {
            userDefaults.removeObjectForKey(it)
        }
    }
}