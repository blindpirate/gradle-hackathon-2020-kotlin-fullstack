plugins {
    kotlin("jvm")
    id("org.springframework.boot") version ("2.3.3.RELEASE")
    id("io.spring.dependency-management") version ("1.0.8.RELEASE")
}
repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    maven("https://dl.bintray.com/samgarasx/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

dependencies {
    implementation(project(":shared"))

    implementation("org.springframework.boot:spring-boot-starter-web")
    testImplementation("org.springframework.boot:spring-boot-starter-test") {
        exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
    }
}

tasks.named("bootRun") {
    dependsOn(":client:browserDevelopmentWebpack")
}
