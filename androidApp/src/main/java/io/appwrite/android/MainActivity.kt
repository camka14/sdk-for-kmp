package io.appwrite.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.appwrite.Client
import io.appwrite.ID
import io.appwrite.Query
import io.appwrite.models.DocumentList
import io.appwrite.services.Account
import io.appwrite.services.Databases
import io.appwrite.services.Realtime
import kotlinx.coroutines.launch
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val client = Client(applicationContext)
                .setEndpoint("https://cloud.appwrite.io/v1")
                .setProject("6656a4d60016b753f942")
                .setSelfSigned(true)
            val account = Account(client)
            val databases = Databases(client)
            val realtime = Realtime(client)
            var documents by remember { mutableStateOf(null as DocumentList<MatchDTO>?) }
            var accountId by remember { mutableStateOf("") }
            var documentTeam: String? by remember { mutableStateOf(null) }
            var realtimeId by remember { mutableStateOf("") }
            var team1: String? by remember { mutableStateOf(null) }
            val scope = rememberCoroutineScope()

            MyApplicationTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Button(onClick = {
                            scope.launch {
                                documents = performAppwriteOperations(
                                    account,
                                    databases,
                                    realtime,
                                    { accountId = it },
                                    { documentTeam = it.team1 },
                                    {
                                        realtimeId = it.matchId.toString()
                                        team1 = it.team1
                                    }
                                )
                            }
                        }) {
                            Text("Start Appwrite Operations")
                        }
                        Button(onClick = {
                            scope.launch {
                                documents?.let { updateMatch(databases, it) }
                            }
                        }
                        ) {
                            Text("Update Match")
                        }
                        Text(accountId)
                        documentTeam?.let { Text(it) }
                        Text(realtimeId)
                        team1?.let { Text(it) }
                    }
                }
            }
        }
    }
}

suspend fun performAppwriteOperations(
    account: Account,
    databases: Databases,
    realtime: Realtime,
    onAccountIdChange: (String) -> Unit,
    onDocumentIdChange: (MatchDTO) -> Unit,
    onRealtimeIdChange: (MatchDTO) -> Unit
): DocumentList<MatchDTO>? {
    val email = "temp@temp2.com"
    val password = "dsaf32f2223"
    val name = "Tester1"
    account.create(
        userId = ID.unique(),
        email = email,
        password = password,
        name = name
    )
    try {
        val session = account.createEmailPasswordSession(email, password)
        onAccountIdChange(account.get().id)
        println("session = ${session.id}")
        val token = account.createJWT()
        println("token = ${token}")

        val documents = databases.listDocuments(
            "mvp",
            "matches",
            nestedType = MatchDTO::class,
            queries = listOf(Query.equal("matchId", 1))
        )
        onDocumentIdChange(documents.documents.first().data)

        realtime.subscribe(
            listOf("databases.mvp.collections.matches.documents"),
            payloadType = MatchDTO::class
        ) { response ->
            onRealtimeIdChange(response.payload.data)
        }
        return documents
    } catch (e: Exception) {
        Log.e("Appwrite", e.toString())
        return null
    }
}

suspend fun updateMatch(
    databases: Databases,
    documents: DocumentList<MatchDTO>,

    ) {
    databases.updateDocument(
        "mvp",
        "matches",
        documents.documents.first().id,
        documents.documents.first().data.copy(refereeCheckedIn = true),
        nestedType = MatchDTO::class
    )
}


@Serializable
data class MatchDTO(
    @Transient
    val id: String = "",
    val matchId: Int,
    val team1: String?,
    val team2: String?,
    val tournament: String,
    val refId: String?,
    val field: String?,
    val start: String,
    val end: String?,
    val division: String,
    val team1Points: List<Int>,
    val team2Points: List<Int>,
    val losersBracket: Boolean,
    val winnerNextMatchId: String?,
    val loserNextMatchId: String?,
    val previousLeftId: String?,
    val previousRightId: String?,
    val setResults: List<Int>,
    val refereeCheckedIn: Boolean?,
)