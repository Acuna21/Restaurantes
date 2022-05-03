package com.restaurantes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.restaurantes.R
import com.restaurantes.Restaurant
import com.restaurantes.RestaurantAdapter

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class HomeFragment : Fragment() {

    val restaurants = listOf<Restaurant>(
        Restaurant("Kippy", "Carrera 16C # 55A-15", "3116150175","google.com","Mexicano", "4", "https://www.eltiempo.com/files/image_640_428/uploads/2021/09/30/61565a62e9dc3.jpeg" ),
        Restaurant("Cervecería BBC", "Carrera 18C # 80A-15", "3116150178","google.com","Mexicano", "2", "https://media-cdn.tripadvisor.com/media/photo-s/1a/fc/d4/9a/img-20191221-104936-957.jpg" ),
        Restaurant("Itali", "Carrera 16C # 54", "3117150170","google.com","Mexicano", "3", "https://i0.wp.com/foodandpleasure.com/wp-content/uploads/2018/06/piantao-3.jpg?fit=2800%2C1867&ssl=1" ),
        Restaurant("KFC", "Carrera 09C # 03", "3118150170","google.com","Mexicano", "4", "https://paseosanrafael.com/wp-content/uploads/2019/11/KFC_new_logo-800x720.png" )
    )

    private lateinit var adapter : RestaurantAdapter

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
        val view: View = inflater.inflate(R.layout.fragment_home, container, false)
        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View){
        val rvRestaurant = view.findViewById<RecyclerView>(R.id.rvRestaurant)
        rvRestaurant.layoutManager = LinearLayoutManager(activity)
        rvRestaurant.adapter = RestaurantAdapter(restaurants, this)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}