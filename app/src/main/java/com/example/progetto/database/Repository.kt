package com.example.progetto.database

import com.example.progetto.database.dao.VolumeDao
import com.example.progetto.database.dao.WiFiLTEDao
import com.example.progetto.database.entity.VolumeEntity
import com.example.progetto.database.entity.WiFiLTEEntity

class Repository(
    private val wiFiLTEDao: WiFiLTEDao,
    private val volumeDao: VolumeDao
) {

    suspend fun insertWiFiLTE(wiFiLTEEntity: WiFiLTEEntity) {
        wiFiLTEDao.insertWiFiLTE(wiFiLTEEntity)
    }

    suspend fun getAllWiFiLTE(): List<WiFiLTEEntity> {
        return wiFiLTEDao.getAllWiFiLTE()
    }

    suspend fun insertVolume(volumeEntity: VolumeEntity) {
        volumeDao.insertVolume(volumeEntity)
    }

    suspend fun getAllVolumes(): List<VolumeEntity> {
        return volumeDao.getAllVolumes()
    }
}