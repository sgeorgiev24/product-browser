plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    namespace = "com.sgeorgiev.productbrowser.provider.network"
    compileSdk = 35
}

dependencies {
    implementation(libs.koin.android)
}
