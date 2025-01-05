plugins {
    id("com.android.library")
    kotlin("android")
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.sgeorgiev.productbrowser.domain.repository"
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
    implementation(project(":provider:network"))
    implementation(project(":provider:database"))
    implementation(project(":domain:model"))

    implementation(libs.koin.android)

    ksp(libs.room.compiler)
    implementation(libs.room.ktx)
}
