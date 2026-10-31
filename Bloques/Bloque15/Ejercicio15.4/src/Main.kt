fun main() {
    val testScores = listOf(85, 92, 78, 95, 88, 70)

    println("Número de puntuaciones: ${testScores.size}")
    println("Índice de la última: ${testScores.lastIndex}")
    println("Posición del 95: ${testScores.indexOf(95)}")

    // testScores[10] lanzaría IndexOutOfBoundsException
    try {
        println(testScores[10])
    } catch (e: IndexOutOfBoundsException) {
        println("testScores[10] → excepción: ${e.message}")
    }
    // getOrNull devuelve null si el índice no existe
    println("Elemento en el índice 10: ${testScores.getOrNull(10)}")
    // getOrElse ejecuta la lambda si el índice no existe
    println("Índice 10 o suspenso: ${testScores.getOrElse(10) { 50 }}")

    println("¿Está el 78? ${78 in testScores}")                    // contains(78)
    println("Tres al azar: ${testScores.shuffled().take(3)}")       // cambia en cada ejecución

    val allButLast = testScores.dropLast(1)
    println("Todas menos la última: $allButLast")

    println(testScores.joinToString(separator = " | ", prefix = "[", postfix = "]"))
}
