import kotlin.math.pow

// Misma función que en el ejercicio 5
fun calculateCompoundInterest(
    principal: Double,
    rate: Double,
    timesPerYear: Int = 4,
    years: Int = 1,
): Double = principal * (1 + rate / timesPerYear).pow(timesPerYear * years)

fun main() {
    // timesPerYear va primero, así que todos los argumentos llevan nombre
    val monthly = calculateCompoundInterest(timesPerYear = 12, principal = 1000.0, rate = 0.05)
    println("1000 € al 5 % con capitalización mensual (1 año): ${"%.2f".format(monthly)} €")
}
