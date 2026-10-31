class AppService {
    // Prometemos al compilador que se inicializará antes de leerla
    lateinit var configName: String

    fun initializeConfig(name: String) {
        configName = name
    }

    fun runService() {
        println("Servicio en marcha con la configuración: $configName")
    }
}

fun main() {
    val service = AppService()
    service.initializeConfig("Production_Env")
    service.runService()

    val faultyService = AppService()
    try {
        // configName nunca se ha inicializado en este objeto
        faultyService.runService()
    } catch (e: UninitializedPropertyAccessException) {
        println("Fallo: se leyó configName antes de llamar a initializeConfig()")
        println("Mensaje de la excepción: ${e.message}")
    }
}
