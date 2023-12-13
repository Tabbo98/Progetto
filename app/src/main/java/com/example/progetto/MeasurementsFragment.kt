package com.example.progetto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.progetto.database.AppDatabase
import com.example.progetto.databinding.FragmentMeasurementsBinding
import com.example.progetto.database.viewModel.MyViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.progetto.database.Repository
import com.example.progetto.database.viewModel.MyViewModelFactory

class MeasurementsFragment : Fragment() {
    private lateinit var binding: FragmentMeasurementsBinding
    private val viewModel: MyViewModel by viewModels {
        MyViewModelFactory(
            Repository(
                AppDatabase.getInstance(requireContext()).wiFiLTEDao(),
                AppDatabase.getInstance(requireContext()).volumeDao()
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMeasurementsBinding.inflate(inflater, container, false)
        val view = binding.root

        val wifiAdapter = WiFiLTEAdapter()
        val volumeAdapter = VolumeAdapter()

        // Ottieni i dati del database e aggiorna gli adapter delle RecyclerView
        viewLifecycleOwner.lifecycleScope.launch(Dispatchers.Main) {
            try {
                val wifiLTEList = viewModel.getAllWiFiLTE()
                val volumeList = viewModel.getAllVolumes()

                // Imposta l'adapter per le RecyclerView
                binding.recyclerViewWiFiLTE.adapter = wifiAdapter
                binding.recyclerViewVolume.adapter = volumeAdapter

                // Imposta il layout manager per le RecyclerView
                binding.recyclerViewWiFiLTE.layoutManager = LinearLayoutManager(requireContext())
                binding.recyclerViewVolume.layoutManager = LinearLayoutManager(requireContext())

                wifiAdapter.submitList(wifiLTEList)
                volumeAdapter.submitList(volumeList)

            } catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(requireContext(), "Si è verificato un errore", Toast.LENGTH_SHORT).show()
            }
        }
        return view
    }
}

