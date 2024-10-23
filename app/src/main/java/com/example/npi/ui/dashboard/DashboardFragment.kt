package com.example.npi.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.npi.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: DashboardAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Obtiene el ViewModel
        val dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        // Infla el layout usando View Binding
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Configura el RecyclerView con un GridLayoutManager para mostrar 2 columnas
        binding.dashboardRecyclerView.layoutManager = GridLayoutManager(context, 2)

        // Observa los datos del ViewModel y configura el adaptador
        dashboardViewModel.items.observe(viewLifecycleOwner) { items ->
            adapter = DashboardAdapter(items)
            binding.dashboardRecyclerView.adapter = adapter
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
