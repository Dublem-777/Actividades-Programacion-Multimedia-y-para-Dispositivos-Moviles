class Employee(
    val firstName: String,
    val lastName: String,
    val salary: Double,
) {
    init {
        require(salary >= 0.0) { "Salary must be non-negative" }
    }

    constructor(text: String): this(
        text.split("-")[0],
        text.split("-")[1],
        text.split("-")[2].toDouble(),
    )
}

fun main() {
    val employee = Employee("Ada-Lovelace-4200.0")
    println("${employee.firstName}, ${employee.lastName}, ${employee.salary}")
}
