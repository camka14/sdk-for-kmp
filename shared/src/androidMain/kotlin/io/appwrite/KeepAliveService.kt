package io.appwrite

import android.app.Service
import android.content.Intent
import android.os.Binder

internal class KeepAliveService: Service() {
    companion object {
      val binder = Binder()
    }

    override fun onBind(intent: Intent) = binder
}
