data class Employee(
    val id: Int,
    val name: String,
    val position: String,
    val salary: Double,
)

fun main() {
    val employee = Employee(1, "Ada Lovelace", "Programadora", 4200.0)

    // Desestructuración: cada variable recibe una propiedad, por orden.
    // _ descarta las que no necesitamos (id y position)
    val (_, name, _, salary) = employee

    println("Nombre: $name")
    println("Salario: $salary €")
}
