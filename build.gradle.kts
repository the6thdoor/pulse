plugins {
  kotlin("multiplatform") version "1.4-M1"
}

repositories {
  mavenCentral()
  maven ("https://dl.bintray.com/kotlin/kotlin-eap")
  maven ("https://kotlin.bintray.com/kotlinx")
}

kotlin {
  jvm()
  js()
  linuxX64("linux")

  sourceSets {
    val commonMain by getting {
      dependencies {
        implementation(kotlin("stdlib-common"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-common:1.3.5-1.4-M1")
      }
    }
    val commonTest by getting {
      dependencies {
        implementation(kotlin("test-common"))
        implementation(kotlin("test-annotations-common"))
      }
    }

    jvm().compilations["main"].defaultSourceSet {
      dependencies {
        implementation(kotlin("stdlib-jdk8"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5-1.4-M1")
      }
    }

    jvm().compilations["test"].defaultSourceSet {
      dependencies {
        implementation(kotlin("test-junit"))
      }
    }

    js().compilations["main"].defaultSourceSet {
      dependencies {
        implementation(kotlin("stdlib-js"))
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-js:1.3.5-1.4-M1")
      }
    }

    js().compilations["test"].defaultSourceSet {
      dependencies {
        implementation(kotlin("test-js"))
      }
    }

    linuxX64("linux").compilations["main"].defaultSourceSet {
      dependencies {
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-native:1.3.5-1.4-M1")
      }
    }
    linuxX64("linux").compilations["test"].defaultSourceSet {}

    linuxX64("linux") {
      binaries {
        executable {
          entryPoint = "org.pulse.core.main"
        }
      }
    }
  }
}
