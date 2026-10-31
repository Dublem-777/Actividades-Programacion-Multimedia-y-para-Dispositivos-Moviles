data class Product(val name: String, val price: Double, val weightKg: Double, val stock: Int)

// Función genérica de orden superior: suma lo que devuelva selector para cada elemento
fun <T> calculateAggregate(items: List<T>, selector: (T) -> Double): Double {
    var total = 0.0
    for (item in items) {
        total += selector(item)
    }
    return total
}

// Versión extension de List<T>: la lambda queda como único argumento.
// Necesita otro nombre: con el mismo, la JVM la vería igual que calculateAggregate(list, selector)
fun <T> List<T>.aggregate(selector: (T) -> Double): Double =
    calculateAggregate(this, selector)

fun main() {
    val inventory = listOf(
        Product("Portátil", 800.0, 2.1, 5),
        Product("Ratón", 20.0, 0.1, 30),
        Product("Monitor", 150.0, 4.5, 8),
    )

    // 1. Lambda dentro de los paréntesis
    val totalValue = calculateAggregate(inventory, { product -> product.price * product.stock })

    // 2. Trailing lambda: fuera de los paréntesis
    val totalWeight = calculateAggregate(inventory) { product -> product.weightKg * product.stock }

    // 3. Trailing lambda con it
    val totalUnits = calculateAggregate(inventory) { it.stock.toDouble() }

    // 4. Fuera y sin paréntesis (versión extension: la lambda es el único argumento)
    val totalUnitsAgain = inventory.aggregate { it.stock.toDouble() }

    println("Valor total del inventario: ${"%.2f".format(totalValue)} €")
    println("Peso total: ${"%.2f".format(totalWeight)} kg")
    println("Unidades totales: $totalUnits")
    println("Unidades totales (versión extension): $totalUnitsAgain")

    // Al ser genérica, sirve con cualquier tipo de lista
    val words = listOf("sol", "luna", "estrella")
    println("Letras en total: ${calculateAggregate(words) { it.length.toDouble() }}")
}
