package com.example.test


import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.internal.view.SupportSubMenu
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import java.io.IOException
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

    fun loadall(context: Context){
        loadVessel(context)
        loadPort(context)
        loadRegion(context)
    }
    fun Portparse(response: MutableList<Port>){
        this.portList = response
    }
    fun Vesselparse(response: MutableList<Vessel>){
        this.vesselList = response
    }
    fun Regionparse(response: MutableList<Region>){
        this.regionList = response
    }

    fun loadVessel(context: Context){
        val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/vessel"
        val request = okhttp3.Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: okhttp3.Response) {
                var body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()

                val vessel = gson.fromJson(body, vesselList::class.java)

                Vesselparse(vessel)

            }


            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }

    fun loadPort(context: Context){
        val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/port"
        val request = okhttp3.Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: okhttp3.Response) {

                var body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val Ports = gson.fromJson(body, portList::class.java)

                Portparse(Ports)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }

    fun loadRegion(context: Context){
        val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/region"
        val request = okhttp3.Request.Builder().url(url).build()
        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: okhttp3.Response) {
                var body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val Region = gson.fromJson(body, regionList::class.java)


                Regionparse(Region)
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }


}

class vesselList(val vessels: List<Vessel>)
class portList(val ports: List<Port>)
class regionList(val regions: List<Vessel>)

