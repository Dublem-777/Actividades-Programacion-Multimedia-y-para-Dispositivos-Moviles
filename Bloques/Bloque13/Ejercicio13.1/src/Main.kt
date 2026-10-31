data class ComplexNumber(val real: Double, val imaginary: Double) {

    // (a + bi) + (c + di) = (a + c) + (b + d)i
    operator fun plus(other: ComplexNumber): ComplexNumber =
        ComplexNumber(real + other.real, imaginary + other.imaginary)

    // Formato a + bi (o a - bi si la parte imaginaria es negativa)
    override fun toString(): String =
        if (imaginary >= 0) "$real + ${imaginary}i" else "$real - ${-imaginary}i"
}

fun main() {
    val a = ComplexNumber(3.0, 2.0)
    val b = ComplexNumber(1.5, -4.0)
    val sum = a + b    // equivale a a.plus(b)
    println("($a) + ($b) = $sum")
    println("a sigue valiendo: $a")

    // += también funciona: se traduce a total = total + b
    var total = ComplexNumber(0.0, 0.0)
    total += a
    total += b
    total += ComplexNumber(1.0, 1.0)
    println("Suma acumulada: $total")
}
