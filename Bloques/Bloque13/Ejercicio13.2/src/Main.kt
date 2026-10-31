class Database {
    // La lambda solo se ejecuta la primera vez que se lee connection
    val connection: String by lazy {
        println(">> Conectando con la base de datos...")
        "Conexión activa"
    }

    fun executeQuery(query: String) {
        println("Ejecutando: $query")
        println("Estado de la conexión: $connection")
    }
}

fun main() {
    val database = Database()
    println("Objeto Database creado (todavía sin conexión)")

    database.executeQuery("SELECT * FROM users")
    database.executeQuery("SELECT * FROM products")
    database.executeQuery("DELETE FROM logs")
}
