plugins {
    id("java")
    id("application")
}

group = "org.komamitsu.springtest.data.jdbc.singleds"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.boot:spring-boot-starter-data-jdbc:2.7.6")
    implementation("org.postgresql:postgresql:42.5.1")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.8.1")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}

application {
    mainClass.set("org.komamitsu.springtest.data.jdbc.singleds.Main")
}
