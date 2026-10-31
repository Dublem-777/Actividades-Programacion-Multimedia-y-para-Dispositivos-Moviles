// Función de orden superior: recibe una función (Int) -> Boolean como parámetro
fun testBoth(first: Int, second: Int, condition: (Int) -> Boolean): Boolean =
    condition(first) && condition(second)

fun main() {
    // Condición 1: ¿son pares? (lambda con it y trailing lambda)
    val bothEven = testBoth(4, 10) { it % 2 == 0 }
    println("¿4 y 10 son pares? $bothEven")

    // Condición 2: ¿son positivos? (lambda con nombre de parámetro)
    val bothPositive = testBoth(3, -5) { number -> number > 0 }
    println("¿3 y -5 son positivos? $bothPositive")
}
