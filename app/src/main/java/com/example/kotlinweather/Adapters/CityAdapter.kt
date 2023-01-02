package com.example.kotlinweather.Adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinweather.Interfaces.ClickListener
import com.example.kotlinweather.Models.City
import com.example.kotlinweather.R

class CityAdapter(items:ArrayList<City>, var clickListener: ClickListener): RecyclerView.Adapter<CityAdapter.ViewHolder>() {

    var items: ArrayList<City>? = null
    var holder:ViewHolder? = null

    init {
        this.items = items
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.city_adapter, parent,false)
        holder = ViewHolder(view, clickListener)
        return holder!!

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = items?.get(position)
        holder.name?.text = item?.name
    }

    override fun getItemCount(): Int {
        return items?.count()!!
    }


    class ViewHolder(view: View, listener:ClickListener) : RecyclerView.ViewHolder(view), View.OnClickListener {
        var name: TextView? = null
        var listener:ClickListener? = null

        init {
            name = view.findViewById(R.id.tvName)
            this.listener = listener

            view.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
           this.listener?.onClick(v!!, adapterPosition)
        }
    }
}