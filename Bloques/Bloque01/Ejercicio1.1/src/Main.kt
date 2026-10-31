fun main() {
    // Pedimos los datos al usuario
    print("Introduce tu nombre: ")
    val name: String = readln()
    print("Introduce tu nota de Android: ")
    val androidGrade: Double = readln().toDouble()
    print("Introduce tu nota de Multihilo: ")
    val multithreadingGrade: Double = readln().toDouble()
    print("Introduce tu nota de Optativa: ")
    val optionalGrade: Double = readln().toDouble()

    // Media de las tres notas
    val average: Double = (androidGrade + multithreadingGrade + optionalGrade) / 3

    // Mayor nota: suponemos que es la de Android y la comparamos con las demás
    var highestSubject = "Android"
    var highestGrade = androidGrade
    if (multithreadingGrade > highestGrade) {
        highestSubject = "Multihilo"
        highestGrade = multithreadingGrade
    }
    if (optionalGrade > highestGrade) {
        highestSubject = "Optativa"
        highestGrade = optionalGrade
    }

    // Menor nota: mismo razonamiento, pero buscando la más baja
    var lowestSubject = "Android"
    var lowestGrade = androidGrade
    if (multithreadingGrade < lowestGrade) {
        lowestSubject = "Multihilo"
        lowestGrade = multithreadingGrade
    }
    if (optionalGrade < lowestGrade) {
        lowestSubject = "Optativa"
        lowestGrade = optionalGrade
    }

    // Resultados con plantillas de cadena (sin concatenación)
    println("Hola, $name")
    println("La media es: ${"%.2f".format(average)}")
    println("Tu mayor nota es $highestGrade en $highestSubject")
    println("Tu menor nota es $lowestGrade en $lowestSubject")
}
