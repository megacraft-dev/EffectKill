plugins {
    id("java")
    id("io.freefair.lombok") version "8.1.0"
}

group = "ru.megacraft"
version = "2.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_16
    targetCompatibility = JavaVersion.VERSION_16
}

repositories {
    mavenCentral()
    maven("https://repo.megacraft.org/repository/maven-private") {
        credentials {
            username = System.getenv("MEGACRAFT_REPO_USERNAME")
            password = System.getenv("MEGACRAFT_REPO_PASSWORD")
        }
    }
}

dependencies {
    compileOnly("org.spigotmc:spigot:1.16.5-R0.1-SNAPSHOT")
}

tasks.jar {
    archiveFileName = "EffectKill.jar"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
