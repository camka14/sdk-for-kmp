import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinx.serialization)
    id("org.jetbrains.kotlinx.atomicfu") version "0.26.0"
    id("maven-publish")
    id("signing")
}


group = "io.appwrite"
version = "0.2.0"

publishing {
    publications {
        withType<MavenPublication> {
            // Configure POM
            artifactId = "sdk-for-kmp"
            pom {
                name.set("Appwrite KMP SDK")
                description.set("Kotlin Multiplatform SDK for Appwrite")
                url.set("https://github.com/camka14/sdk-for-kmp")
                licenses {
                    license {
                        name.set("The Apache License, Version 2.0")
                        url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                    }
                }
                developers {
                    developer {
                        id.set("camka14")
                        name.set("Samuel Razumovskiy")
                        email.set("samuel.razumovskiy@razumly.com")
                    }
                }
            }
        }
    }
}
kotlin {
    androidTarget {
        publishLibraryVariants("release", "debug")
        compilations.all {
            compileTaskProvider.configure {
                compilerOptions {
                    jvmTarget.set(JvmTarget.JVM_1_8)
                }
            }
        }
    }

    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "shared"
            isStatic = true
        }
        it.withSourcesJar(publish = false)
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlin.reflect)
            implementation(libs.ktor.client.core)
            api(libs.kotlinx.serialization.json)
            implementation(libs.ktor.network.tls.certificates)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.websockets)
            api(libs.ktor.serialization.kotlinx.json)
            api(libs.napier)
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.browser.v170)
            implementation(libs.androidx.lifecycle.livedata.ktx)
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
            implementation(libs.androidx.navigation.fragment.ktx)
            implementation(libs.androidx.navigation.ui.ktx)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.firebase.messaging)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.gson)
            implementation(project.dependencies.platform("com.google.firebase:firebase-bom:33.6.0"))
        }

        iosMain.dependencies {
            implementation(libs.jetbrains.kotlinx.coroutines.core)
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }

        androidUnitTest.dependencies {
            implementation(libs.junit)
        }

        androidInstrumentedTest.dependencies {
            implementation(libs.androidx.junit)
            implementation(libs.androidx.espresso.core)
        }
    }
}


android {
    namespace = "io.appwrite"
    compileSdk = 35
    defaultConfig {
        minSdk = 21
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}
dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.espresso.core)
    implementation(libs.firebase.crashlytics.buildtools)

}
