package com.spiderindia.travelinsurance.vehicle

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.spiderindia.travelinsurance.common.OnItemClickListener
import com.spiderindia.travelinsurance.model.mbo.Vehicle
import com.spiderindia.travelinsurance.vehicle.VehiclePageAdapter.*
import com.spiderindia.travelinsurance.R
import com.spiderindia.travelinsurance.databinding.ItemVehicleRowBinding

class VehiclePageAdapter(val listener:OnItemClickListener<Vehicle>) : PagingDataAdapter<Vehicle, VehicleViewHolder> (diffCallback) {

    companion object {

        private val diffCallback = object : DiffUtil.ItemCallback<Vehicle>() {
            override fun areItemsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean =
                oldItem.uid == newItem.uid

            override fun areContentsTheSame(oldItem: Vehicle, newItem: Vehicle): Boolean =
                oldItem == newItem
        }
    }

    open inner class VehicleViewHolder(private val binding: ItemVehicleRowBinding):RecyclerView.ViewHolder(binding.root)
    {
        init {
            binding.root.setOnClickListener {
                listener.onClick(getItem(bindingAdapterPosition))
            }
        }

        fun onBind(position: Int) {
            val vehicle = getItem(position)
            binding.vrTitle.text =  vehicle?.vMake+" "+vehicle?.vModel
            binding.vrDescription.text = vehicle?.vYear
//            when (vehicle?.vType) {
//                "Car"-> {
//                    binding.vrImage.setImageResource(R.drawable.ic_car)
//                }
//                "Two Wheeler"-> {
//                    binding.vrImage.setImageResource(R.drawable.ic_motorcycle)
//                }
//                "Commercial"-> {
//                    binding.vrImage.setImageResource(R.drawable.ic_ads)
//                }
            }
        }

    override fun onBindViewHolder(holder: VehicleViewHolder, position: Int) {
        holder.onBind(position)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VehicleViewHolder {
        val binding = ItemVehicleRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VehicleViewHolder(binding)
    }
}