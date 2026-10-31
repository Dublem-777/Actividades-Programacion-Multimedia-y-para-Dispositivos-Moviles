fun treeConstruction(value: Int) {
    val filasHojas: Int = value - 1
    val spaceLimit: Int = filasHojas - 1

    repeat(filasHojas) { i ->
        val espacios = spaceLimit - i
        repeat(espacios) {
            print(" ")
        }

        val asteriscos = 2 * i + 1
        repeat(asteriscos) {
            print("*")
        }
        println()
    }

    val espaciosBase: Int = if (filasHojas >= 2) filasHojas - 2 else 0
    repeat(espaciosBase) {
        print(" ")
    }
    repeat(3) {
        print("*")
    }
    println()
}

fun main() {
    print("Introduce la altura del arbol: ")
    val height: Int = readln().toInt()
    treeConstruction(height)
}
