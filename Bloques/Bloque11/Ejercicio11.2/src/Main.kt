// Extension function: se define fuera de String, pero se llama como si fuera un método suyo
fun String.reverseWords(): String =
    trim()                      // quita espacios al principio y al final
        .split(Regex("\\s+"))   // separa por uno o más espacios
        .reversed()             // invierte el orden de la lista de palabras
        .joinToString(" ")      // vuelve a unirlas con un espacio

fun main() {
    val sentence = "Kotlin es un lenguaje   moderno"
    println("Original:  $sentence")
    println("Invertida: ${sentence.reverseWords()}")

    // Más casos: espacios en los extremos, una sola palabra y cadena vacía
    println("[${"  hola mundo  ".reverseWords()}]")
    println("[${"Kotlin".reverseWords()}]")
    println("[${"".reverseWords()}]")
}
