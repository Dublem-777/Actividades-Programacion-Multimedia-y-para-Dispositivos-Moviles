fun main() {
    // Los corchetes permiten ver los espacios de relleno
    println("[${formatTitle("Project Name")}]")

    // padString("Short", 10)
    // ↑ Error de compilación: padString se declaró private en StringUtils.kt.
    //   Una top-level function private solo es visible dentro del fichero
    //   en el que se declara, así que desde Main.kt no existe.
}
