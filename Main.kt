import java.io.File

fun main() {
    val file = File("notes.txt")

    while (true) {
        var lines = file.readLines(Charsets.UTF_8).toMutableList()
        val mode: String? = readLine()

        if (mode == "n") {
            val newNote: String? = readLine()

            if (!file.exists()) {
                file.writeText(newNote ?: "") // TODO: the elvis thing shouldn't be returning nothing TODO: fix all these damn elvis fuckers!!
            } else {
                file.appendText("\n" + (newNote ?: ""))
            }
        } else if (mode == "l") {
            for (i in lines) { println(i) }
        } else if (mode == "d") {
            for (i in lines.indices) {
                println("$i: ${lines[i]}")
            }

            val lineToRemove: String? = readLine()
            lines.removeAt(lineToRemove?.toIntOrNull() ?: 0)

            file.writeText("")
            for (i in lines.indices) {
                if (i > 0) file.appendText("\n")
                file.appendText(lines[i])
            }
        } else {
            println("Not an acceptable argument!")
            return
        }
    }
}
