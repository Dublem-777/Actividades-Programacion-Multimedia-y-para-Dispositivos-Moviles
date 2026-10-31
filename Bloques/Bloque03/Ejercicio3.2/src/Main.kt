import kotlin.random.Random

fun main() {
    // Número aleatorio entre 0 y 100 (el límite superior, 101, no se incluye)
    val randomNumber = Random.nextInt(0, 101)

    // Según el rango, la variable guarda null, un Int o un String
    val value: Any? = when (randomNumber) {
        in 0..33 -> null
        in 34..66 -> 5
        else -> "Baldomero"   // 67..100
    }

    println("Número aleatorio generado: $randomNumber")

    // Comprobamos qué tipo de contenido tiene la variable
    when (value) {
        null -> println("La variable es nula")
        is Int -> println("La variable es un número entero")
        is String -> println("La variable es una cadena de texto")
    }
}
