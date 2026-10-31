data class Employee(val name: String, val department: String, val salary: Double)

val employees = listOf(
    Employee("Ana", "IT", 72000.0),
    Employee("Bruno", "HR", 48000.0),
    Employee("Carla", "IT", 85000.0),
    Employee("David", "Sales", 61000.0),
    Employee("Alberto", "HR", 53000.0),
    Employee("Elena", "IT", 67000.0),
)

fun main() {
    // filter + map encadenados
    val itNames = employees
        .filter { it.department == "IT" }
        .map { it.name }
    println("Empleados de IT: $itNames")

    val allAbove60k = employees.all { it.salary > 60000.0 }
    println("¿Todos cobran más de 60000? $allAbove60k")

    val hrCount = employees.count { it.department == "HR" }
    println("Empleados de HR: $hrCount")

    // Ordenar de mayor a menor salario y quedarse con los dos primeros
    println("Los dos mejor pagados:")
    employees
        .sortedByDescending { it.salary }
        .take(2)
        .forEach { println("  ${it.name}: ${it.salary}") }

    // find devuelve el primero que cumple, o null
    val firstWithA = employees.find { it.name.startsWith("A") }
    println("Primer empleado que empieza por A: ${firstWithA?.name ?: "ninguno"}")

    // Mismo find, sin coincidencias, para ver el mensaje de null
    val firstWithZ = employees.find { it.name.startsWith("Z") }
    println("Primer empleado que empieza por Z: ${firstWithZ?.name ?: "ninguno"}")
}
