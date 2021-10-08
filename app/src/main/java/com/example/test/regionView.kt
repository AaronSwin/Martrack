package com.example.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_region_view.*
import kotlinx.android.synthetic.main.activity_vesselview.*

class regionView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_region_view)

        txtRegionId.text = intent.getStringExtra("id")
        txtRegionName.text = intent.getStringExtra("name")

        btnRegionEdit.setOnClickListener{
            val intent = Intent(this, editRegion::class.java)

            intent.putExtra("id",txtRegionId.text.toString())
            intent.putExtra("name", txtRegionName.text.toString())

            startActivity(intent)
        }
    }
}