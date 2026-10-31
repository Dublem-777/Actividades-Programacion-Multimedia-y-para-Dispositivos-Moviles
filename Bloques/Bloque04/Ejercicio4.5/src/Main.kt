fun main() {
    print("Introduce la edad: ")
    val age: Int = readln().toInt()

    // when con sujeto: se compara age con el rango de cada rama
    when (age) {
        in 1..10 -> println("Está en el rango de 1 a 10")
        in 11..20 -> println("Está en el rango de 11 a 20")
        in 21..30 -> println("Está en el rango de 21 a 30")
        in 31..40 -> println("Está en el rango de 31 a 40")
        in 41..50 -> println("Está en el rango de 41 a 50")
        in 51..Int.MAX_VALUE -> println("Es mayor de 50")
        else -> println("Edad no válida")
    }
}
