package es.iessaladillo.pedrojoya.practicalogin

import android.app.Dialog
import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.snackbar.Snackbar
import es.iessaladillo.pedrojoya.practicalogin.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {

    companion object {
        // El único usuario válido del enunciado
        private const val VALID_USERNAME = "baldomero"
        private const val VALID_PASSWORD = "llegateligero"
    }

    private val binding: MainActivityBinding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setupViews()
    }

    private fun setupViews() {
        // Al escribir en un campo desaparece su error y vuelve "* required"
        binding.txtUsername.doAfterTextChanged { binding.tilUsername.error = null }
        binding.txtPassword.doAfterTextChanged { binding.tilPassword.error = null }
        // Done del teclado en pantalla o Enter físico: igual que pulsar "Login"
        binding.txtPassword.setOnEditorActionListener { _, actionId, keyEvent ->
            when (actionId) {
                EditorInfo.IME_ACTION_DONE -> {
                    login()
                    true
                }
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

    private fun login() {
        val username = binding.txtUsername.text.toString()
        val password = binding.txtPassword.text.toString()
        if (!validateFields(username, password)) {
            return
        }
        hideSoftKeyboard()
        if (username == VALID_USERNAME && password == VALID_PASSWORD) {
            showLoggedIn(username)
        } else {
            Snackbar.make(binding.root, R.string.main_user_not_found, Snackbar.LENGTH_SHORT).show()
        }
    }

    // Pone el error en cada campo vacío y devuelve true si los dos son válidos
    private fun validateFields(username: String, password: String): Boolean {
        val isUsernameValid = username.isNotBlank()
        val isPasswordValid = password.isNotBlank()
        binding.tilUsername.error = if (isUsernameValid) null else getString(R.string.main_blank_username)
        binding.tilPassword.error = if (isPasswordValid) null else getString(R.string.main_invalid_password)
        // El foco va al primer campo incorrecto
        if (!isUsernameValid) {
            binding.txtUsername.requestFocus()
        } else if (!isPasswordValid) {
            binding.txtPassword.requestFocus()
        }
        return isUsernameValid && isPasswordValid
    }

    private fun showLoggedIn(username: String) {
        Snackbar.make(binding.root, R.string.main_user_logged_in, Snackbar.LENGTH_LONG)
            .setAction(R.string.main_show) { showUserData(username) }
            .show()
    }

    private fun showUserData(username: String) {
        val dialog: Dialog = MaterialAlertDialogBuilder(this)
            .setTitle(R.string.main_user_data)
            .setMessage(getString(R.string.main_logged_in_as, username))
            .setPositiveButton(R.string.main_accept, null)
            .create()
        dialog.show()
    }
}
