package com.example.progetto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.progetto.databinding.FragmentWifilteBinding

// Dentro il fragment WiFiLTEFragment.kt

class WiFiLTEFragment : Fragment() {
    private lateinit var binding: FragmentWifilteBinding  // Assicurati di utilizzare il nome corretto del tuo layout binding

    // ...

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWifilteBinding.inflate(inflater, container, false)
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
