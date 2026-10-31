class Product(
    val name: String,
    price: Double,
    val discount: Double = 0.0,
) {
    // El setter valida cada cambio de precio posterior a la creación
    var price: Double = price
        set(value) {
            require(value >= 0.0) { "Price must be non-negative" }
            field = value
        }

    // El setter no se ejecuta al inicializar: validamos aquí los valores iniciales
    init {
        require(price >= 0.0) { "Price must be non-negative" }
        require(discount in 0.0..100.0) { "Discount must be between 0 and 100" }
    }

    // Precio con el descuento aplicado, sin modificar el producto
    fun finalPrice(): Double = price * (1 - discount / 100)

    // Actualiza el precio con el valor descontado
    fun applyDiscount() {
        price = finalPrice()
    }
}

fun main() {
    val laptop = Product("Portátil", 800.0, 25.0)
    println("${laptop.name}: precio ${laptop.price} € · precio final ${laptop.finalPrice()} €")
    laptop.applyDiscount()
    println("Tras aplicar el descuento: ${laptop.price} €")

    val mouse = Product("Ratón", 20.0)   // sin descuento: usa el valor por defecto 0
    println("${mouse.name}: precio final ${mouse.finalPrice()} €")

    try {
        Product("Teclado", -10.0)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        Product("Monitor", 150.0, 120.0)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }

    try {
        laptop.price = -1.0
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
