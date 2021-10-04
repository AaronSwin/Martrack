package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_port.*
import kotlinx.android.synthetic.main.activity_portview.*

class editPort : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_port)

        txtEditPortid.setText(intent.getStringExtra("portid"))
        txtEditCranes.setText(intent.getStringExtra("cranes"))
        txtEditName.setText(intent.getStringExtra("name"))
        txtEditPortStay.setText(intent.getStringExtra("portStay"))
        txtEditPortRegionId.setText(intent.getStringExtra("regionID"))

        btnPortSave.setOnClickListener{
            if(Storage.PortSearch(txtEditPortid.text.toString()) != null){
                var port = Storage.PortSearch(txtEditPortid.text.toString())
                port?.gantryCranes = txtEditCranes.text.toString().toInt()
                port?.name = txtEditName.text.toString()
                port?.portStay = txtEditPortStay.text.toString().toDouble()

            }
        }
    }
}