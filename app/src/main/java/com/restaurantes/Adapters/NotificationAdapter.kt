package com.restaurantes.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.restaurantes.R
import com.restaurantes.dataClasses.Notification
import com.restaurantes.fragments.NotificationsFragment

class NotificationAdapter (val notificatios: List<Notification>, context: NotificationsFragment):RecyclerView.Adapter<NotificationAdapter.NotificationHolder>(){
    val context = context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotificationHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return NotificationHolder(layoutInflater.inflate(R.layout.item_notification,parent,false))
    }

    override fun onBindViewHolder(holder: NotificationHolder, position: Int) {
        holder.itemTitle.text = notificatios[position].title
        holder.itemDescription.text = notificatios[position].description
        holder.itemTime.text = notificatios[position].time
        holder.itemImg.setImageResource(R.mipmap.ic_launcher_round)
        Glide.with(context).load(notificatios[position].img).into(holder.itemImg)
    }

    override fun getItemCount(): Int = notificatios.size

    class NotificationHolder(val view: View):RecyclerView.ViewHolder(view) {
        val itemTitle : TextView = view.findViewById(R.id.tvNotificationTitle)
        val itemDescription : TextView = view.findViewById(R.id.tvNotificationDesc)
        val itemTime : TextView = view.findViewById(R.id.tvNotificationTime)
        val itemImg : ImageView = view.findViewById(R.id.ivNotification)
    }
}