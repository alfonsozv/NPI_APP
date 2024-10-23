package com.example.npi.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    // MutableLiveData que contiene una lista de títulos para los cuadrados
    private val _items = MutableLiveData<List<String>>().apply {
        value = listOf(
            "Cuadro 1", "Cuadro 2", "Cuadro 3", "Cuadro 4",
            "Cuadro 5", "Cuadro 6", "Cuadro 7", "Cuadro 8"
        )
    }

    // LiveData que expone la lista de títulos
    val items: LiveData<List<String>> = _items
}
