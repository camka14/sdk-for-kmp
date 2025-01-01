# Appwrite Android SDK

![Maven Central](https://img.shields.io/maven-central/v/io.appwrite/sdk-for-android.svg?color=green&style=flat-square)
![License](https://img.shields.io/github/license/appwrite/sdk-for-android.svg?style=flat-square)
![Version](https://img.shields.io/badge/api%20version-1.6.0-blue.svg?style=flat-square)
[![Build Status](https://img.shields.io/travis/com/appwrite/sdk-generator?style=flat-square)](https://travis-ci.com/appwrite/sdk-generator)
[![Twitter Account](https://img.shields.io/twitter/follow/appwrite?color=00acee&label=twitter&style=flat-square)](https://twitter.com/appwrite)
[![Discord](https://img.shields.io/discord/564160730845151244?label=discord&style=flat-square)](https://appwrite.io/discord)

**This SDK is compatible with Appwrite server version 1.6.x. For older versions, please
check [previous releases](https://github.com/appwrite/sdk-for-android/releases).**

Appwrite is an open-source backend as a service server that abstract and simplify complex and
repetitive development tasks behind a very simple to use REST API. Appwrite aims to help you develop
your apps faster and in a more secure way. Use the Android SDK to integrate your app with the
Appwrite server to easily start interacting with all of Appwrite backend APIs and tools. For full
API documentation and tutorials go to [https://appwrite.io/docs](https://appwrite.io/docs)

![Appwrite](https://github.com/appwrite/appwrite/raw/main/public/images/github.png)

## Installation

Since this SDK is not yet available on Maven Central, you'll need to build and publish it
locally.

### Local Publication

1. Clone the repository:
   ```bash git clone https://github.com/camka14/sdk-for-kmp.git cd sdk-for-kmp ```

2. Clean and publish to
   local Maven: ```./gradlew clean publishToMavenLocal ``` ### Gradle Setup Add the following
   to
   your root level `build.gradle.kts`: ```kotlin repositories { mavenLocal() mavenCentral() } ``` In
   your shared module's `build.gradle.kts`:
   ```kotlin kotlin { androidTarget() iosX64() iosArm64() iosSimulatorArm64() sourceSets { commonMain { dependencies { implementation("io.appwrite:sdk-for-kmp:0.2.0") } } } } ```

### Maven

Add this to your project's `pom.xml` file:

```xml

<dependencies>
    <dependency>
        <groupId>io.appwrite</groupId>
        <artifactId>sdk-for-android</artifactId>
        <version>6.0.0</version>
    </dependency>
</dependencies>
```

## Getting Started

### Add your Platforms

To initialize your SDK and start interacting with Appwrite services, you need to add a new
platform to your project. To add a new platform, go to your Appwrite console, select your project (
create one if you haven't already), and click the 'Add Platform' button on the project Dashboard.

From the options, choose to add a new platform and add your app credentials.

Add your app <u>name</u> and <u>package name</u>. Your package name is generally the applicationId
in your app-level `build.gradle` file. By registering a new platform, you are allowing your app to
communicate with the Appwrite API.

### Registering additional activities

In order to capture the Appwrite OAuth callback url, the following activity needs to be added to
your [AndroidManifest.xml](https://github.com/appwrite/playground-for-android/blob/master/app/src/main/AndroidManifest.xml).
Be sure to replace the **[PROJECT_ID]** string with your actual Appwrite project ID. You can find
your Appwrite project ID in your project settings screen in the console.

```xml

<manifest>
    <application>
        <activity android:name="io.appwrite.views.CallbackActivity">
            <intent-filter android:label="android_web_auth">
                <action android:name="android.intent.action.VIEW" />
                <category android:name="android.intent.category.DEFAULT" />
                <category android:name="android.intent.category.BROWSABLE" />
                <data android:scheme="appwrite-callback-[PROJECT_ID]" />
            </intent-filter>
        </activity>
    </application>
</manifest>
```

### Init your SDK

<p>Initialize your SDK with your Appwrite server API endpoint and project ID, which can be found in your project settings page.

#### Common

```kotlin
import io.appwrite.Client
import io.appwrite.services.Account

expect val client: Client
val endpoint = "https://[HOSTNAME_OR_IP]/v1"
val project = "5df5acd0d48c2"
```

#### Android

```kotlin
import io.appwrite.Client
import io.appwrite.services.Account

actual val client = Client(context)
    .setEndpoint(endpoint) // Your API Endpoint
    .setProject(project) // Your project ID
    .setSelfSigned(true) // Remove in production
```

#### iOS

```kotlin
import io.appwrite.Client
import io.appwrite.services.Account

actual val client = Client()
    .setEndpoint(endpoint) // Your API Endpoint
    .setProject(project) // Your project ID
    .setSelfSigned(true) // Remove in production
```

Before starting to send any API calls to your new Appwrite instance, make sure your Android
emulators has network access to the Appwrite server hostname or IP address.

When trying to connect to Appwrite from an emulator or a mobile device, localhost is the hostname of
the device or emulator and not your local Appwrite instance. You should replace localhost with your
private IP. You can also use a service like [ngrok](https://ngrok.com/) to proxy the Appwrite API.

### Make Your First Request

<p>Once your SDK object is set, access any of the Appwrite services and choose any request to send. Full documentation for any service method you would like to use can be found in your SDK documentation or in the [API References](https://appwrite.io/docs) section.

#### Common

```kotlin
// Register User
val account = Account(client)
val response = account.create(
    ID.unique(),
    "email@example.com",
    "password",
    "Walter O'Brien"
)
```

### Full Example

```kotlin
import io.appwrite.Client
import io.appwrite.services.Account
import io.appwrite.ID

// commonMain
expect val client: Client
val endpoint = "https://[HOSTNAME_OR_IP]/v1"
val project = "5df5acd0d48c2"

// androidMain
actual val client = Client(context)
    .setEndpoint(endpoint) // Your API Endpoint
    .setProject(project) // Your project ID
    .setSelfSigned(true) // Remove in production

// iosMain
actual val client = Client()
    .setEndpoint(endpoint) // Your API Endpoint
    .setProject(project) // Your project ID
    .setSelfSigned(true) // Remove in production

// commonMain
val account = Account(client)
val user = account.create(
    ID.unique(),
    "email@example.com",
    "password",
    "Walter O'Brien"
)
```

### Error Handling

The Appwrite Android SDK raises an `AppwriteException` object with `message`, `code` and `response`
properties. You can handle any errors by catching `AppwriteException` and present the `message` to
the user or handle it yourself based on the provided error information. Below is an example.

```kotlin
try {
    var user = account.create(ID.unique(), "email@example.com", "password", "Walter O'Brien")
    Log.d("Appwrite user", user.toMap())
} catch (e: AppwriteException) {
    e.printStackTrace()
}
```

### Learn more

You can use the following resources to learn more and get help

- 🚀 [Getting Started Tutorial](https://appwrite.io/docs/getting-started-for-android)
- 📜 [Appwrite Docs](https://appwrite.io/docs)
- 💬 [Discord Community](https://appwrite.io/discord)
- 🚂 [Appwrite Android Playground](https://github.com/appwrite/playground-for-android)

## Contribution

This library is auto-generated by Appwrite
custom [SDK Generator](https://github.com/appwrite/sdk-generator). To learn more about how you can
help us improve this SDK, please check
the [contribution guide](https://github.com/appwrite/sdk-generator/blob/master/CONTRIBUTING.md)
before sending a pull-request.

## License

Please see
the [BSD-3-Clause license](https://raw.githubusercontent.com/appwrite/appwrite/master/LICENSE) file
for more information.