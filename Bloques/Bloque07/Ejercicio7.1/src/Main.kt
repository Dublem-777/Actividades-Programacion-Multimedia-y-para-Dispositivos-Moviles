class Employee(
    val firstName: String,
    val lastName: String,
    val salary: Double,
) {
    init {
        require(salary >= 0.0) { "Salary must be non-negative" }
    }
}

fun main() {
    val employee = Employee("Ada", "Lovelace", 4200.0)
    println("${employee.firstName} ${employee.lastName}: ${employee.salary}")

    val volunteer = Employee("Grace", "Hopper", 0.0)
    println("${volunteer.firstName} ${volunteer.lastName}: ${volunteer.salary}")

    try {
        Employee("Alan", "Turing", -5.0)
    } catch (e: IllegalArgumentException) {
        println("Error: ${e.message}")
    }
}
