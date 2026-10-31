open class Person(val name: String)

open class Employee(name: String, val id: Int): Person(name) {
    open fun getDetails(): String = "Empleado: $name (ID: $id)"
}

class Manager(
    name: String,
    id: Int,
    val department: String,
): Employee(name, id) {
    override fun getDetails(): String = "${super.getDetails()}, departamento: $department"
}

class Developer(
    name: String,
    id: Int,
    vararg programmingLanguages: String,
): Employee(name, id) {
    private var languageText = ""

    init {
        for (language in programmingLanguages) {
            if (languageText != "") {
                languageText += ", "
            }
            languageText += language
        }
    }

    override fun getDetails(): String = "${super.getDetails()}, lenguajes: $languageText"
}

fun main() {
    val employees: List<Employee> = listOf(
        Employee("Laura", 1),
        Manager("Daniel", 2, "Desarrollo"),
        Developer("Lucía", 3, "Kotlin", "Java", "Python"),
    )
    employees.forEach { println(it.getDetails()) }
}
