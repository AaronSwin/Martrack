package com.example.test

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.text.NumberFormat
import java.util.*

class invAdaptePort(var clickListener: OnPortItemClickListener): RecyclerView.Adapter<invAdaptePort.ViewHolder>() {


    inner class ViewHolder(val v: View): RecyclerView.ViewHolder(v) {
        val PortName = v.findViewById<TextView>(R.id.txtRecylerName)
        val PortNumber = v.findViewById<TextView>(R.id.txtRecyclerPrice)

        fun bind(port: Port,action: OnPortItemClickListener){


            PortName.text = port.name
            PortNumber.text = port.portId.toString()

            v.setOnClickListener {
                action.onItemClick(port,adapterPosition)
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
        return Storage.PortList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bind(Storage.PortList[position],clickListener)
    }

}

interface OnPortItemClickListener{
    /*fix int */
    fun onItemClick(port: Port , position: Int)
}
