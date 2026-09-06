plugins {
	alias(libs.plugins.kotlin)
	alias(libs.plugins.kore)
}

repositories {
	mavenCentral()
}

dependencies {
	implementation(libs.kore)
}

kotlin {
	jvmToolchain(25)
}

kore {
	// Must match the `dataPack("...")` name in Main.kt, this is the folder Minecraft sees.
	packName = "my_datapack"
	mainClass = "MainKt"

	// Worlds under `.minecraft/saves` the pack is copied into. Run `gradlew koreWorlds` to list them.
	worlds = listOf("My World")
}
