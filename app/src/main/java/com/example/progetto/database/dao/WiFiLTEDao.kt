package com.example.progetto.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.progetto.database.entity.WiFiLTEEntity


@Dao
interface WiFiLTEDao {

    @Insert
    suspend fun insertWiFiLTE(wiFiLTEEntity: WiFiLTEEntity)

    @Query("SELECT * FROM wifi_lte")
    suspend fun getAllWiFiLTE(): List<WiFiLTEEntity>
}