fun treeConstruction(value: Int) {
    val filasHojas: Int = value -1
    val spaceLimit: Int = filasHojas - 1

    for (i in 0 until filasHojas) {
        val espacios = spaceLimit - i
        for (s in 0 until espacios) {
            print(" ")
        }

        val asteriscos = 2 * i + 1
        for (j in 0 until asteriscos) {
            print("*")
        }
        println()
    }

    val espaciosBase: Int = if (filasHojas >= 2) filasHojas - 2 else 0
    for (s in 0 until espaciosBase) {
        print(" ")
    }
    for (a in 0 until 3) {
        print("*")
    }
    println()
}

fun main() {
    print("Introduce la altura del arbol: ")
    val height: Int = readln().toInt()
    treeConstruction(height)
}
