package com.example.kotlinweather.Activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.kotlinweather.Models.City
import com.example.kotlinweather.Network.Network
import com.example.kotlinweather.R
import com.google.gson.Gson

class DetailsActivity : AppCompatActivity() {

   private var tvCity: TextView? = null
   private var tvGrade: TextView? = null
   private var tvWeather: TextView? = null
    private var toolbar:Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        setToolbar()

        tvCity = findViewById(R.id.tvCity)
        tvGrade = findViewById(R.id.tvGrade)
        tvWeather = findViewById(R.id.tvWeather)

        val city = intent.getStringExtra(getString(R.string.tag_message))
        if (Network.network(this)){
            //Execute http request
            requestHttpVolley("https://api.openweathermap.org/data/2.5/weather?id=$city&appid=fe470636a5a4d7d5b221d8e8810429a8&units=metric&lang=es")

        }

    }

    private fun requestHttpVolley(url: String){
        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET, url,{
            response ->

            try {
                Log.d("RequestHttpVolley", response)
                val gson = Gson()
                val city = gson.fromJson(response, City::class.java)
                tvCity?.text = city.name
                tvGrade?.text = city.main?.temp.toString()
                tvWeather?.text = city.weather?.get(0)?.description

            }catch (_: Exception){

            }


        }, {})
        queue.add(request)
    }


    private fun setToolbar(){
        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(getString(R.string.detail_message))
        setSupportActionBar(toolbar)

        val actionBar = supportActionBar
        actionBar?.setDisplayHomeAsUpEnabled(true)
    }
}