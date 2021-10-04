package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.*

class invAdapteVessel(var clickListener: OnVesselItemClickListener): RecyclerView.Adapter<invAdapteVessel.ViewHolder>() {


    inner class ViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        val VesselName = v.findViewById<TextView>(R.id.txtRecylerName)
        val VesselNumber = v.findViewById<TextView>(R.id.txtRecyclerPrice)

        fun bind(vessel: Vessel,action: OnVesselItemClickListener){

            VesselName.text = vessel.name
            VesselNumber.text = vessel.vesselId.toString()

            v.setOnClickListener {
                action.onItemClick(vessel,adapterPosition)
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
        return Storage.VesselList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(Storage.VesselList[position],clickListener)
    }

}

interface OnVesselItemClickListener{
    /*fix int */
    fun onItemClick(vessel: Vessel , position: Int)
}