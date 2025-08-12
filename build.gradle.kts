plugins {
	// Apply the kotlin.jvm plugin to add support for Kotlin.
	alias(libs.plugins.kotlin)

	// Apply the application plugin to add support for running the application.
	application
}

repositories {
	// Use Maven Central for resolving dependencies.
	mavenCentral()
}

dependencies {
	// Install Kore.
	implementation(libs.kore)
	implementation(libs.kotlinx.io)
}

// Apply a specific Java toolchain to ease working on different environments.
kotlin {
	jvmToolchain(21)

	// Activate required compiler options for using Kore.
	compilerOptions {
		freeCompilerArgs = listOf("-Xcontext-parameters")
	}
}

application {
	// Define the main class for the application.
	mainClass = "MainKt"
}
