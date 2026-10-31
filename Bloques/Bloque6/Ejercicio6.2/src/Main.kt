fun formatName(firstName: String, lastName: String?, nickname: String?): String {
    // Elvis: si no hay apellido se usa "" y trimEnd() quita el espacio sobrante
    val fullName: String = "$firstName ${lastName ?: ""}".trimEnd()

    // Elvis con return: si no hay apodo, se devuelve el nombre completo
    val validNickname: String = nickname ?: return fullName
    return "Nickname: $validNickname"
}

fun main() {
    println(formatName("Ada", "Lovelace", "Enchantress"))
    println(formatName("Ada", "Lovelace", null))
    println(formatName("Ada", null, null))
    println(formatName("Ada", null, "Countess"))
}
