plugins {
    kotlin("multiplatform")
    kotlin("plugin.serialization") version "1.4.10"
}

repositories {
    mavenCentral()
}

kotlin {
    targets {
        jvm()
        js {
            browser {
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlin("stdlib-js"))
                api(kotlin("stdlib-jdk8"))
                api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
            }
        }

        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }

        // https://stackoverflow.com/questions/56508672/kotlin-multiplatform-gradle-unit-test-not-resolving-kotlin-test-reference
        val jvmTest by getting {
            dependencies {
                implementation(kotlin("test-junit5"))
            }
        }

        val jsTest by getting {
            dependencies {
                implementation(kotlin("test-js"))
            }
        }
    }

    jvm {
        val main by compilations.getting {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
}

repositories {
    mavenCentral()
}


