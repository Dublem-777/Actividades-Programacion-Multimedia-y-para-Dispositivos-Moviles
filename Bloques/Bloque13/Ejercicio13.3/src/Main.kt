// Constructor privado: desde fuera no se puede hacer Database("...")
class Database private constructor(private val url: String) {

    fun conectar() {
        println("Conectando a la base de datos en $url")
    }

    fun desconectar() {
        println("Desconectando de la base de datos en $url")
    }

    companion object {
        private const val DEFAULT_URL = "jdbc:mysql://localhost:3306/dam"

        // Única instancia: se construye la primera vez que alguien la pide
        val instance: Database by lazy {
            println(">> Creando la única instancia de Database")
            Database(DEFAULT_URL)
        }
    }
}

fun main() {
    println("Inicio del programa (la instancia aún no existe)")

    val db1 = Database.instance
    val db2 = Database.instance

    db1.conectar()
    db2.desconectar()

    // === compara referencias: ¿apuntan al mismo objeto en memoria?
    println("¿db1 y db2 son el mismo objeto? ${db1 === db2}")
}
