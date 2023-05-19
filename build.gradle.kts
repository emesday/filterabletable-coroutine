import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.7.21"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.apache.calcite:calcite-core:1.34.0")
    testImplementation("io.kotest:kotest-runner-junit5:5.5.5")

    if (System.getenv("USE_LOGBACK").toBoolean()) {
        implementation("ch.qos.logback:logback-classic:1.4.7")
        implementation("org.slf4j:slf4j-api:2.0.6")
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}