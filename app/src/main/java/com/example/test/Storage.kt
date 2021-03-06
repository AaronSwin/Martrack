package com.example.test


import android.content.Context
import android.os.Parcelable
import com.google.gson.GsonBuilder
import kotlinx.android.parcel.Parcelize
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException




object Storage {

    var PortList = mutableListOf<Port>()
    var VesselList = mutableListOf<Vessel>()
    var RegionList = mutableListOf<Region>()

    fun PortSearch(search: String): Port? {
        PortList.forEach{
            if(it.portId ==search.toString().toInt())
                return it
        }
        return null
    }
    fun VesselSearch(search: String): Vessel?{
        VesselList.forEach{
            if(it.vesselId == search.toInt())
                return it
        }
        return null
    }
    fun RegionSearch(search: String): Region?{
        RegionList.forEach{
            if(it.regionId == search.toInt())
                return it
        }
        return null
    }
    fun loadall(context: Context){
        loadVessel(context)
        loadPort(context)
        loadRegion(context)
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
                for(Vessel in vesselz){
                    VesselList.add(Vessel)
                }
            }



            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }

    fun updateVessel(context: Context,json:String,Url: String){
        val client = OkHttpClient()
        val request = Request.Builder()
            .url(Url)
            .put(json.toRequestBody("application/json".toMediaTypeOrNull()))
            .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: okhttp3.Response) {
                val txt = response
                println("Succesful")
            }



            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }

    fun deleteVessel(Url: String){

        val client = OkHttpClient()
        val request = Request.Builder()
            .url(Url)
            .delete()
            .build()

        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: okhttp3.Response) {
                val txt = response
                println("Succesful")
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
                for(Port in Portz){
                    PortList.add(Port)
                }
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
                for(Region in Regionz){
                    RegionList.add(Region)
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                println("Failed to execute request")
            }
        })
    }
}


@Parcelize
class Vessel(var location:String,var vesselId:Int, var status:String,var other:String, var name:String, var noContainers:Int): Parcelable
@Parcelize
data class Port(var portId:Int, var gantryCranes:Int, var name:String, var portStay:Int, var regionId:String): Parcelable
data class Region(var regionId:Int, var name:String )

