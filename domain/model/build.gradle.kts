plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.sgeorgiev.productbrowser.domain.model"
    compileSdk = 35

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
}
