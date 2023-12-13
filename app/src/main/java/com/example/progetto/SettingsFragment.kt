package com.example.progetto

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Switch
import android.widget.Toast

class SettingsFragment : Fragment() {

    private lateinit var switchAutomaticMeasurements: Switch
    private lateinit var editTextIntervalValue: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        switchAutomaticMeasurements = view.findViewById(R.id.switchAutomaticMeasurements)
        editTextIntervalValue = view.findViewById(R.id.editTextIntervalValue)
        saveButton = view.findViewById(R.id.button)

        saveButton.setOnClickListener {
            saveSettings()
        }

        return view
    }

    private fun saveSettings() {
        val isSwitchChecked = switchAutomaticMeasurements.isChecked
        val intervalValue = editTextIntervalValue.text.toString()

        if (isSwitchChecked) {
            if (intervalValue.isNotEmpty()) {
                // Salva i dati se lo switch è attivato e l'EditText contiene un numero
                // Esegui l'azione necessaria per salvare i dati
                Toast.makeText(requireContext(), "Dati salvati", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Inserisci un valore nella EditText", Toast.LENGTH_SHORT).show()
            }
        } else {
            // Salva i dati se lo switch è disattivato
            // Esegui l'azione necessaria per salvare i dati
            Toast.makeText(requireContext(), "Dati salvati", Toast.LENGTH_SHORT).show()
        }
    }
}
