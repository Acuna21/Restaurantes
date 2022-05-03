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
        Favorite("Restaurant Name","Carrera 16C # 55A - 15","img"),
        Favorite("Restaurant Name","Carrera 16C # 55A - 15","img"),
        Favorite("Restaurant Name","Carrera 16C # 55A - 15","img"),
        Favorite("Restaurant Name","Carrera 16C # 55A - 15","img")
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
        rvFavorite.adapter = FavoriteAdapter(favorites)
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