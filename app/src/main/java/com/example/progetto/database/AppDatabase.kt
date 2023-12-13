package com.example.progetto.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.progetto.database.dao.VolumeDao
import com.example.progetto.database.dao.WiFiLTEDao
import com.example.progetto.database.entity.VolumeEntity
import com.example.progetto.database.entity.WiFiLTEEntity

@Database(entities = [WiFiLTEEntity::class, VolumeEntity::class], version = 1, exportSchema = false)
@TypeConverters(DateConverters::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun wiFiLTEDao(): WiFiLTEDao
    abstract fun volumeDao(): VolumeDao

    companion object {

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "app_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
