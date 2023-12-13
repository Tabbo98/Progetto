package com.example.progetto

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.progetto.databinding.FragmentVolumeBinding

class VolumeFragment : Fragment() {
    private lateinit var binding: FragmentVolumeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentVolumeBinding.inflate(inflater, container, false)
        val view = binding.root

        // Trova le TextView nel layout utilizzando il binding
        val textViewLastMeasurement = binding.textViewLastMeasurement
        val textViewPreviousMeasurement = binding.textViewPreviousMeasurement

        val floatingActionButton = binding.floatingActionButton

        floatingActionButton.setOnClickListener {
            // Quando il floating action button viene premuto,
            // ottieni un nuovo dato di misurazione
            val newMeasurement = ottieniNuovaMisurazione()

            // Trasferisci il valore corrente di LastMeasurement a PreviousMeasurement
            textViewPreviousMeasurement.text = textViewLastMeasurement.text

            // Aggiorna LastMeasurement con il nuovo dato
            textViewLastMeasurement.text = newMeasurement
        }

        return view
    }

    // Simulazione della funzione per ottenere una nuova misurazione
    private fun ottieniNuovaMisurazione(): String {
        // Qui dovresti implementare la logica effettiva per ottenere un nuovo dato di misurazione
        return "Nuova misurazione"
    }
}
