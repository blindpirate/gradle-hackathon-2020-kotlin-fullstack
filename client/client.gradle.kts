plugins {
    kotlin("js")
}

repositories {
    maven("https://kotlin.bintray.com/kotlin-js-wrappers/")
    maven("https://dl.bintray.com/samgarasx/kotlin-js-wrappers/")
    mavenCentral()
    jcenter()
}

kotlin {
    js {
        browser {
        }
    }
}

dependencies {
    api(kotlin("stdlib-js"))
    api("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.0")

    api("org.jetbrains:kotlin-react:16.13.1-pre.116-kotlin-1.4.10")
    api("org.jetbrains:kotlin-react-dom:16.13.1-pre.116-kotlin-1.4.10")
    api(npm("react", "16.13.1"))
    api(npm("react-dom", "16.13.1"))

    api("org.jetbrains:kotlin-styled:1.0.0-pre.115-kotlin-1.4.10")
    api(npm("styled-components", "5.2.0"))

    api(npm("react-bootstrap", "1.3.0"))

    api("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.5")
    api("org.jetbrains.kotlinx:kotlinx-browser:0.2")

    api(npm("react-icons", "3.11.0"))

    api("io.ktor:ktor-client-js:1.4.0")

    api(project(":shared"))
}

