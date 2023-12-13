package com.example.progetto.database.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.progetto.database.Repository
import com.example.progetto.database.dao.VolumeDao
import com.example.progetto.database.dao.WiFiLTEDao
import com.example.progetto.database.entity.VolumeEntity
import com.example.progetto.database.entity.WiFiLTEEntity
import kotlinx.coroutines.launch
import java.util.Date

class MyViewModel(private val repository: Repository) : ViewModel() {

    fun insertWiFiLTE(position: String, value: Int) {
        viewModelScope.launch {
            repository.insertWiFiLTE(WiFiLTEEntity(position = position, data = Date(), value = value))
        }
    }

    suspend fun getAllWiFiLTE(): List<WiFiLTEEntity> {
        return repository.getAllWiFiLTE()
    }

    fun insertVolume(position: String, value: Int) {
        viewModelScope.launch {
            repository.insertVolume(VolumeEntity(position = position, data = Date(), value = value))
        }
    }

    suspend fun getAllVolumes(): List<VolumeEntity> {
        return repository.getAllVolumes()
    }
}
