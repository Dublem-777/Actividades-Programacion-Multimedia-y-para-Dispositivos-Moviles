fun main() {
    val inventory = mutableListOf("Laptop", "Monitor", "Mouse")
    val prices = mutableMapOf("Laptop" to 1200.0, "Monitor" to 300.0)
    var ordersToday = listOf("Laptop", "Monitor")     // var + lista de solo lectura

    // Operador corchete
    println("Precio del Laptop: ${prices["Laptop"]}")  // lectura: prices.get("Laptop")
    inventory[2] = "Keyboard"                          // escritura: inventory.set(2, "Keyboard")
    prices["Keyboard"] = 50.0                          // nueva clave: prices.put("Keyboard", 50.0)

    // Operadores + y -
    val newOrder = ordersToday + "Keyboard"            // lista nueva; ordersToday no cambia
    println("newOrder: $newOrder")

    ordersToday += "Charger"                           // ordersToday = ordersToday + "Charger"
    ordersToday -= "Monitor"                           // ordersToday = ordersToday - "Monitor"

    println("ordersToday: $ordersToday")
    println("inventory: $inventory")
    println("prices: $prices")
}
