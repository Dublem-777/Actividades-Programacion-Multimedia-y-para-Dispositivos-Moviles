fun main() {
    val rawNames = listOf("Alice", "bob", "Alice", "charlie", "Bob")

    // map crea una lista en minúsculas; toSet elimina los repetidos
    val normalizedNames = rawNames.map { it.lowercase() }.toSet()
    println("normalizedNames: $normalizedNames")

    // toMutableList crea una lista NUEVA que sí se puede modificar
    var editableList = normalizedNames.toMutableList()
    editableList.add("david")
    println("editableList: $editableList")
}
