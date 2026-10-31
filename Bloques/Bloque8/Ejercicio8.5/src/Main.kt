class User {
    val id: Int = nextId()

    companion object {
        private var nextIdValue = 1
        private fun nextId(): Int = nextIdValue++
    }
}

fun main() {
    val first = User()
    val second = User()
    val third = User()

    println(first.id)
    println(second.id)
    println(third.id)
}
