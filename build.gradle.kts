import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.springframework.boot") version "3.2.3"
    id("io.spring.dependency-management") version "1.1.4"
    kotlin("jvm") version "1.9.22"
    kotlin("plugin.spring") version "1.9.22"
}

group = "com.sfr"
version = "0.0.1-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    // https://mvnrepository.com/artifact/org.apache.kafka/kafka-streams
    implementation("org.apache.kafka:kafka-streams:3.7.0")
    // https://mvnrepository.com/artifact/org.springframework.kafka/spring-kafka
    implementation("org.springframework.kafka:spring-kafka:3.1.2")
    // https://mvnrepository.com/artifact/org.springframework.kafka/spring-kafka-test
    testImplementation("org.springframework.kafka:spring-kafka-test:3.1.2")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs += "-Xjsr305=strict"
        jvmTarget = "17"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
