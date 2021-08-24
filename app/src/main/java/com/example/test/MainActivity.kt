package com.example.test

import android.content.Intent
import android.net.Uri
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.toolbox.Volley
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDateTime


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        "val textView = findViewById<TextView>(R.id.Name)"

        /* Gets Id of widgets (Buttons) */
        val vessels = findViewById<Button>(R.id.btnVessels)
        val port = findViewById<Button>(R.id.btnPorts)
        val map = findViewById<Button>(R.id.btnMap)
        val region = findViewById<Button>(R.id.btnRegion)


        val queue = Volley.newRequestQueue(this)
        val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/vessel"

        /* Listners for buttons  */
        vessels.setOnClickListener{
            /* stores info to be sent to activity */
            val intent = Intent(this, Vessels::class.java).apply{}
            /* passes in info and starts activity */
            startActivityForResult(intent,0)
        }
        port.setOnClickListener{
            val intent = Intent(this, ports::class.java).apply{}
            startActivityForResult(intent,0)
        }
        map.setOnClickListener{
            val intent = Intent(this, maps::class.java).apply{}
            startActivityForResult(intent,0)
        }
        region.setOnClickListener{
            val intent = Intent(this, Regions::class.java).apply{}
            startActivityForResult(intent,0)
        }
    /*    val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    textView.text = "Response is: ${response.toString()}"
                },
                Response.ErrorListener { textView.text = "That didn't work!" })*/

// Add the request to the RequestQueue.
       " queue.add(stringRequest)"



}
}

