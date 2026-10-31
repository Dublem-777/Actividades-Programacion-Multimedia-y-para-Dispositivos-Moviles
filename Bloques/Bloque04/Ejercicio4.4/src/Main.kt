fun main() {
    print("Introduce la edad: ")
    val age: Int = readln().toInt()

    // when sin sujeto: cada rama es una condición, como un if / else if
    when {
        age < 1 -> println("Edad no válida")
        age <= 10 -> println("Está en el rango de 1 a 10")
        age <= 20 -> println("Está en el rango de 11 a 20")
        age <= 30 -> println("Está en el rango de 21 a 30")
        age <= 40 -> println("Está en el rango de 31 a 40")
        age <= 50 -> println("Está en el rango de 41 a 50")
        else -> println("Es mayor de 50")
    }
}
