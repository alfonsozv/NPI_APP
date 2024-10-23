package com.example.npi.ui.parlante

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ParlanteViewModel : ViewModel() { // Asegúrate de que la clase sea ViewModel

    private val _text = MutableLiveData<String>().apply {
        value = "This is Parlante Fragment"
    }
    val text: LiveData<String> = _text
}
