package com.example.test


import android.content.Context
import com.google.gson.GsonBuilder
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import java.io.IOException


object Storage {

    var PortList = mutableListOf<Port>()
    var VesselList = mutableListOf<Vessel>()
    var RegionList = mutableListOf<Region>()
    //Adds Vessel to list
    fun Add(vessel: Vessel) {
        VesselList.add(vessel)
    }
    //Adds Port to list
    fun Add(port: Port){
        PortList.add(port)
    }
    //Adds region to list
    fun Add(region: Region){
        RegionList.add(region)
    }
    //gets count of each list in array
    fun Count():Array<Int>{
        return arrayOf(PortList.size, VesselList.size, RegionList.size)
    }

    fun loadall(context: Context){
        loadVessel(context)
        loadPort(context)
        loadRegion(context)
    }
    fun Portparse(response: ArrayList<Port>){
        this.PortList = response
    }
    fun Vesselparse(response: MutableList<Vessel>){
        this.VesselList = response
    }
    fun Regionparse(response: MutableList<Region>){
        this.RegionList = response
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


                val vesselz: List<Vessel> = gson.fromJson(body, Array<Vessel>::class.java).toList()
                VesselList = vesselz as MutableList<Vessel>;

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
                val Portz: List<Port> = gson.fromJson(body, Array<Port>::class.java).toList()
                PortList = Portz as MutableList<Port>
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
                val Regionz: List<Region> = gson.fromJson(body, Array<Region>::class.java).toList()
                RegionList = Regionz as MutableList<Region>
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }
}

class vesselList(val vessels: List<Vessel>)
class Vessel(var location:String,var vesselId:String, var status:String,var other:String, var name:String, var noContainers:Int)
class PortList(val ports: List<Port>)
class Port(var portID:String, var gantryCranes:Int, var name:String, var portStay:Double, var regionID:String)
class RegionList(val regions: List<Vessel>)
class Region(var name:String,var regionId:Int)

