data class Product(
    val id: Int,
    val name: String,
    val price: Double,
    val quantity: Int,
)

// Devuelve un producto NUEVO con el precio incrementado en el porcentaje indicado
fun updateProduct(product: Product, percentage: Double): Product {
    require(percentage >= 0.0) { "Percentage must be non-negative" }
    return product.copy(price = product.price * (1 + percentage / 100))
}

fun main() {
    val keyboard = Product(1, "Teclado", 50.0, 8)
    val updated = updateProduct(keyboard, 10.0)

    println("Original:    $keyboard")
    println("Actualizado: $updated")
    println("Precio con 2 decimales: ${"%.2f".format(updated.price)}")
    println("¿Son el mismo objeto? ${keyboard === updated}")
    println("¿Tienen los mismos datos? ${keyboard == updated}")
    println("¿Igual a otro Teclado de 50 €? ${keyboard == Product(1, "Teclado", 50.0, 8)}")
}
