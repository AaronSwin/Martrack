package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_edit_port.*
import kotlinx.android.synthetic.main.activity_edit_vessel.*
import kotlinx.android.synthetic.main.activity_vesselview.*
import kotlinx.android.synthetic.main.activity_vesselview.txtContainers
import kotlinx.android.synthetic.main.activity_vesselview.txtOther
import kotlinx.android.synthetic.main.activity_vesselview.txtStatus
import kotlinx.android.synthetic.main.activity_vesselview.txtVesselId
import kotlinx.android.synthetic.main.activity_vesselview.txtVesselName

class editVessel : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_vessel)

        txtEditLocation.setText(intent.getStringExtra("location"))
        txtEditVesselId.setText(intent.getStringExtra("vesselId"))
        txtEditStatus.setText(intent.getStringExtra("status"))
        txtEditOther.setText(intent.getStringExtra("other"))
        txtEditVesselName.setText(intent.getStringExtra("name"))
        txtEditContainers.setText(intent.getStringExtra("noContainers"))

        btnVesselSave.setOnClickListener{
            if(Storage.VesselSearch(txtEditVesselId.text.toString()) != null){
                var vessel = Storage.VesselSearch(txtEditVesselId.text.toString())
                vessel?.location = txtEditLocation.text.toString()
                vessel?.name = txtEditVesselName.text.toString()
                vessel?.noContainers = txtEditContainers.text.toString().toInt()
                vessel?.other = txtEditOther.text.toString()
                vessel?.status = txtEditStatus.text.toString()
                val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/vessel/71314113"
                Storage.updateVessel(this,json(),url)
            }
        }
    }

    fun json(): String {
        val gson = GsonBuilder().setPrettyPrinting().create()



        val vesselNew = Vessel(txtEditLocation.text.toString(),txtEditVesselId.text.toString().toInt(),txtEditStatus.text.toString(),txtEditOther.text.toString(),txtEditVesselName.text.toString(),txtEditContainers.text.toString().toInt())
        val vesselJson: String = gson.toJson(vesselNew)
        return vesselJson
    }
}
