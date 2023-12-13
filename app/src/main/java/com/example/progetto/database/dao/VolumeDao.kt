package com.example.progetto.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.progetto.database.entity.VolumeEntity

@Dao
interface VolumeDao {

    @Insert
    suspend fun insertVolume(volumeEntity: VolumeEntity)

    @Query("SELECT * FROM volume")
    suspend fun getAllVolumes(): List<VolumeEntity>
}