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
    implementation("org.junit.platform:junit-platform-suite-engine:1.10.2")
    implementation("com.codeborne:selenide:7.2.3")
    implementation("org.hamcrest:hamcrest:2.2")
    runtimeOnly("io.goodforgod:slf4j-simple-logger:2.0.0")
}

tasks.test {
    useJUnitPlatform()
}
