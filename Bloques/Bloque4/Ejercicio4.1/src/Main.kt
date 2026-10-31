// Recibe cualquier cantidad de enteros y devuelve su media
fun calculateAverage(vararg numbers: Int): Double {
    // Sin números no hay media: evitamos dividir entre 0
    if (numbers.isEmpty()) return 0.0

    var sum = 0
    for (number in numbers) {
        sum += number
    }
    // toDouble() para que la división conserve los decimales
    return sum.toDouble() / numbers.size
}

fun main() {
    val grades: IntArray = intArrayOf(7, 4, 9, 6, 8)

    // El spread operator (*) "desempaqueta" el array en argumentos sueltos
    val average = calculateAverage(*grades)
    println("La media de ${grades.contentToString()} es $average")

    // También se puede llamar con valores sueltos
    println("La media de 3, 4 es ${calculateAverage(3, 4)}")
}
