package com.example.progetto

import androidx.recyclerview.widget.ListAdapter
import com.example.progetto.database.entity.WiFiLTEEntity
import com.example.progetto.databinding.ItemMeasurementBinding
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class WiFiLTEAdapter :
    ListAdapter<WiFiLTEEntity, WiFiLTEAdapter.WiFiLTEViewHolder>(WiFiLTEEntity.diffCallback) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WiFiLTEViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMeasurementBinding.inflate(inflater, parent, false)
        return WiFiLTEViewHolder(binding)
    }

    override fun onBindViewHolder(holder: WiFiLTEViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class WiFiLTEViewHolder(private val binding: ItemMeasurementBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WiFiLTEEntity) {
            binding.textViewId.text = item.id.toString()
            binding.textViewPosition.text = item.position
            binding.textViewData.text = item.data.toString()  // Modifica se necessario
            binding.textViewValue.text = item.value.toString()
        }
    }

}
