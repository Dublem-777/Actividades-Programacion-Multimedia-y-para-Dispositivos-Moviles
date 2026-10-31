@JvmInline
value class PhoneNumber(val value: String) {
    init {
        // Exactamente 9 caracteres y todos dígitos
        require(Regex("\\d{9}").matches(value)) {
            "Phone number must contain exactly 9 digits: '$value'"
        }
    }
}

fun printPhoneNumber(phoneNumber: PhoneNumber) {
    println("Teléfono: ${phoneNumber.value}")
}

fun main() {
    val validNumber = PhoneNumber("612345678")

    val invalidInputs = listOf("12345", "6123456789", "61234567a")
    for (input in invalidInputs) {
        try {
            PhoneNumber(input)
        } catch (e: IllegalArgumentException) {
            println("Número inválido → ${e.message}")
        }
    }

    printPhoneNumber(validNumber)
}
