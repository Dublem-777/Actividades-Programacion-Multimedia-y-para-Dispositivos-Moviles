// 1. Recibe la cadena y una función que la usa sin devolver nada
fun hacerCon1(text: String, action: (String) -> Unit) {
    action(text)
}

// 2. Igual, pero devuelve la cadena recibida
fun hacerCon2(text: String, action: (String) -> Unit): String {
    action(text)
    return text
}

// 3. Devuelve lo que devuelva la función
fun hacerCon3(text: String, action: (String) -> String): String = action(text)

// 4. Como hacerCon2, pero como extension function de String
fun String.hacerCon4(action: (String) -> Unit): String {
    action(this)
    return this
}

// 5. Como hacerCon3, pero como extension function de String
fun String.hacerCon5(action: (String) -> String): String = action(this)

// 6. Como hacerCon4, pero para cualquier tipo T          (equivale a also)
fun <T> T.hacerCon6(action: (T) -> Unit): T {
    action(this)
    return this
}

// 7. Como hacerCon5, pero con T y un retorno genérico R   (equivale a let)
fun <T, R> T.hacerCon7(action: (T) -> R): R = action(this)

// 8. Como hacerCon6, pero con tipo función con receptor   (equivale a apply)
fun <T> T.hacerCon8(action: T.() -> Unit): T {
    action()          // se ejecuta sobre this: dentro de la lambda, this es el receptor
    return this
}

// 9. Como hacerCon7, pero con tipo función con receptor   (equivale a run)
fun <T, R> T.hacerCon9(action: T.() -> R): R = action()

fun main() {
    val word = "Kotlin"

    hacerCon1(word) { println("hacerCon1: ${it.reversed()}") }
    println("hacerCon2 devuelve: ${hacerCon2(word) { println("hacerCon2: ${it.reversed()}") }}")
    println("hacerCon3 devuelve: ${hacerCon3(word) { it.reversed() }}")
    println("hacerCon4 devuelve: ${word.hacerCon4 { println("hacerCon4: ${it.reversed()}") }}")
    println("hacerCon5 devuelve: ${word.hacerCon5 { it.reversed() }}")
    println("hacerCon6 devuelve: ${word.hacerCon6 { println("hacerCon6: ${it.reversed()}") }}")
    println("hacerCon7 devuelve: ${word.hacerCon7 { it.reversed() }}")
    println("hacerCon8 devuelve: ${word.hacerCon8 { println("hacerCon8: ${reversed()}") }}")
    println("hacerCon9 devuelve: ${word.hacerCon9 { reversed() }}")

    // Las versiones genéricas funcionan con cualquier tipo: aquí T = Int y R = String
    println("hacerCon7 con un Int: ${12345.hacerCon7 { it.toString().reversed() }}")
    println("hacerCon9 con un Int: ${12345.hacerCon9 { toString().reversed() }}")
}
