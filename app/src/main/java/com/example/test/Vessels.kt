package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_ports.*
import kotlinx.android.synthetic.main.activity_vessels.*

class Vessels : AppCompatActivity(), OnVesselItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vessels)


        val list = findViewById<RecyclerView>(R.id.viewVessel)

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(viewPort)

        list.adapter = invAdapteVessel(this)
        list.layoutManager = LinearLayoutManager(this)
    }
    private val itemTouchHelperCallback =
        object :
            ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT or ItemTouchHelper.LEFT) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                //Deletes Item
                if(direction == 8){
                    "Check custom project "
                }
                //Edits Item
                else if(direction == 4)
                {
                    "Check custom project "
                }
            }

        }

    override fun onItemClick(vessel: Vessel, position: Int) {
        TODO("Not yet implemented")
    }
}


