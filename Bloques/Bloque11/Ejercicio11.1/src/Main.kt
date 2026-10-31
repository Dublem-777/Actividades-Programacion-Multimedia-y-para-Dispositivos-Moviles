class PhysicsConstants {
    companion object {
        // Velocidad de la luz en el vacío (c), en m/s
        const val SPEED_OF_LIGHT = 299_792_458
        // Constante de Planck (h), en J·s
        const val PLANCK_CONSTANT = 6.62607015e-34
        // Constante de gravitación universal (G), en m³/(kg·s²)
        const val GRAVITATIONAL_CONSTANT = 6.67430e-11
    }
}

fun main() {
    println("c = ${PhysicsConstants.SPEED_OF_LIGHT} m/s")
    println("h = ${PhysicsConstants.PLANCK_CONSTANT} J·s")
    println("G = ${PhysicsConstants.GRAVITATIONAL_CONSTANT} m³/(kg·s²)")
}
