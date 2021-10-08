package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_edit_port.*
import kotlinx.android.synthetic.main.activity_edit_vessel.*
import kotlinx.android.synthetic.main.activity_portview.*

class editPort : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_port)

        txtEditPortid.setText(intent.getStringExtra("portid"))
        txtEditCranes.setText(intent.getStringExtra("cranes"))
        txtEditPortName.setText(intent.getStringExtra("name"))
        txtEditPortStay.setText(intent.getStringExtra("portStay"))
        txtEditPortRegionId.setText(intent.getStringExtra("regionID"))

        btnPortSave.setOnClickListener{
            if(Storage.PortSearch(txtEditPortid.text.toString()) != null){
                var port = Storage.PortSearch(txtEditPortid.text.toString())
                port?.gantryCranes = txtEditCranes.text.toString().toInt()
                port?.name = txtEditPortName.text.toString()
                port?.portStay = txtEditPortStay.text.toString().toInt()

                val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/port/" + txtEditPortid.text.toString()
                Storage.updateVessel(this,json(),url)
            }
        }
    }
    fun json(): String {
        val gson = GsonBuilder().setPrettyPrinting().create()
        val PortNew = Port(txtEditPortid.text.toString().toInt(),txtEditCranes.text.toString().toInt(),txtEditPortName.text.toString(),txtEditPortStay.text.toString().toInt(),txtEditPortRegionId.text.toString())
        val PortJson: String = gson.toJson(PortNew)
        return PortJson

    }
}