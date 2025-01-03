plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.sgeorgiev.productbrowser.domain.model"
    compileSdk = 35
}

dependencies {
    implementation(libs.koin.android)
}
