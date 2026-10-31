// Bisiesto: divisible entre 4 y no entre 100, o divisible entre 400
fun isLeapYear(year: Int): Boolean = (year % 4 == 0 && year % 100 != 0) || year % 400 == 0

fun main() {
    val testYears = intArrayOf(1900, 2000, 2023, 2024, 2026, 2100, 2400)
    for (year in testYears) {
        println("¿$year es bisiesto? ${isLeapYear(year)}")
    }
}
