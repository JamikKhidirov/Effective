plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}
configurations.all {
    resolutionStrategy {
        // Принудительно заставляем использовать стабильную stdlib 2.0.0,
        // чтобы корутины не тащили за собой версию 2.2.0, которая ломает твой компилятор
        force("org.jetbrains.kotlin:kotlin-stdlib:2.0.0")
    }
}

dependencies{
    implementation("javax.inject:javax.inject:1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.2")
}
