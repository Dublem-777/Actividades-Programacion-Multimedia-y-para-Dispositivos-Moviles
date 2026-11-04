package es.iessaladillo.pedrojoya.bmi

// Factores de conversión del enunciado
const val KG_TO_LB = 2.20462
const val M_TO_IN = 39.3701

// Fórmulas del enunciado (allí pone "width", pero es el peso)
fun calculateBmi(weight: Double, height: Double, metric: Boolean): Double =
    if (metric) {
        weight / (height * height)
    } else {
        weight * 703 / (height * height)
    }
