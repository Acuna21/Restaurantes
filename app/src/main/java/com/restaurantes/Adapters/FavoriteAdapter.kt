package com.restaurantes.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.restaurantes.R
import com.restaurantes.dataClasses.Favorite
import com.restaurantes.fragments.ProfileFragment

class FavoriteAdapter (val favorites: List<Favorite>, context: ProfileFragment):RecyclerView.Adapter<FavoriteAdapter.FavoriteHolder>(){
    val context = context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return FavoriteHolder(layoutInflater.inflate(R.layout.item_favorites, parent, false))
    }

    override fun onBindViewHolder(holder: FavoriteHolder, position: Int) {
        holder.itemName.text = favorites[position].name
        holder.itemAddress.text = favorites[position].address
        Glide.with(context).load(favorites[position].imgFavorite).into(holder.itemImg)
    }

    override fun getItemCount(): Int = favorites.size

    class FavoriteHolder(val view: View):RecyclerView.ViewHolder(view) {
        val itemName : TextView = view.findViewById(R.id.tvFavoriteName)
        val itemAddress : TextView = view.findViewById(R.id.tvFavoriteAddress)
        val itemImg : ImageView = view.findViewById(R.id.ivFavorite)
    }
}