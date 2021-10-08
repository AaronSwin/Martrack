package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_edit_port.*
import kotlinx.android.synthetic.main.activity_edit_region.*
import kotlinx.android.synthetic.main.activity_region_view.*
import kotlinx.android.synthetic.main.activity_region_view.txtRegionId

class editRegion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_region)


        txtEditRegionId.setText(intent.getStringExtra("id"))
        txtEditRegionName.setText(intent.getStringExtra("name"))

        btnRegionSave.setOnClickListener{
                var region = Storage.RegionSearch(txtEditRegionId.text.toString())
                region?.name = txtEditRegionName.text.toString()


                val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/region/" + txtEditRegionId.text.toString()
                //val url = "https://martrack.free.beeceptor.com"
                Storage.updateVessel(this,json(),url)
        }
    }
    fun json(): String {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val RegionNew = Region(txtEditRegionId.text.toString().toInt(), txtEditRegionName.text.toString())
        val RegionJson: String = gson.toJson(RegionNew)
        return RegionJson

    }
}