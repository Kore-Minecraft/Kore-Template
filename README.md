# Kore Datapack Template

A ready-to-use starting point for building Minecraft datapacks in Kotlin with [Kore](https://kore.ayfri.com).

Write Kotlin, run one Gradle task, and the generated datapack lands directly in your Minecraft world. No zip to copy by
hand, no JSON to write.

## Requirements

- Java Development Kit (JDK) 25 or higher
- A Minecraft installation (the template finds `.minecraft` by itself)

## 60-second start

1. Click **Use this template** on GitHub, or clone it:
    ```shell
    git clone https://github.com/Kore-Minecraft/Kore-Template.git my-datapack
    cd my-datapack
    ```
2. Open `build.gradle.kts` and set `packName` and `worlds` to your datapack name and your world:
    ```kotlin
    kore {
        packName = "my_datapack"
        mainClass = "MainKt"
        worlds = listOf("My World")
    }
    ```
   Not sure of the exact world name? Run `./gradlew koreWorlds` to list the ones Minecraft knows about.
3. Set the same name in `src/main/kotlin/Main.kt`, in the `dataPack("my_datapack")` call.
4. Build it and copy it into your world:
    ```shell
    ./gradlew koreRun
    ```

Type `/reload` in game and your datapack is live.

## The development loop

```shell
./gradlew koreRun --continuous
```

Gradle watches your sources: every save regenerates the pack and copies it into your worlds. On a dedicated server with
RCON enabled, `/reload` is sent for you, so the loop is fully hands-free.

```properties
# server.properties
enable-rcon=true
rcon.port=25575
rcon.password=changeit
```

The password is read from the `RCON_PASSWORD` environment variable. A closed game or a missing password is reported and
skipped, never a build failure.

## Tasks

| Task          | What it does                                                              |
|---------------|---------------------------------------------------------------------------|
| `koreRun`     | Build, copy into every world, reload. The one to use with `--continuous`. |
| `koreBuild`   | Runs `Main.kt` and generates the pack into `build/kore`.                  |
| `koreLink`    | Copies the generated pack into every configured target.                   |
| `koreReload`  | Sends `reload` to a running server over RCON.                             |
| `koreWorlds`  | Lists the worlds found in your Minecraft directory.                       |
| `koreClean`   | Deletes the generated pack and unlinks it from every world.               |

Full options in the [Gradle plugin documentation](https://kore.ayfri.com/docs/guides/gradle-plugin), including dedicated
server folders, resource packs and symlinks instead of copies.

## Writing your datapack

Everything happens inside the `dataPack { }` block in `src/main/kotlin/Main.kt`:

```kotlin
dataPack("my_datapack") {
	path(System.getProperty("kore.output") ?: "out")

	load("main") {
		say("Hello Minecraft world !")
	}
}
```

`load("main") { }` runs on every `/reload`, `function("name") { }` declares a callable function, and every data-driven resource
(predicates, recipes, loot tables, advancements...) has a matching builder. Start with the
[official documentation](https://kore.ayfri.com/docs/home).

Upgrading Kore or Kotlin is a one-line change in `gradle/libs.versions.toml`. The Kore version and the Gradle plugin
version are the same string, so both move together.

## Publishing

`.github/workflows/publish.yml` builds the pack and uploads it to Modrinth every time you publish a GitHub release. Set
`PACK_NAME` and `modrinth-id` at the top of the file, add a `MODRINTH_TOKEN` repository secret with the "Create versions"
scope, and the project is ready to ship.

## Contributing

Issues and pull requests are welcome, on this template and on
[Kore itself](https://github.com/Ayfri/Kore).

Happy datapacking!
