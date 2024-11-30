package io.appwrite.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import io.appwrite.Client
import io.appwrite.services.Account

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val client = Client(applicationContext)
                .setProject("6656a4d60016b753f942")
                .setSelfSigned(true)
            val account = Account(client)
            var accountId by remember { mutableStateOf("") }

            LaunchedEffect(account) {
                try {
                    account.createEmailPasswordSession("", "")
                    accountId = account.get<Map<String, Any>>().id
                } catch (e: Exception) {
                    Log.e("Appwrite", e.toString())
                }
            }


            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Text(accountId)
                }
            }
        }
    }
}
