object ConfigurationManager {
    private val settings = mutableMapOf<String, String>()

    fun set(key: String, value: String) {
        settings[key] = value
    }

    fun get(key: String): String? = settings[key]

    fun describe(): String {
        var text = ""
        // entries: cada par clave-valor del mapa
        for (entry in settings.entries) {
            text += "${entry.key} = ${entry.value}\n"
        }
        return text
    }
}

fun main() {
    ConfigurationManager.set("Theme", "dark")
    ConfigurationManager.set("language", "es")
    ConfigurationManager.set("Theme", "light")   // misma clave: se sustituye el valor

    println(ConfigurationManager.get("Theme"))
    println(ConfigurationManager.get("fontSize"))   // clave que no existe
    print(ConfigurationManager.describe())
}
