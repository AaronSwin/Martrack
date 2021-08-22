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
            /* Check custom app */
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater
                /*fix*/
            .inflate(R.layout.activity_maps,parent,false) as View
        return ViewHolder(view)
    }

    override fun getItemCount(): Int =  0 /*inventory.count()*/


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

}

interface OnPortItemClickListener{
    /*fix int */
    fun onItemClick(item: Int , position: Int)
}
