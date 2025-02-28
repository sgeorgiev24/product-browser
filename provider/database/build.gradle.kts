plugins {
    id("com.android.library")
    kotlin("android")
    alias(libs.plugins.kotlin.seriazliation)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.sgeorgiev.productbrowser.provider.database"
    compileSdk = 35

    defaultConfig {
        minSdk = 24
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_21
        targetCompatibility = JavaVersion.VERSION_21
    }
    kotlinOptions {
        jvmTarget = "21"
    }
}

dependencies {
    implementation(libs.koin.android)

    implementation(libs.kotlinx.serialization)

    implementation(libs.ktor.client.core)
    implementation(libs.ktor.client.android)
    implementation(libs.ktor.serialization)
    implementation(libs.ktor.client.logging)
    implementation(libs.ktor.client.content.negotiation)

    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
}
