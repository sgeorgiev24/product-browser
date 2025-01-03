// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.ktlint)
}

subprojects {
    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
    }

    ktlint {
        version = "0.50.0"
        debug = false
        verbose = false
        android = true
        outputToConsole = true
        ignoreFailures = false
        enableExperimentalRules = false

        filter {
            exclude("**/generated/**")
            exclude { it.file.path.contains("${layout.buildDirectory.get()}/generated/") }
            include("**/kotlin/**")
            include("**/java/**")
        }
    }
}
