inline fun executeWithTimer(action: () -> Unit) {
    println("Starting timer...")
    action()
    println("Timer finished.")
}

fun nonLocalReturnDemo() {
    executeWithTimer {
        println("Inside Action 1")
        return                                   // non-local return: sale de nonLocalReturnDemo()
        println("This should not be printed.")
    }
    println("Main continues here.")              // no se ejecuta
}

fun localReturnDemo() {
    executeWithTimer {
        println("Inside Action 2")
        return@executeWithTimer                  // retorno local: solo sale de la lambda
    }
    println("Main finished properly.")           // sí se ejecuta
}

fun main() {
    nonLocalReturnDemo()
    println("-----")
    localReturnDemo()
}
