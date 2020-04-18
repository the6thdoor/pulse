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
      }
    }

    jvm().compilations["test"].defaultSourceSet {
      dependencies {
        implementation(kotlin("test-junit"))
      }
    }

    linuxX64("linux").compilations["main"].defaultSourceSet {}
    linuxX64("linux").compilations["test"].defaultSourceSet {}
  }
}
