const val TARGET_ID = 500

var premiumChecks = 0    // contador para comprobar cuántas veces se llama a isPremium

// Simula una consulta costosa a la base de datos
fun isPremium(id: Int): Boolean {
    premiumChecks++
    println("Checking premium status for ID: $id")
    return id % 2 == 0
}

fun main() {
    // Versión con Sequence (perezosa)
    val foundUser = generateSequence(1) { it + 1 }   // 1, 2, 3, ... (infinita)
        .takeWhile { it <= TARGET_ID }               // limita la búsqueda hasta el ID 500
        .filter { isPremium(it) }                    // solo usuarios premium (ID par)
        .map { "User-$it" }                          // ID -> nombre
        .find { it == "User-$TARGET_ID" }            // terminal: aquí empieza a trabajar todo

    println("foundUser = $foundUser")
    val sequenceChecks = premiumChecks

    // Comparación: lo mismo con una List (eager) de IDs 1..1000
    premiumChecks = 0
    val foundWithList = (1..1000).toList()
        .filter { isPremium(it) }                    // ¡se comprueban los 1000 antes de seguir!
        .map { "User-$it" }
        .find { it == "User-$TARGET_ID" }

    println("foundWithList = $foundWithList")
    println("Comprobaciones con Sequence: $sequenceChecks")
    println("Comprobaciones con List 1..1000: $premiumChecks")
}
