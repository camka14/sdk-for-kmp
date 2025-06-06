import SwiftUI
import shared

struct ContentView: View {
    @State private var accountId = ""
    @State private var documentId = ""
    @State private var realtimeId = ""
    @State private var isLoading = false
    @State private var error: Error?

    private let client: Client
    private let account: Account
    private let databases: Databases
    private let realtime: Realtime

    init() {
        client = Client(
            endpoint: "https://cloud.appwrite.io/v1",
            endpointRealtime: nil,
            selfSigned: false
        )
            .setProject(value: "6656a4d60016b753f942")
            .setSelfSigned(value: true)
        account = Account(client: client)
        databases = Databases(client: client)
        realtime = Realtime(client: client)
    }

    var body: some View {
        VStack {
            if isLoading {
                ProgressView()
            } else {
                VStack(spacing: 10) {
                    Text("Account ID: \(accountId)")
                    Text("Document ID: \(documentId)")
                    Text("Realtime ID: \(realtimeId)")
                }
            }
        }
        .alert("Error", isPresented: .constant(error != nil)) {
            Button("OK") { error = nil }
        } message: {
            Text(error?.localizedDescription ?? "")
        }
        .onAppear {
            Task {
                await loadData()
            }
        }
    }

    private func loadData() async {
        isLoading = true
        defer { isLoading = false }

        do {
            // Authentication
            let session = try await account.createEmailPasswordSession(
                email: "camka14@gmail.com",
                password: "Zenit1925"
            )
            client.setSession(value: session.secret)

            // Get user data
            let user = try await account.get()
            accountId = user.id

            // Fetch documents
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

            // Setup realtime subscription
            setupRealtimeSubscription()

        } catch {
            self.error = error
            print("Appwrite error: \(error)")
        }
    }

    private func setupRealtimeSubscription() {
        realtime.subscribe(
            channels: ["databases.mvp.collections.matches.documents"],
            payloadType: shared.MatchDTO.self as AnyObject as! KotlinKClass,
            payloadSerializer: shared.MatchDTO.Companion.shared.getSerializer()
        ) { response in
            if let payload = response.payload as? shared.Document<shared.MatchDTO>,
               let matchData = payload.data {
                DispatchQueue.main.async {
                    realtimeId = String(matchData.matchId)
                }
            }
        }
    }

}

