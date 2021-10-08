package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_ports.*
import kotlinx.android.synthetic.main.activity_portview.*
import kotlinx.android.synthetic.main.activity_vessels.*
import kotlinx.android.synthetic.main.activity_vessels.viewVessel

class ports : AppCompatActivity(), OnPortItemClickListener{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ports)


        val list = findViewById<RecyclerView>(R.id.viewPort)

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(viewPort)

        list.adapter = invAdaptePort(this)
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

    override fun onItemClick(port: Port, position: Int) {
        val intent = Intent(this, portview::class.java)

        intent.putExtra("portid",port.portId.toString())
        intent.putExtra("cranes",port.gantryCranes.toString())
        intent.putExtra("name",port.name.toString())
        intent.putExtra("portStay",port.portStay.toString())
        intent.putExtra("regionID",port.regionId)

        startActivity(intent)
    }
}
