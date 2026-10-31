interface Device {
    val brand: String                                      // propiedad abstracta
    fun turnOn() = println("Turning on the device")        // con código por defecto
    fun turnOff()                                          // sin implementación
}

// SmartDevice hereda todo lo de Device y añade más
interface SmartDevice : Device {
    val os: String
    fun connectToWiFi() = println("Connecting to WiFi")
}

class Smartphone(
    override val brand: String,
    override val os: String,
) : SmartDevice {
    // Obligatorio: turnOff() no tenía implementación
    override fun turnOff() = println("Turning off the $brand smartphone")

    // Opcional: sobrescribimos turnOn() reutilizando el código por defecto
    override fun turnOn() {
        super.turnOn()
        println("$brand is booting $os")
    }
}

fun main() {
    val phone = Smartphone("Pixel", "Android")
    println("Marca: ${phone.brand} · Sistema: ${phone.os}")
    phone.turnOn()
    phone.connectToWiFi()
    phone.turnOff()
}
