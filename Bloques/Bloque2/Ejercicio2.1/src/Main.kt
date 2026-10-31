fun main() {
    // Pedimos los tres números. Son var porque los vamos a reordenar
    print("Introduce el primer número: ")
    var first: Int = readln().toInt()
    print("Introduce el segundo número: ")
    var second: Int = readln().toInt()
    print("Introduce el tercer número: ")
    var third: Int = readln().toInt()

    // Paso 1: ordenamos first y second
    if (first > second) {
        val temp = first
        first = second
        second = temp
    }

    // Paso 2: llevamos el menor de todos a first
    if (first > third) {
        val temp = first
        first = third
        third = temp
    }

    // Paso 3: ordenamos los dos que quedan
    if (second > third) {
        val temp = second
        second = third
        third = temp
    }

    println("Los números en orden son: $first, $second, $third")
}
