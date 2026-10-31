enum class Priority { LOW, MEDIUM, HIGH }

sealed class UserAlert

// Subclases directas, en el mismo archivo que UserAlert
data class EmailAlert(val sender: String, val priority: Priority) : UserAlert()

data class SmsAlert(val phoneNumber: String, val priority: Priority) : UserAlert()

object SystemMaintenance : UserAlert()

fun processAlert(alert: UserAlert) {
    // when exhaustivo: cubre todos los subtipos, así que no necesita else
    when (alert) {
        is EmailAlert -> println("Email de ${alert.sender} (prioridad ${alert.priority})")
        is SmsAlert -> println("SMS al ${alert.phoneNumber} (prioridad ${alert.priority})")
        SystemMaintenance -> println("Scheduled downtime starting now.")
    }
}

fun main() {
    processAlert(EmailAlert("admin@example.com", Priority.HIGH))
    processAlert(SmsAlert("612345678", Priority.MEDIUM))
    processAlert(SystemMaintenance)
}
