import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinJvmCompile
import org.jetbrains.kotlin.konan.target.HostManager

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinx.serialization)
    id("org.jetbrains.kotlinx.atomicfu") version "0.29.0"
    id("com.vanniktech.maven.publish") version "0.34.0"
    id("signing")
}

ext {
    set("PUBLISH_GROUP_ID", "io.github.camka14.appwrite")
    set("PUBLISH_ARTIFACT_ID", "sdk-for-kmp")
    set("PUBLISH_VERSION", System.getenv("SDK_VERSION"))
    set("POM_URL", "https://github.com/camka14/sdk-for-kmp")
    set("POM_SCM_URL", "https://github.com/camka14/sdk-for-kmp")
    set("POM_ISSUE_URL", "https://github.com/camka14/sdk-for-kmp/issues")
    set(
        "POM_DESCRIPTION",
        "THIS IS NOT AN OFFICIAL RELEASE: For full API documentation and tutorials go to https://appwrite.io/docs"
    )
    set("POM_LICENSE_URL", "https://opensource.org/licenses/GPL-3.0")
    set("POM_LICENSE_NAME", "GPL-3.0")
    set("POM_DEVELOPER_ID", "camka14")
    set("POM_DEVELOPER_NAME", "Samuel Razumovskiy")
    set("POM_DEVELOPER_EMAIL", "samuel.razumovskiy@gmail.com")
    set("GITHUB_SCM_CONNECTION", "scm:git:git://github.com/camka14/sdk-for-kmp.git")
}

version = project.ext["PUBLISH_VERSION"].toString()
group = project.ext["PUBLISH_GROUP_ID"].toString()

kotlin {
    androidTarget {
        publishLibraryVariants("release")
        compilations.all {
            compileTaskProvider.configure {
                if (this is KotlinJvmCompile) {
                    compilerOptions {
                        jvmTarget.set(JvmTarget.JVM_17)
                    }
                }
            }
        }
    }

    // Only configure iOS targets on macOS hosts
    if (HostManager.hostIsMac) {
        iosX64 {
            binaries.framework {
                baseName = "shared"
                isStatic = true
                binaryOption("bundleId", "io.github.camka14.appwrite.shared")
            }
            withSourcesJar(publish = false)
        }
        iosArm64 {
            binaries.framework {
                baseName = "shared"
                isStatic = true
                binaryOption("bundleId", "io.github.camka14.appwrite.shared")
            }
            withSourcesJar(publish = false)
        }
        iosSimulatorArm64 {
            binaries.framework {
                baseName = "shared"
                isStatic = true
                binaryOption("bundleId", "io.github.camka14.appwrite.shared")
            }
            withSourcesJar(publish = false)
        }
    }

    targets.withType<org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget> {
        binaries.all {
            freeCompilerArgs += listOf("-Xallocator=mimalloc")
        }
    }

    sourceSets {
        commonMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.datetime)
            implementation(libs.kotlin.reflect)
            implementation(libs.ktor.client.core)
            implementation(libs.ktor.client.content.negotiation)
            implementation(libs.ktor.client.websockets)
            implementation(libs.okio)
            api(libs.kotlinx.serialization.json)
            api(libs.ktor.serialization.kotlinx.json)
            api(libs.napier)
        }

        androidMain.dependencies {
            implementation(libs.androidx.core.ktx)
            implementation(libs.androidx.appcompat)
            implementation(libs.androidx.lifecycle.livedata.ktx)
            implementation(libs.androidx.lifecycle.viewmodel.ktx)
            implementation(libs.androidx.navigation.fragment.ktx)
            implementation(libs.androidx.navigation.ui.ktx)
            implementation(libs.kotlinx.coroutines.android)
            implementation(libs.firebase.messaging)
            implementation(libs.ktor.client.okhttp)
            implementation(libs.ktor.client.logging)
            implementation(libs.androidx.datastore)
            implementation(libs.androidx.datastore.preferences)
            implementation(libs.gson)
            implementation(project.dependencies.platform("com.google.firebase:firebase-bom:33.6.0"))
        }

        iosMain.dependencies {
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.ktor.client.darwin)
        }

        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(libs.kotlinx.coroutines.test)
        }

        androidUnitTest.dependencies {
            implementation(libs.junit)
            implementation(libs.androidx.test.core)
            implementation(libs.androidx.junit)
            implementation(libs.androidx.test.runner)
            implementation(libs.robolectric)
            implementation(libs.ktor.client.mock)
        }

        androidInstrumentedTest.dependencies {
            implementation(libs.androidx.junit)
            implementation(libs.androidx.espresso.core)
        }
    }
}

mavenPublishing {
    publishToMavenCentral()

    signAllPublications()

    coordinates(
        project.ext["PUBLISH_GROUP_ID"].toString(),
        project.ext["PUBLISH_ARTIFACT_ID"].toString(),
        project.ext["PUBLISH_VERSION"].toString()
    )

    pom {
        name.set(project.ext["PUBLISH_ARTIFACT_ID"].toString())
        description.set(project.ext["POM_DESCRIPTION"].toString())
        url.set(project.ext["POM_URL"].toString())

        licenses {
            license {
                name.set(project.ext["POM_LICENSE_NAME"].toString())
                url.set(project.ext["POM_LICENSE_URL"].toString())
            }
        }

        developers {
            developer {
                id.set(project.ext["POM_DEVELOPER_ID"].toString())
                name.set(project.ext["POM_DEVELOPER_NAME"].toString())
                email.set(project.ext["POM_DEVELOPER_EMAIL"].toString())
            }
        }

        scm {
            connection.set(project.ext["GITHUB_SCM_CONNECTION"].toString())
            url.set(project.ext["POM_SCM_URL"].toString())
        }
    }
}

android {
    namespace = "io.appwrite"
    compileSdk = 36
    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            all { it.useJUnit() }
        }
    }
}

dependencies {
    implementation(libs.androidx.activity.ktx)
    implementation(libs.androidx.browser)
    implementation(libs.androidx.espresso.core)
    implementation(libs.firebase.crashlytics.buildtools)
}
