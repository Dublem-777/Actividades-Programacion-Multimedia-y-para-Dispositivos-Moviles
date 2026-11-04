package es.iessaladillo.pedrojoya.bmi

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import es.iessaladillo.pedrojoya.bmi.databinding.MainActivityBinding
import java.util.Locale
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    // Último BMI calculado; null mientras no hay resultado en pantalla
    private var lastBmi: Double? = null

    // Propiedad calculada: se consulta el RadioGroup cada vez que se lee
    private val isMetric: Boolean
        get() = binding.rdgUnitSystem.checkedRadioButtonId == R.id.rdbMetric

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.rdgUnitSystem.setOnCheckedChangeListener { _, _ -> changeUnitSystem() }
        binding.chkClassification.setOnCheckedChangeListener { _, _ ->
            // Si ya hay un resultado, se repinta con o sin clasificación
            lastBmi?.let { showResult(it) }
        }
        // Al escribir en un campo desaparece su error
        binding.txtWeight.doAfterTextChanged { binding.tilWeight.error = null }
        binding.txtHeight.doAfterTextChanged { binding.tilHeight.error = null }
        // Done del teclado en pantalla o Enter físico: igual que pulsar "Calculate BMI"
        binding.txtHeight.setOnEditorActionListener { _, actionId, keyEvent ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    calculate()
                    true
                }
                EditorInfo.IME_NULL -> {
                    if (keyEvent?.action == KeyEvent.ACTION_DOWN) {
                        calculate()
                    }
                    true
                }
                else -> false
            }
        }
        binding.btnCalculate.setOnClickListener { calculate() }
        binding.btnReset.setOnClickListener { reset() }
    }

    private fun changeUnitSystem() {
        val metric = isMetric
        binding.tilWeight.suffixText = getString(if (metric) R.string.main_kg else R.string.main_lb)
        binding.tilHeight.suffixText = getString(if (metric) R.string.main_m else R.string.main_in)
        if (binding.swtConvert.isChecked) {
            convert(binding.txtWeight, if (metric) 1 / KG_TO_LB else KG_TO_LB)
            convert(binding.txtHeight, if (metric) 1 / M_TO_IN else M_TO_IN)
        }
        // El resultado que hubiera ya no corresponde a lo que hay en pantalla
        hideResult()
    }

    private fun convert(field: TextInputEditText, factor: Double) {
        // Campo vacío o no numérico: se deja como está
        val value = readValue(field) ?: return
        field.setText(String.format(Locale.US, "%.2f", value * factor))
    }

    // Admite coma o punto decimal; devuelve null si no es un número
    private fun readValue(field: TextInputEditText): Double? =
        field.text.toString().replace(',', '.').toDoubleOrNull()

    private fun calculate() {
        hideSoftKeyboard()
        val weight = validate(binding.txtWeight, binding.tilWeight, R.string.main_invalid_weight)
        val height = validate(binding.txtHeight, binding.tilHeight, R.string.main_invalid_height)
        if (weight == null || height == null) {
            // El foco va al primer campo erróneo, con su texto seleccionado (como en bmi2.png)
            val wrongField = if (weight == null) binding.txtWeight else binding.txtHeight
            wrongField.requestFocus()
            wrongField.selectAll()
            hideResult()
            return
        }
        val bmi = calculateBmi(weight, height, isMetric)
        lastBmi = bmi
        showResult(bmi)
    }

    // Devuelve el valor si es un número mayor que 0; si no, pone el error en su TextInputLayout
    private fun validate(field: TextInputEditText, layout: TextInputLayout, errorResId: Int): Double? {
        val value = readValue(field)
        return if (value == null || value <= 0.0) {
            layout.error = getString(errorResId)
            null
        } else {
            layout.error = null
            value
        }
    }

    private fun showResult(bmi: Double) {
        val withClassification = binding.chkClassification.isChecked
        if (withClassification) {
            val classification = BmiClassification.from(bmi)
            val color = ContextCompat.getColor(this, classification.colorResId)
            binding.lblResult.text = getString(
                R.string.main_bmi_classification, bmi, getString(classification.labelResId)
            )
            binding.lblResult.setBackgroundColor(color)
            binding.prgBmi.setIndicatorColor(color)
            binding.prgBmi.progress = bmi.roundToInt()
            binding.imgClassification.setImageResource(classification.imageResId)
        } else {
            binding.lblResult.text = getString(R.string.main_bmi, bmi)
            binding.lblResult.setBackgroundColor(ContextCompat.getColor(this, R.color.main_result_neutral))
        }
        binding.lblResult.isVisible = true
        binding.prgBmi.isVisible = withClassification
        binding.imgClassification.isVisible = withClassification
    }

    private fun hideResult() {
        lastBmi = null
        binding.lblResult.isVisible = false
        binding.prgBmi.isVisible = false
        binding.imgClassification.isVisible = false
    }

    private fun reset() {
        binding.txtWeight.setText("")
        binding.txtHeight.setText("")
        binding.tilWeight.error = null
        binding.tilHeight.error = null
        hideResult()
        binding.txtWeight.requestFocus()
    }
}
