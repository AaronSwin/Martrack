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
import kotlinx.android.synthetic.main.activity_vesselview.*

class Vessels : AppCompatActivity(), OnVesselItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vessels)


        val list = findViewById<RecyclerView>(R.id.viewVessel)

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(viewVessel)

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
                    val Url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/vessel/" + Storage.VesselList.elementAt(viewHolder.adapterPosition).vesselId.toString()

                    Storage.deleteVessel(Url)
                    Storage.VesselList.removeAt(viewHolder.adapterPosition)

                    viewVessel.adapter?.notifyDataSetChanged()
                }
                //Edits Item
                else if(direction == 4)
                {
                    val Vessel = Storage.VesselList.elementAt(viewHolder.adapterPosition)
                    val intent = Intent(this@Vessels,editVessel::class.java)

                    intent.putExtra("location",Vessel.location.toString())
                    intent.putExtra("vesselId",Vessel.vesselId.toString())
                    intent.putExtra("status",Vessel.status.toString())
                    intent.putExtra("other",Vessel.other.toString())
                    intent.putExtra("name",Vessel.name.toString())
                    intent.putExtra("noContainers",Vessel.noContainers.toString())

                    startActivity(intent)
                }
            }

        }

    override fun onItemClick(vessel: Vessel, position: Int) {
        val intent = Intent(this, vesselview::class.java)

        intent.putExtra("location",vessel.location)
        intent.putExtra("vesselId",vessel.vesselId.toString())
        intent.putExtra("status",vessel.status)
        intent.putExtra("other",vessel.other.toString())
        intent.putExtra("name",vessel.name.toString())
        intent.putExtra("noContainers",vessel.noContainers.toString())

        startActivity(intent)
    }
}


