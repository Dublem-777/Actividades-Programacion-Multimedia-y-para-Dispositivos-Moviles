import kotlin.math.pow

// A = P * (1 + r / n)^(n * t)
// timesPerYear (n) vale 4 por defecto y years (t) vale 1 por defecto
fun calculateCompoundInterest(
    principal: Double,
    rate: Double,
    timesPerYear: Int = 4,
    years: Int = 1,
): Double = principal * (1 + rate / timesPerYear).pow(timesPerYear * years)

fun main() {
    // Solo los obligatorios: trimestral (n = 4) durante 1 año
    val oneYear = calculateCompoundInterest(1000.0, 0.05)
    println("1000 € al 5 % durante 1 año: ${"%.2f".format(oneYear)} €")

    // Cambiando también los años: trimestral durante 10 años
    val tenYears = calculateCompoundInterest(1000.0, 0.05, 4, 10)
    println("1000 € al 5 % durante 10 años: ${"%.2f".format(tenYears)} €")
}
