// Top-level property: está fuera de cualquier clase y debe inicializarse al declararla
var sessionCount: Int = 0

fun startNewSession() {
    sessionCount++
}

fun getSessionReport(): String = "Total sessions started: $sessionCount"

fun main() {
    startNewSession()
    startNewSession()
    startNewSession()
    println(getSessionReport())

    startNewSession()
    println(getSessionReport())
}
