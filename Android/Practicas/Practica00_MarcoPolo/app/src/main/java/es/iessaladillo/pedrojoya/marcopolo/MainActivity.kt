package es.iessaladillo.pedrojoya.marcopolo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.marcopolo.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    // true mientras la etiqueta muestra "Marco" (y el botón "Polo")
    private var showingMarco: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        binding.btnToggle.setOnClickListener { toggle() }
        showWords()
    }

    private fun toggle() {
        showingMarco = !showingMarco
        showWords()
    }

    private fun showWords() {
        // La etiqueta y el botón siempre muestran palabras opuestas
        if (showingMarco) {
            binding.lblMessage.setText(R.string.main_marco)
            binding.btnToggle.setText(R.string.main_polo)
        } else {
            binding.lblMessage.setText(R.string.main_polo)
            binding.btnToggle.setText(R.string.main_marco)
        }
    }
}
