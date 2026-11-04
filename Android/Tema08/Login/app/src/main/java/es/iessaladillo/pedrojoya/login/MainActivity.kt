package es.iessaladillo.pedrojoya.login

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import es.iessaladillo.pedrojoya.login.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        // Al ganar o perder el foco, la etiqueta de su campo cambia de color
        binding.txtUsername.setOnFocusChangeListener { _, hasFocus ->
            changeColor(binding.lblUsername, hasFocus)
        }
        binding.txtPassword.setOnFocusChangeListener { _, hasFocus ->
            changeColor(binding.lblPassword, hasFocus)
        }
        binding.txtPassword.setOnEditorActionListener { _, actionId, keyEvent ->
            when (actionId) {
                // Tecla Done del teclado en pantalla: hace lo mismo que el botón Login
                EditorInfo.IME_ACTION_DONE -> {
                    login()
                    true    // evento consumido
                }
                // Enter de un teclado físico: llega al pulsar y al soltar, pero solo se actúa al pulsar
                EditorInfo.IME_NULL -> {
                    if (keyEvent?.action == KeyEvent.ACTION_DOWN) {
                        login()
                    }
                    true
                }
                else -> false
            }
        }
        binding.btnLogin.setOnClickListener { login() }
    }

    private fun changeColor(label: TextView, hasFocus: Boolean) {
        val colorResId = if (hasFocus) R.color.main_focused else R.color.main_unfocused
        label.setTextColor(ContextCompat.getColor(this, colorResId))
    }

    private fun login() {
        hideSoftKeyboard()
        val username = binding.txtUsername.text.toString()
        val password = binding.txtPassword.text.toString()
        // Se simula la conexión mostrando los datos en un Toast
        val message = getString(R.string.main_connecting, username, password)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
