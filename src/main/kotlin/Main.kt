import io.github.ayfri.kore.commands.say
import io.github.ayfri.kore.dataPack
import io.github.ayfri.kore.functions.function

const val outputPathFolder = "./out"

fun main() {
	val myDatapack = dataPack("my_datapack") {
		path(outputPathFolder) // Set the output path for the datapack

		function("my_function") {
			say("Hello Minecraft world !")
		}
	}

	myDatapack.generateZip()
}
