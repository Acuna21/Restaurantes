package com.restaurantes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.restaurantes.Adapters.NotificationAdapter
import com.restaurantes.R
import com.restaurantes.dataClasses.Notification


 class NotificationsFragment : Fragment() {

    val notifications = listOf<Notification>(
        Notification("Incandecencia","Todo se fué abajo","5h","https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/User_icon-cp.svg/1200px-User_icon-cp.svg.png"),
        Notification("Incandecencia","Todo se fué abajo","5h","https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/User_icon-cp.svg/1200px-User_icon-cp.svg.png"),
        Notification("Incandecencia","Todo se fué abajo","5h","https://upload.wikimedia.org/wikipedia/commons/thumb/5/50/User_icon-cp.svg/1200px-User_icon-cp.svg.png")
    )

     private lateinit var adapter : NotificationAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_notifications, container, false)
        initRecyclerView(view)
        return view
    }

     private fun initRecyclerView(view: View){
         val rvNotification = view.findViewById<RecyclerView>(R.id.rvNotification)
         rvNotification.layoutManager = LinearLayoutManager(activity)
         rvNotification.adapter = NotificationAdapter(notifications, this)
     }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            NotificationsFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}