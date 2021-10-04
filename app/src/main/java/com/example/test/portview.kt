package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_portview.*

class portview : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_portview)


        txtPortid.setText(intent.getStringExtra("portid"))
        txtCranes.setText(intent.getStringExtra("cranes"))
        txtName.setText(intent.getStringExtra("name"))
        txtPortStay.setText(intent.getStringExtra("portStay"))
        txtPortRegionId.setText(intent.getStringExtra("regionID"))

        btnSave.setOnClickListener{
            val intent = Intent(this, editPort::class.java)
            val test = txtName.text
            intent.putExtra("portid",txtPortid.text)
            intent.putExtra("cranes",txtCranes.text)
            intent.putExtra("name",txtName.text.toString())
            intent.putExtra("portStay",txtPortStay.text)
            intent.putExtra("regionID",txtPortRegionId.text)

            startActivity(intent)
        }
    }
}