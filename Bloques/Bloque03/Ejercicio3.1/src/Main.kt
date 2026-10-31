fun main() {
    // Array de 4 posiciones para las notas (DoubleArray porque son decimales)
    val grades = DoubleArray(4)

    // Rellenamos el array pidiendo cada nota por consola
    for (i in grades.indices) {
        print("Introduce la nota del examen ${i + 1}: ")
        grades[i] = readln().toDouble()
    }

    // Recorremos el array para sumar todas las notas
    var sum = 0.0
    for (grade in grades) {
        sum += grade
    }

    // Media = suma / número de notas
    val average = sum / grades.size
    println("La media de las notas es ${"%.2f".format(average)}")
}
