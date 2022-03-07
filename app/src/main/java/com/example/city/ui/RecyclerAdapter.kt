package com.example.city.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.city.R
import com.example.city.model.City
import com.google.android.material.bottomnavigation.BottomNavigationItemView

class RecyclerAdapter(
    private var cities: ArrayList<City>, private var clickListener: (City) -> Unit
) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    fun deleteItem(i: Int) {
        cities.removeAt(i)
        notifyDataSetChanged()
    }

    inner class MyViewHolder(itemView: View, clickposition: (Int) -> Unit) :
        RecyclerView.ViewHolder(itemView) {
        val main: CardView
        val cityname: TextView
        val countryname: TextView

        init {
            main = itemView.findViewById(R.id.background)
            cityname = itemView.findViewById(R.id.cityname)
            countryname = itemView.findViewById(R.id.countryname)
            main.setOnClickListener {
                clickposition(absoluteAdapterPosition)
            }

        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        ) {
            clickListener(cities[it])
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = cities[position]
        holder.main.setCardBackgroundColor(currentItem.id)
        holder.cityname.text = currentItem.cityname
        holder.countryname.text = currentItem.countryname
    }

    override fun getItemCount(): Int = cities.size
}