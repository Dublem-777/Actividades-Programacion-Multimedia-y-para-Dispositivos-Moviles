// Devuelve true si number es primo
fun isPrime(number: Int): Boolean {
    // Los menores que 2 (negativos, 0 y 1) no son primos
    if (number < 2) return false

    // Basta con probar divisores hasta la raíz cuadrada del número
    var divisor = 2
    while (divisor * divisor <= number) {
        if (number % divisor == 0) return false   // tiene un divisor: no es primo
        divisor++
    }
    return true
}

fun main() {
    val testNumbers = intArrayOf(-7, 0, 1, 2, 3, 4, 9, 17, 25, 97, 100)
    for (number in testNumbers) {
        println("¿$number es primo? ${isPrime(number)}")
    }
}
