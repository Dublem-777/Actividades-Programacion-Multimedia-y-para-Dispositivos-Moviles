fun name(a: Any?): String = when (a) {
    null -> "Nothing"
    1, 2, 3 -> "Small number"
    7, 13 -> "Magic number"
    is Int if a in 4..100 -> "Big number"   // condición de guarda
    is String -> "String"
    is Int, is Long -> "Integer"
    else -> "No idea"
}

fun main() {
    // Valores de prueba de todos los tipos posibles, incluido null
    val values: Array<Any?> = arrayOf(null, 1, 2, 3, 7, 13, 4, 50, 100, "Kotlin", 101, 5L, -8, 1.5, 7.0, true)
    for (value in values) {
        println("$value → ${name(value)}")
    }
}
