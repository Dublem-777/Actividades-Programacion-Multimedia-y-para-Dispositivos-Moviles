// Cada constante del enum tiene su propia descripción
enum class OrderStatus(val description: String) {
    PENDING("Order has been received"),
    PROCESSING("Order is being processed"),
    SHIPPED("Order has been shipped"),
    DELIVERED("Order has been delivered"),
    CANCELLED("Order has been cancelled");   // el ; separa las constantes de los métodos

    fun printStatus() {
        println("$name: $description")
    }
}

// status es var porque el estado del pedido cambia
class Order(val id: Int, var status: OrderStatus)

fun main() {
    val order = Order(42, OrderStatus.PENDING)
    print("Pedido ${order.id} → ")
    order.status.printStatus()

    order.status = OrderStatus.SHIPPED
    print("Pedido ${order.id} → ")
    order.status.printStatus()

    // Todos los estados posibles, con entries
    println("Estados posibles:")
    for (status in OrderStatus.entries) {
        println("  ${status.ordinal}. ${status.name}")
    }
}
