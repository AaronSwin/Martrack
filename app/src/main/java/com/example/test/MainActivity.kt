package com.example.test

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.Name)

        val queue = Volley.newRequestQueue(this)
        val url = "https://3wu7u4alu9.execute-api.us-east-1.amazonaws.com/martrack/vessel"

        val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Display the first 500 characters of the response string.
                    textView.text = "Response is: ${response.toString()}"
                },
                Response.ErrorListener { textView.text = "That didn't work!" })

// Add the request to the RequestQueue.
        queue.add(stringRequest)
}
}