package com.codmari.noter.classes

import NoteViewModel
import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

// Esta clase Factory es utilizada para crear instancias de NoteViewModel,
// proporcionando el Application context necesario para su construcción.
class NoteViewModelFactory(private val application: Application) : ViewModelProvider.Factory {

    // Método para crear una nueva instancia del ViewModel
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        // Verifica si el ViewModel solicitado es del tipo NoteViewModel
        if (modelClass.isAssignableFrom(NoteViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            // Crea y retorna una nueva instancia de NoteViewModel,
            // casteando el resultado a tipo genérico T
            return NoteViewModel(application) as T
        }
        // Si el ViewModel solicitado no es del tipo esperado, lanza una excepción
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
