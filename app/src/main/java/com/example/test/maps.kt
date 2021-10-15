package com.example.test

import android.app.Notification
import android.content.ContentValues.TAG
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Sampler
import android.util.Log
import android.widget.Toast
import com.mapbox.geojson.Feature
import com.mapbox.mapboxsdk.Mapbox
import com.mapbox.mapboxsdk.annotations.MarkerOptions
import com.mapbox.mapboxsdk.geometry.LatLng
import com.mapbox.mapboxsdk.maps.MapView
import com.mapbox.mapboxsdk.maps.Style
import com.mapbox.mapboxsdk.maps.Style.MAPBOX_STREETS
import kotlinx.android.synthetic.main.activity_maps.*
import com.mapbox.mapboxsdk.maps.Style.MAPBOX_STREETS
import com.mapbox.mapboxsdk.style.layers.CircleLayer
import com.mapbox.mapboxsdk.style.sources.VectorSource


class maps : AppCompatActivity() {

    private var mapView: MapView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Mapbox.getInstance(this, getString(R.string.mapbox_access_token))

        setContentView(R.layout.activity_maps)

        mapView = findViewById<MapView>(R.id.mapView)
        mapView?.onCreate(savedInstanceState)
        mapView?.getMapAsync { mapboxMap ->

            mapboxMap.setStyle(Style.Builder().fromUri("mapbox://styles/dorido/ckupjbxhpc5sj17s5l6cvzv7v"))

            mapboxMap.addOnMapClickListener { point ->
                val pixel = mapboxMap.projection.toScreenLocation(point)

                val features = mapboxMap.queryRenderedFeatures(pixel)

                if (features.size > 0) {
                    val feature = features[0]
                    for(Feature in features){
                        if(Feature.hasProperty("Name"))
                            mapboxMap.addMarker(MarkerOptions().setTitle("Worked").position(point))
                    }

                }
                true
            }

        }


    }

    fun onMapClick(point: LatLng){

    }
}