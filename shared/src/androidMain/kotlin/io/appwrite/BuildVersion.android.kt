package io.appwrite

import android.os.Build

actual fun BuildVersion(): Int {
    return Build.VERSION.SDK_INT
}