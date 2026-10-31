// Representa el rango de enteros de 0 a 100
class De0a100 {
    val start = 0
    val end = 100

    // infix permite llamarla como: rango contains número
    infix fun contains(number: Int): Boolean = number >= start && number <= end
}

fun main() {
    val range = De0a100()

    // Llamada normal y llamada en notación infija
    println("¿50 está en el rango? ${range.contains(50)}")
    println("¿0 está en el rango? ${range contains 0}")
    println("¿100 está en el rango? ${range contains 100}")
    println("¿-1 está en el rango? ${range contains -1}")
    println("¿101 está en el rango? ${range contains 101}")
}
