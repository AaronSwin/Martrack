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
                    val Url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/port/" + Storage.PortList.elementAt(viewHolder.adapterPosition).portId.toString()

                    Storage.deleteVessel(Url)
                    Storage.PortList.removeAt(viewHolder.adapterPosition)

                    viewPort.adapter?.notifyDataSetChanged()
                }
                //Edits Item
                else if(direction == 4)
                {
                    val Port = Storage.PortList.elementAt(viewHolder.adapterPosition)
                    val intent = Intent(this@ports,editPort::class.java)

                    intent.putExtra("portid", Port.portId.toString())
                    intent.putExtra("cranes", Port.gantryCranes.toString())
                    intent.putExtra("name", Port.name.toString())
                    intent.putExtra("portStay", Port.portStay.toString())
                    intent.putExtra("regionID", Port.regionId.toString())

                    startActivity(intent)
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
