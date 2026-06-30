plugins {
    id("java-library")
    id("com.gradleup.shadow") version "8.3.0"
}

group = "kurosio"
version = "1.9.4"

repositories {
    mavenCentral()
    maven {
        name = "papermc-repo"
        url = uri("https://repo.papermc.io/repository/maven-public/")
    }
    maven {
        name = "jitpack-repo"
        url = uri("https://jitpack.io")
    }
    maven {
        name = "azisaba-repo"
        url = uri("https://repo.azisaba.net/repository/maven-releases/")
    }
}

dependencies {
    compileOnly("com.destroystokyo.paper:paper-api:1.15.2-R0.1-SNAPSHOT")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("net.azisaba:ItemStash:2.2.3")
}

java {
    toolchain.languageVersion = JavaLanguageVersion.of(8)
}

tasks {
    processResources {
        val props = mapOf("version" to version, "description" to project.description)
        filesMatching("plugin.yml") {
            expand(props)
        }
    }
}