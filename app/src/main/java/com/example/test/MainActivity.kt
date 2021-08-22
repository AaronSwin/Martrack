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
        val vessels = findViewById<Button>(R.id.btnVessels)
        val ports = findViewById<Button>(R.id.btnPorts)
        val maps = findViewById<Button>(R.id.btnMap)

        val queue = Volley.newRequestQueue(this)
        val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/vessel"


        vessels.setOnClickListener{
            val intent = Intent(this, vessels::class.java).apply
        }
        ports.setOnClickListener{
            val intent = Intent(this, ports::class.java).apply
        }
        maps.setOnClickListener{
            val intent = Intent(this, maps::class.java).apply
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


        ports.setOnClickListener{

        }
        maps.setOnClickListener{

        }
}
}

