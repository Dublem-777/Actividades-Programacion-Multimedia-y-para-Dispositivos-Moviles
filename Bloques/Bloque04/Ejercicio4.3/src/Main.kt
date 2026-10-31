fun main() {
    print("Introduce la edad: ")
    val age: Int = readln().toInt()
    print("Introduce los ingresos anuales: ")
    val income: Double = readln().toDouble()

    // Primero se decide por la edad y, dentro, por los ingresos
    val category = when {
        age < 18 -> "Menor de edad"
        age <= 64 -> when {
            income < 20_000 -> "Joven trabajador con bajo ingreso"
            income <= 60_000 -> "Adulto trabajador con ingreso medio"
            else -> "Adulto trabajador con alto ingreso"
        }
        else -> when {
            income < 15_000 -> "Anciano con bajo ingreso"
            income <= 40_000 -> "Anciano con ingreso medio"
            else -> "Anciano con alto ingreso"
        }
    }

    println("Categoría: $category")
}
