package com.example.test


import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import java.security.AccessControlContext

object Storage {

    var portList = mutableListOf<Port>()
    var vesselList = mutableListOf<Vessel>()
    var regionList = mutableListOf<Region>()
    //Adds Vessel to list
    fun Add(vessel: Vessel) {
        vesselList.add(vessel)
    }
    //Adds Port to list
    fun Add(port: Port){
        portList.add(port)
    }
    //Adds region to list
    fun Add(region: Region){
        regionList.add(region)
    }
    //gets count of each list in array
    fun Count():Array<Int>{
        return arrayOf(portList.size, vesselList.size, regionList.size)
    }


    fun Load(context: Context){
    //TODO
    }

}