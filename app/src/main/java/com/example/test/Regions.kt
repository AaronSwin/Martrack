package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_ports.*
import kotlinx.android.synthetic.main.activity_region_view.*
import kotlinx.android.synthetic.main.activity_regions.*
import kotlinx.android.synthetic.main.activity_vesselview.*

class Regions : AppCompatActivity(), OnRegionItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regions)

        val list = findViewById<RecyclerView>(R.id.viewRegion)

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(viewRegion)

        list.adapter = invAdapterRegion(this)
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
                    val Url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/region/" + Storage.RegionList.elementAt(viewHolder.adapterPosition).regionId.toString()

                    Storage.deleteVessel(Url)
                    Del()

                    viewRegion.adapter?.notifyDataSetChanged()
                }
                //Edits Item
                else if(direction == 4)
                {
                    val intent = Intent(this@Regions, editRegion::class.java)
                    val Region = Storage.RegionList.elementAt(viewHolder.adapterPosition)

                    intent.putExtra("id",Region.regionId.toString())
                    intent.putExtra("name", Region.name.toString())

                    startActivity(intent)
                }
            }

        }

    fun Del(){
        Storage.RegionList.clear()
    }

    override fun onItemClick(region: Region, position: Int) {
        val intent = Intent(this, regionView::class.java)

        intent.putExtra("id",region.regionId.toString())
        intent.putExtra("name",region.name.toString())

        startActivity(intent)
    }
}