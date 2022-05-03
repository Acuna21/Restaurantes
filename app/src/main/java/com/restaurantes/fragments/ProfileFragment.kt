package com.restaurantes.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.restaurantes.Adapters.FavoriteAdapter
import com.restaurantes.R
import com.restaurantes.dataClasses.Favorite


class ProfileFragment : Fragment() {

    val favorites = listOf<Favorite>(
        Favorite("Restaurant Name","Carrera 16C # 55A - 15","https://www.eltiempo.com/files/image_640_428/uploads/2021/09/30/61565a62e9dc3.jpeg"),
        Favorite("Restaurant Name","Carrera 16C # 55A - 15","https://media-cdn.tripadvisor.com/media/photo-s/1a/fc/d4/9a/img-20191221-104936-957.jpg"),
        Favorite("Restaurant Name","Carrera 16C # 55A - 15","https://i0.wp.com/foodandpleasure.com/wp-content/uploads/2018/06/piantao-3.jpg?fit=2800%2C1867&ssl=1"),
        Favorite("Restaurant Name","Carrera 16C # 55A - 15","https://paseosanrafael.com/wp-content/uploads/2019/11/KFC_new_logo-800x720.png" )
    )

    private lateinit var adapter: FavoriteAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_profile, container, false)
        initRecyclerView(view)
        return view
    }

    private fun initRecyclerView(view: View){
        val rvFavorite = view.findViewById<RecyclerView>(R.id.rvFavorite)
        rvFavorite.layoutManager = LinearLayoutManager(activity)
        rvFavorite.adapter = FavoriteAdapter(favorites, this)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfileFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}