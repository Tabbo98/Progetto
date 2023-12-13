package com.example.progetto

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.progetto.databinding.ItemMeasurementBinding
import com.example.progetto.database.entity.VolumeEntity


class VolumeAdapter :
    ListAdapter<VolumeEntity, VolumeAdapter.VolumeViewHolder>(VolumeEntity.diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VolumeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemMeasurementBinding.inflate(inflater, parent, false)
        return VolumeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VolumeViewHolder, position: Int) {
        val currentItem = getItem(position)
        holder.bind(currentItem)
    }

    inner class VolumeViewHolder(private val binding: ItemMeasurementBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: VolumeEntity) {
            binding.textViewId.text = item.id.toString()
            binding.textViewPosition.text = item.position
            binding.textViewData.text = item.data.toString()
            binding.textViewValue.text = item.value.toString()
        }
    }
}
