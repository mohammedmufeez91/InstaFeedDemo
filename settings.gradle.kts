pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
    plugins {
        id("com.android.application") version "8.3.0" // Android Gradle Plugin version
        id("org.jetbrains.kotlin.android") version "1.9.0" // Kotlin plugin version
        id("dagger.hilt.android.plugin") version "2.48" // Hilt plugin version
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "volindoDemo"
include(":app")
