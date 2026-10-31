class Person(val name: String?)

fun getNameLength(person: Person?): Int {
    return person?.name?.length ?: 0
}

fun main() {
    val person1: Person? = Person("Ana")
    val person2: Person? = Person(null)
    val person3: Person? = null

    println(getNameLength(person1))
    println(getNameLength(person2))
    println(getNameLength(person3))
}
