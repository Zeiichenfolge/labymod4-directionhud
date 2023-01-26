rootProject.name = "directionhud"

pluginManagement {
    val labyGradlePluginVersion = "0.3.7"
    plugins {
        id("net.labymod.gradle") version (labyGradlePluginVersion)
    }

    buildscript {
        repositories {
            maven("https://dist.labymod.net/api/v1/maven/release/")
            maven("https://repo.spongepowered.org/repository/maven-public")
            mavenCentral()
        }

        dependencies {
            classpath("net.labymod.gradle", "addon", labyGradlePluginVersion)
        }
    }
}

plugins.apply("net.labymod.gradle")

include(":api")
include(":core")
include(":versions:v1_8")
include(":versions:v1_17")
include(":versions:v1_18")
include(":versions:v1_19")
