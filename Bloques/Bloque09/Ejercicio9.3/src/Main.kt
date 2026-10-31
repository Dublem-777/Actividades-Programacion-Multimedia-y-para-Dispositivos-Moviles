abstract class Animal(val name: String, val age: Int) {
    // Sin cuerpo: cada subclase debe decir qué sonido hace
    abstract fun makeSound()

    // Con cuerpo: lo heredan todas las subclases tal cual
    fun info() {
        println("$name tiene $age años")
    }
}

class Lion(name: String, age: Int) : Animal(name, age) {
    override fun makeSound() {
        println("$name ruge: ¡Roaaar!")
    }
}

class Elephant(name: String, age: Int) : Animal(name, age) {
    override fun makeSound() {
        println("$name barrita: ¡Prrrú!")
    }
}

fun main() {
    val lion = Lion("Simba", 5)
    val elephant = Elephant("Dumbo", 12)

    lion.info()
    lion.makeSound()
    elephant.info()
    elephant.makeSound()
}
