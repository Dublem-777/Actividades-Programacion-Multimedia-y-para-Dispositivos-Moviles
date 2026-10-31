// Extension property: no tiene backing field, así que se calcula en el getter
val String.vowelCount: Int
    get() {
        var count = 0
        for (c in this.lowercase()) {
            // "in" sobre un String se traduce a contains(c)
            if (c in "aeiouáéíóúü") {
                count++
            }
        }
        return count
    }

fun main() {
    val text = "Programación Multimedia"
    println("\"$text\" tiene ${text.vowelCount} vocales")

    // Más casos: mayúsculas, ü, sin vocales y cadena vacía
    println("\"AEIOU\" → ${"AEIOU".vowelCount}")
    println("\"Pingüino\" → ${"Pingüino".vowelCount}")
    println("\"Brrr\" → ${"Brrr".vowelCount}")
    println("\"\" → ${"".vowelCount}")
}
