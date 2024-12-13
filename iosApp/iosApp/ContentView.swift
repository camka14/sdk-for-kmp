import SwiftUI
import shared

struct ContentView: View {
    @State private var accountId = ""
    @State private var documentId = ""
    @State private var realtimeId = ""
    
    let client: Client
    let account: Account
    let databases: Databases
    let realtime: Realtime
    
    init() {
        client = Client(
            endpoint: "",
            endpointRealtime: nil,
            selfSigned: false
        )
            .setEndpoint(endpoint: "https://cloud.appwrite.io/v1")
            .setProject(value: "6656a4d60016b753f942")
            .setSelfSigned(value: true)
        account = Account(client: client)
        databases = Databases(client: client)
        realtime = Realtime(client: client)
    }
    
    var body: some View {
        VStack {
            Text(accountId)
            Text(documentId)
            Text(realtimeId)
        }
        .onAppear {
            Task {
                do {
                    let session = try await account.createEmailPasswordSession(email: "camka14@gmail.com", password: "Zenit1925")
                    print("Session created: \(session.id)")
                    client.setSession(value: session.secret)
                    let user = try await account.get()
                    accountId = user.id
                    
                    let documents = try await databases.listDocuments(
                        databaseId: "mvp",
                        collectionId: "matches",
                        queries: [
                            Query.companion.equal(attribute: "matchId", value: 1)
                        ]
                    )
                    if let firstDocument = documents.documents.first {
                        documentId = firstDocument.id
                    }
                    
                    let subscription = realtime.subscribe(
                        channels: ["databases.mvp.collections.matches.documents"],
                        payloadType: MatchDTO.self as AnyObject as! KotlinKClass,
                        payloadSerializer: nil
                    ) { response in
                        if let payload = response.payload as? Document<MatchDTO>,
                           let matchData = payload.data {
                            realtimeId = String(matchData.matchId)
                        }
                    }

                } catch {
                    print("Appwrite error: \(error)")
                }
            }
        }
    }
}
