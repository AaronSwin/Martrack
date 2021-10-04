package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_portview.*
import kotlinx.android.synthetic.main.activity_vesselview.*

class vesselview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_vesselview)

        txtLocation.text = intent.getStringExtra("location")
        txtVesselId.text = intent.getStringExtra("vesselId")
        txtStatus.text = intent.getStringExtra("status")
        txtOther.text = intent.getStringExtra("other")
        txtVesselName.text = intent.getStringExtra("name")
        txtContainers.text = intent.getStringExtra("noContainers")

        btnVesselEdit.setOnClickListener{
            val intent = Intent(this, editVessel::class.java)

            intent.putExtra("location",txtLocation.text.toString())
            intent.putExtra("vesselId",txtVesselId.text.toString())
            intent.putExtra("status",txtStatus.text.toString())
            intent.putExtra("other",txtOther.text.toString())
            intent.putExtra("name",txtVesselName.text.toString())
            intent.putExtra("noContainers",txtContainers.text.toString())

            startActivity(intent)
        }
    }


}