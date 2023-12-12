package com.example.nativeandroid.data

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nativeandroid.databinding.RecyclerLayoutBinding

class DataAdapter : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {
    var items = ArrayList<CoworkingSpace>()

    fun setData(data : ArrayList<CoworkingSpace>){
        this.items = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = RecyclerLayoutBinding.inflate(layoutInflater)
        return MyViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }


    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class MyViewHolder(val binding: RecyclerLayoutBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(data: CoworkingSpace){
            binding.coworkingSpaceData = data
            binding.executePendingBindings()
        }

    }

}