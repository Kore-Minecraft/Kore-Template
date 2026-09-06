import io.github.ayfri.kore.DataPack
import io.github.ayfri.kore.commands.say
import io.github.ayfri.kore.dataPack
import io.github.ayfri.kore.features.predicates.predicate
import io.github.ayfri.kore.functions.load
import io.github.ayfri.kore.path

fun main() {
	val myDatapack = dataPack("my_datapack") {
		// The Gradle plugin passes its output directory here, `out` is the fallback when running `main` from the IDE.
		path(System.getProperty("kore.output") ?: "out")

		load("main") {
			say("Hello Minecraft world !")
		}

		myPredicate()
	}

	myDatapack.generate()
}

fun DataPack.myPredicate() = predicate("test") {

}
