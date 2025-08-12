import io.github.ayfri.kore.commands.say
import io.github.ayfri.kore.dataPack
import io.github.ayfri.kore.functions.function
import kotlinx.io.files.Path
import kotlinx.io.files.SystemFileSystem

const val outputPathFolder = "./out"

fun main() {
	val myDatapack = dataPack("my_datapack") {
		path = Path(outputPathFolder) // Set the output path for the datapack
		SystemFileSystem.createDirectories(path) // Create the output directory if it doesn't exist

		function("my_function") {
			say("Hello Minecraft world !")
		}
	}

	myDatapack.generateZip()
}
