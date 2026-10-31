sealed class Payment {
    data class CreditCardPayment(
        val cardNumber: String,
        val cardHolder: String,
        val amount: Double,
    ) : Payment()

    data class PaypalPayment(val email: String, val amount: Double) : Payment()

    data class CashPayment(val amount: Double) : Payment()
}

fun processPayment(payment: Payment) {
    // Gracias al smart cast, dentro de cada rama se accede a las propiedades del subtipo
    when (payment) {
        is Payment.CreditCardPayment ->
            println("Tarjeta de ${payment.cardHolder} (**** ${payment.cardNumber.takeLast(4)}): ${payment.amount} €")
        is Payment.PaypalPayment ->
            println("PayPal de ${payment.email}: ${payment.amount} €")
        is Payment.CashPayment ->
            println("Pago en efectivo: ${payment.amount} €")
    }
}

fun main() {
    processPayment(Payment.CreditCardPayment("4111222233334444", "Ada Lovelace", 25.0))
    processPayment(Payment.PaypalPayment("ada@example.com", 15.5))
    processPayment(Payment.CashPayment(10.0))
}
