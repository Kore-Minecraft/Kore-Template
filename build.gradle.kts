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
}

// Apply the required Java 25 toolchain
kotlin {
	jvmToolchain(25)
}

application {
	// Define the main class for the application.
	mainClass = "MainKt"
}
