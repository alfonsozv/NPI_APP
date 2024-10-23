package com.example.npi.ui.parlante

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.npi.databinding.FragmentParlanteBinding

// Definición de la clase ParlanteFragment, que extiende Fragment
class ParlanteFragment : Fragment() {

    // Variable privada que guarda la referencia al binding (vistas del layout)
    private var _binding: FragmentParlanteBinding? = null

    // Propiedad que devuelve el binding no nulo, se asegura que _binding no es null
    private val binding get() = _binding!!

    // Método que se llama cuando se crea la vista del fragmento
    override fun onCreateView(
        inflater: LayoutInflater, // Infla el layout XML en una vista de Kotlin
        container: ViewGroup?, // El contenedor donde va el fragmento
        savedInstanceState: Bundle? // Estado guardado (opcional)
    ): View {
        // Obtiene el ViewModel que contiene datos para este fragmento
        val parlanteViewModel =
            ViewModelProvider(this).get(ParlanteViewModel::class.java)

        // Infla el layout del fragmento y lo asigna a _binding
        _binding = FragmentParlanteBinding.inflate(inflater, container, false)

        // Guarda la raíz del layout inflado en la variable root
        val root: View = binding.root

        // Configura la acción del botón cuando es presionado
        binding.buttonSend.setOnClickListener {
            // Obtiene el texto ingresado por el usuario en el EditText
            val message = binding.inputMessage.text.toString()

            // Si el mensaje no está vacío, realiza las siguientes acciones
            if (message.isNotEmpty()) {
                // Muestra el mensaje en el TextView textParlante
                binding.textParlante.text = message

                // Limpia el contenido de la caja de texto (EditText)
                binding.inputMessage.text.clear()
            }
        }

        // Retorna la vista inflada que se mostrará en pantalla
        return root
    }

    // Método que se llama cuando la vista se destruye (cuando el usuario sale del fragmento)
    override fun onDestroyView() {
        super.onDestroyView()
        // Establece _binding a null para evitar fugas de memoria
        _binding = null
    }
}
