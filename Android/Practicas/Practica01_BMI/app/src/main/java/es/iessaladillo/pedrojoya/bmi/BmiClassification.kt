package es.iessaladillo.pedrojoya.bmi

// Cada clasificación sabe su nombre, su color y su imagen
enum class BmiClassification(
    val labelResId: Int,
    val colorResId: Int,
    val imageResId: Int,
) {
    UNDERWEIGHT(R.string.bmi_underweight, R.color.bmi_underweight, R.drawable.underweight),
    NORMAL_WEIGHT(R.string.bmi_normal_weight, R.color.bmi_normal_weight, R.drawable.normal_weight),
    OVERWEIGHT(R.string.bmi_overweight, R.color.bmi_overweight, R.drawable.overweight),
    OBESITY_GRADE_1(R.string.bmi_obesity1, R.color.bmi_obesity1, R.drawable.obesity1),
    OBESITY_GRADE_2(R.string.bmi_obesity2, R.color.bmi_obesity2, R.drawable.obesity2),
    OBESITY_GRADE_3(R.string.bmi_obesity3, R.color.bmi_obesity3, R.drawable.obesity3);

    companion object {
        // Límites del enunciado: cada clase llega hasta el valor indicado, sin incluirlo
        fun from(bmi: Double): BmiClassification = when {
            bmi < 18.5 -> UNDERWEIGHT
            bmi < 25.0 -> NORMAL_WEIGHT
            bmi < 30.0 -> OVERWEIGHT
            bmi < 35.0 -> OBESITY_GRADE_1
            bmi < 40.0 -> OBESITY_GRADE_2
            else -> OBESITY_GRADE_3
        }
    }
}
