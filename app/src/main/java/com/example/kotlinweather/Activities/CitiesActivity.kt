package com.example.kotlinweather.Activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.kotlinweather.Adapters.CityAdapter
import com.example.kotlinweather.Interfaces.ClickListener
import com.example.kotlinweather.Models.City
import com.example.kotlinweather.R

class CitiesActivity : AppCompatActivity() {

    private val TAG = "com.example.kotlinweather.Activities.CitiesActivity.CITY"
    private var toolbar:Toolbar? = null
    private var recycler:RecyclerView? = null
    private var cities:ArrayList<City>? = null
    private var layoutManager:LayoutManager? = null
    private var adapter:CityAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        setToolbar()

        cities = ArrayList()
        cities?.add(City("Mexico City",null, null))
        cities?.add(City("Berlin City",null, null))
        cities?.add(City("Santo Domingo City",null, null))
        cities?.add(City("Madrid City",null, null))
        cities?.add(City("New York City",null, null))

        recycler = findViewById(R.id.recycler)
        recycler?.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recycler?.layoutManager = layoutManager

        adapter = CityAdapter(cities!!, object: ClickListener{
            override fun onClick(view: View, index: Int) {
                Toast.makeText(applicationContext, cities?.get(index)?.name, Toast.LENGTH_LONG).show()

                if (index == 0){
                    goToDetail("3530597")
                }
                if (index == 1){
                    goToDetail("2950159")
                }
                if (index == 2){
                    goToDetail("3492908")
                }
                if(index == 3){
                    goToDetail("3117735")
                }
                if (index == 4){
                    goToDetail("5128581")
                }
            }
        })
        recycler?.adapter = adapter
        
    }


    private fun goToDetail(key:String){
        val intent = Intent(this, DetailsActivity::class.java)
        intent.putExtra(TAG, key)
        startActivity(intent)

    }

    private fun setToolbar(){
        toolbar = findViewById(R.id.toolbar)
        toolbar?.setTitle(R.string.app_name)
        setSupportActionBar(toolbar)
    }
}