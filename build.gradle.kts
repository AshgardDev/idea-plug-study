plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.9.25"
    // 新增 intellij-platform 2.2.0
    id("org.jetbrains.intellij.platform") version "2.2.0"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    // 平台依赖
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    // 平台依赖
    intellijPlatform {
        create(providers.gradleProperty("platformType"), providers.gradleProperty("platformVersion"))
        // 这里如果你用的是破解版的idea 这里用不了local，因为项目运行时要让你激活
        // local("/Applications/IntelliJ IDEA.app")
    }
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("232")
        untilBuild.set("242.*")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}
