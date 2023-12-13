package com.example.progetto.database.entity

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "volume")
data class VolumeEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val position: String,
    val data: Date,
    val value: Int
) {
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<VolumeEntity>() {
            override fun areItemsTheSame(oldItem: VolumeEntity, newItem: VolumeEntity): Boolean {
                return oldItem.id == newItem.id // O il campo che identifica univocamente l'oggetto
            }

            override fun areContentsTheSame(oldItem: VolumeEntity, newItem: VolumeEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}