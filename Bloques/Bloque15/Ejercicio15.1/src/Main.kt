// Colecciones de solo lectura
val productNames = listOf("ProductA", "ProductB", "ProductC", "ProductD", "ProductE")
val uniqueCategories = setOf("Electrónica", "Hogar", "Electrónica", "Deporte")   // "Electrónica" repetida
val priceMap = mapOf(
    "ProductA" to 19.99,
    "ProductB" to 5.50,
    "ProductC" to 120.0,
    "ProductD" to 45.25,
    "ProductE" to 8.75,
)

// Colecciones mutables
val shoppingList = mutableListOf(productNames[0], productNames[1])
val stockLevels = mutableMapOf("ProductA" to 10, "ProductB" to 5)

// List(tamaño) { índice -> valor }
val inventoryIds = List(5) { it + 100 }

fun main() {
    // El Set descarta el duplicado: 3 categorías, no 4
    println("uniqueCategories: $uniqueCategories (tamaño ${uniqueCategories.size})")

    shoppingList.add("ProductC")
    stockLevels["ProductA"] = 15

    println("shoppingList: $shoppingList")
    println("priceMap: $priceMap")
    println("inventoryIds: $inventoryIds")
    println("stockLevels: $stockLevels")
}
