fun main() {
    print("Introduce una cadena: ")
    val text: String = readln()

    // Rangos de códigos: de la A a la Z (65–90) y de la a a la z (97–122)
    val upperCaseCodes = 'A'.code..'Z'.code
    val lowerCaseCodes = 'a'.code..'z'.code

    // Recorremos la cadena carácter a carácter
    for (character in text) {
        when (character.code) {
            in upperCaseCodes -> println("'$character' está en mayúscula")
            in lowerCaseCodes -> println("'$character' está en minúscula")
            else -> println("'$character' no es una letra")
        }
    }
}
