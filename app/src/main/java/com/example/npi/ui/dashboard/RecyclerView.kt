package com.example.npi.ui.dashboard

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.npi.R

// Adaptador para manejar los elementos del RecyclerView
class DashboardAdapter(private val items: List<String>) : RecyclerView.Adapter<DashboardAdapter.ViewHolder>() {

    // Clase interna que representa cada ítem
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.square_title)
    }

    // Infla el diseño del ítem
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_square, parent, false)
        return ViewHolder(view)
    }

    // Enlaza los datos a cada ítem (cuadrado)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = items[position]
    }

    // Devuelve la cantidad de ítems (cuadrados)
    override fun getItemCount(): Int = items.size
}
