// private: solo es visible dentro de este fichero (StringUtils.kt)
private fun padString(s: String, length: Int): String = s.padEnd(length, ' ')

// public (visibilidad por defecto): se puede usar desde cualquier fichero
fun formatTitle(title: String): String = padString(title, 20).uppercase()
