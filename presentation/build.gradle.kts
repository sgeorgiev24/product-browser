plugins {
    id("com.android.library")
    kotlin("android")
    alias(libs.plugins.ksp)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.sgeorgiev.productbrowser.presentation"
    compileSdk = 35

    buildFeatures {
        compose = true
        dataBinding = true
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
    implementation(project(":domain:interactor"))
    implementation(project(":domain:model"))

    implementation(libs.koin.android)
    implementation(libs.koin.compose)

    implementation(libs.compose.navigation)

    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.ui.viewbinding)

    implementation(libs.coil.compose)
    implementation(libs.coil.network)
}
