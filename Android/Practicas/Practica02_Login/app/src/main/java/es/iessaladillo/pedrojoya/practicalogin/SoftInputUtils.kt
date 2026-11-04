package es.iessaladillo.pedrojoya.practicalogin

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager

// Copiada de los apuntes del Tema 8 (solo la función que se usa)
fun Activity.hideSoftKeyboard() {
    val view = currentFocus
    if (view != null) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
