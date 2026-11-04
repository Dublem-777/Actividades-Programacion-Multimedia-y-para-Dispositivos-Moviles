package es.iessaladillo.pedrojoya.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.iessaladillo.pedrojoya.helloworld.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    // El binding se infla la primera vez que se usa
    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        // El texto sale de un recurso de cadena, no de un literal
        binding.lblMessage.setText(R.string.main_wonderful)
    }
}
