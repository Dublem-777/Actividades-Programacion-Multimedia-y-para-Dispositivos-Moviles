package es.iessaladillo.pedrojoya.countingclicks

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.countingclicks.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    // Número de veces que se ha pulsado el botón
    private var times: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.btnClickMe.setOnClickListener { incrementTimes() }
        // Muestra el valor inicial ("0 times") nada más arrancar
        showTimes()
    }

    private fun incrementTimes() {
        times++
        showTimes()
    }

    private fun showTimes() {
        // El primer times elige singular o plural; el segundo rellena el %1$d
        binding.lblTimes.text = resources.getQuantityString(R.plurals.main_times, times, times)
    }
}
