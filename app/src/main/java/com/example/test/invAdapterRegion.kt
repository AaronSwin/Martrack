package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class invAdapterRegion(var clickListener: OnRegionItemClickListener): RecyclerView.Adapter<invAdapterRegion.ViewHolder>() {


    inner class ViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        val RegionName = v.findViewById<TextView>(R.id.txtRecylerName)
        val RegionNumber = v.findViewById<TextView>(R.id.txtRecyclerPrice)

        fun bind(region: Region,action: OnRegionItemClickListener){

            RegionName.text = region.name
            RegionNumber.text = region.regionId.toString()

            v.setOnClickListener {
                action.onItemClick(region,adapterPosition)
            }
        }
    }

    //
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
            //Name of layout used for recycler view
            .inflate(R.layout.inventory_l_layout,parent,false) as View
        return ViewHolder(view)
    }

    override fun getItemCount():Int{
        return Storage.RegionList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(Storage.RegionList[position],clickListener)
    }

}

interface OnRegionItemClickListener{
    /*fix int */
    fun onItemClick(region: Region , position: Int)
}