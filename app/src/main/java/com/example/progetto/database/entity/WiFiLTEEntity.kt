package com.example.progetto.database.entity

import androidx.recyclerview.widget.DiffUtil
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "wifi_lte")
data class WiFiLTEEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val position: String,
    val data: Date,
    val value: Int
) {
    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<WiFiLTEEntity>() {
            override fun areItemsTheSame(oldItem: WiFiLTEEntity, newItem: WiFiLTEEntity): Boolean {
                return oldItem.id == newItem.id // O il campo che identifica univocamente l'oggetto
            }

            override fun areContentsTheSame(oldItem: WiFiLTEEntity, newItem: WiFiLTEEntity): Boolean {
                return oldItem == newItem
            }
        }
    }
}
