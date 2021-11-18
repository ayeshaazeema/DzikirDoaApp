package com.ayeshaazeema.dzikirdoaapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayeshaazeema.dzikirdoaapp.databinding.ItemDzikirDoaBinding
import com.ayeshaazeema.dzikirdoaapp.model.DzikirDoa

class DzikirDoaAdapter(private val listDzikirDoa: ArrayList<DzikirDoa>) :
    RecyclerView.Adapter<DzikirDoaAdapter.MyViewHolder>() {

    inner class MyViewHolder(var itemDzikirDoaBinding: ItemDzikirDoaBinding) :
        RecyclerView.ViewHolder(itemDzikirDoaBinding.root) {
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DzikirDoaAdapter.MyViewHolder {
        val itemDzikirDoaBinding =
            ItemDzikirDoaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemDzikirDoaBinding)
    }

    override fun onBindViewHolder(holder: DzikirDoaAdapter.MyViewHolder, position: Int) {
        val qauliyah = listDzikirDoa[position]
        holder.itemDzikirDoaBinding.tvDescItem.text = qauliyah.desc
        holder.itemDzikirDoaBinding.tvLafazItem.text = qauliyah.lafaz
        holder.itemDzikirDoaBinding.tvTerjemahItem.text = qauliyah.terjemah
    }

    override fun getItemCount(): Int = listDzikirDoa.size
}