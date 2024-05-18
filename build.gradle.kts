plugins {
    id("java")
}

group = "ru.siobko.testing.tasks"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation(platform("org.junit:junit-bom:5.10.2"))
    implementation("org.junit.jupiter:junit-jupiter")
    runtimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.junit.platform:junit-platform-suite-engine:1.10.2")
    implementation("com.codeborne:selenide:7.3.2")
    implementation("org.hamcrest:hamcrest:2.2")
    implementation("org.apache.commons:commons-lang3:3.6")
    runtimeOnly("io.goodforgod:slf4j-simple-logger:2.0.0")
}

tasks.test {
    useJUnitPlatform()
}
