plugins {
    java
    id("io.spring.dependency-management") version "1.1.6"
}

group = "net.alkor"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(17)
    }
}

ext {
    set("springBootVersion", "3.3.5")
    set("lombokVersion", "1.18.36")
    set("junitLauncherVersion", "1.11.3")
}


configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation ("org.springframework.boot:spring-boot-starter-web:${property("springBootVersion")}")
    compileOnly("org.springframework.boot:spring-boot-starter-webflux:${property("springBootVersion")}")
    compileOnly("org.projectlombok:lombok:${property("lombokVersion")}")
    annotationProcessor("org.springframework.boot:spring-boot-configuration-processor:${property("springBootVersion")}")
    annotationProcessor("org.projectlombok:lombok:${property("lombokVersion")}")
    testImplementation("org.springframework.boot:spring-boot-starter-test:${property("springBootVersion")}")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher:${property("junitLauncherVersion")}")
}

tasks.withType<Test> {
    useJUnitPlatform()
}
