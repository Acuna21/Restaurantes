package com.restaurantes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RestaurantAdapter(val restaurant: List<Restaurant>):RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return RestaurantHolder(layoutInflater.inflate(R.layout.item_restaurant, parent, false))
    }

    override fun getItemCount(): Int = restaurant.size


    override fun onBindViewHolder(holder: RestaurantHolder, position: Int) {
        holder.itemName.text = restaurant[position].name
        holder.itemAddress.text = restaurant[position].address
        holder.itemPhone.text = restaurant[position].phone
        holder.itemWebSite.text = restaurant[position].webSite
        holder.itemCategory.text = restaurant[position].category
        holder.itemScore.text = restaurant[position].score
        holder.itemImg.setImageResource(R.mipmap.location)
    }

    class RestaurantHolder(val view:View):RecyclerView.ViewHolder(view) {
        val itemName : TextView = view.findViewById(R.id.tvName)
        val itemAddress : TextView = view.findViewById(R.id.tvAddress)
        val itemPhone : TextView = view.findViewById(R.id.tvPhone)
        val itemWebSite : TextView = view.findViewById(R.id.tvWebSite)
        val itemCategory : TextView = view.findViewById(R.id.tvCategory)
        val itemScore : TextView = view.findViewById(R.id.tvSocre)
        val itemImg : ImageView = view.findViewById(R.id.ivRestaurant)
    }

}