// Función de orden superior: recibe una función (Int) -> Boolean como parámetro
fun testBoth(first: Int, second: Int, condition: (Int) -> Boolean): Boolean =
    condition(first) && condition(second)

fun main() {
    // Condición 1: ¿son múltiplos de 3?
    val bothMultiplesOf3 = testBoth(9, 21) { it % 3 == 0 }
    println("¿9 y 21 son múltiplos de 3? $bothMultiplesOf3")

    // Condición 2: ¿son mayores que 10?
    val bothGreaterThan10 = testBoth(15, 7) { number -> number > 10 }
    println("¿15 y 7 son mayores que 10? $bothGreaterThan10")
}
