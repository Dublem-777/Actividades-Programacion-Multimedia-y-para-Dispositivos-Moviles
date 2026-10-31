fun sumIfAllIntegers(vararg values: Any): Int? {
    var sum = 0

    for (value in values) {
        val integer = value as? Int ?: return null
        sum += integer
    }

    return sum
}

fun main() {
    println(sumIfAllIntegers(1, 2, 3, 4))
    println(sumIfAllIntegers(1, 2, "3", 4))
}
