plugins {
    id("java")
    id("io.freefair.lombok") version "8.1.0"
}

group = "ru.megacraft"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    maven("https://repo.aikar.co/content/groups/aikar")
}

dependencies {
    compileOnly("org.spigotmc:spigot:1.12.2-R0.1-SNAPSHOT")
}

tasks.jar {
    archiveFileName = "EffectKill.jar"
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
