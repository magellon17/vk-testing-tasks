plugins {
    id("java")
}

group = "ru.siobko.testing.tasks"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.9.1"))
    implementation("org.junit.jupiter:junit-jupiter")
    implementation("com.codeborne:selenide:7.2.3")
    runtimeOnly("io.goodforgod:slf4j-simple-logger:2.0.0")
}

tasks.test {
    useJUnitPlatform()
}