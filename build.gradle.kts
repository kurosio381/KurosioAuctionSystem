plugins {
    java
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "kurosio"
version = "1.9.3"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/") {
        name = "spigot-repo"
    }
    maven("https://jitpack.io") {
        name = "jitpack.io"
    }
    maven("https://repo.azisaba.net/repository/maven-public/") {
        name = "azisaba-repo"
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.15.2-R0.1-SNAPSHOT")
    compileOnly("com.github.MilkBowl:VaultAPI:1.7")
    compileOnly("net.azisaba:ItemStash:2.2.3")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    compileJava {
        options.encoding = "UTF-8"
    }
    
    processResources {
        filesMatching("plugin.yml") {
            expand("version" to project.version)
        }
    }
}
