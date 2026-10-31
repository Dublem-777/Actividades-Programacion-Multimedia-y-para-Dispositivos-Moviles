interface EventListener {
    fun onEventOccurred(event: String)
}

// open: para poder crear subclases (también anónimas)
open class EventManager {
    private val listeners = mutableListOf<EventListener>()

    fun registerListener(listener: EventListener) {
        listeners.add(listener)
    }

    open fun triggerEvent(event: String) {
        for (listener in listeners) {
            listener.onEventOccurred(event)
        }
    }
}

fun main() {
    // Object expression 1: un EventListener anónimo
    val listener = object : EventListener {
        override fun onEventOccurred(event: String) {
            println("Evento recibido: $event")
        }
    }

    // Instancia normal de EventManager
    val manager = EventManager()
    manager.registerListener(listener)
    manager.triggerEvent("Inicio de sesión")

    // Object expression 2: subclase anónima de EventManager con funcionalidad extra
    var triggeredCount = 0
    val loggingManager = object : EventManager() {
        override fun triggerEvent(event: String) {
            triggeredCount++
            println("[LOG] Disparando evento nº $triggeredCount: \"$event\"")
            super.triggerEvent(event)
        }
    }
    loggingManager.registerListener(listener)
    loggingManager.triggerEvent("Compra realizada")
    loggingManager.triggerEvent("Cierre de sesión")
}
