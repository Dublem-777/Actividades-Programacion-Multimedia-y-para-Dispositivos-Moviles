data class OrderLine(val productName: String, val price: Double)

val shoppingCart = listOf(
    OrderLine("Teclado", 45.99),
    OrderLine("Monitor", 189.90),
    OrderLine("Ratón", 19.95),
    OrderLine("Auriculares", 59.00),
)

fun main() {
    // 1. forEach con it y trailing lambda
    println("Productos del carrito:")
    shoppingCart.forEach { println("- ${it.productName}") }

    // 2. filter con desestructuración (ignorando el nombre) y map con it
    val expensiveProducts = shoppingCart
        .filter { (_, price) -> price >= 50.0 }
        .map { it.productName }

    // 3. sumOf con it y trailing lambda
    val total = shoppingCart.sumOf { it.price }

    println("Productos de 50 € o más: $expensiveProducts")
    println("Total del carrito: ${"%.2f".format(total)} €")
    println("Total sin formatear: $total")
}
