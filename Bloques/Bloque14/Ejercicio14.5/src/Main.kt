fun interface DataValidator {
    fun isValid(input: String): Boolean
}

class ValidationService {
    fun check(value: String, validator: DataValidator): Boolean {
        println("Checking value: '$value'")
        return validator.isValid(value)
    }
}

fun main() {
    val service = ValidationService()

    // Cada lambda (String) -> Boolean se convierte en un DataValidator (conversión SAM)
    val isLongEnough = service.check("kotlin") { it.length > 5 }
    val containsA = service.check("java") { 'a' in it }

    println("¿\"kotlin\" tiene más de 5 caracteres? $isLongEnough")
    println("¿\"java\" contiene la letra 'a'? $containsA")
}
