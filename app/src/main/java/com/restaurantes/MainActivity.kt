package com.restaurantes

import android.content.Intent
import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.circularreveal.coordinatorlayout.CircularRevealCoordinatorLayout
import me.relex.circleindicator.CircleIndicator3
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.listener.CarouselListener
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.imaginativeworld.whynotimagecarousel.model.CarouselType

private val list = mutableListOf<CarouselItem>()

class MainActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var imagesList = mutableListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val view_pager2: ViewPager2 = findViewById(R.id.view_pager2)
        postToList()

        view_pager2.adapter = ViewPagerAdapter(titlesList,descList,imagesList)
        //view_pager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicador = findViewById<CircleIndicator3>(R.id.indicator)
        indicador.setViewPager(view_pager2)

        val btn_fake_swipe : Button = findViewById(R.id.btn_fake_swipe)
        btn_fake_swipe.setOnClickListener {
            view_pager2.apply {
                beginFakeDrag()
                fakeDragBy(-10f)
                endFakeDrag()
            }
        }

        /*
        val carousel: ImageCarousel = findViewById(R.id.carousel)

        //Carusel de imagenes
        list.add(
            CarouselItem("https://media-cdn.tripadvisor.com/media/photo-s/1a/fc/d4/9a/img-20191221-104936-957.jpg", caption = "Cervecería BBC")
        )
        list.add(
            CarouselItem("https://pro2-bar-s3-cdn-cf1.myportfolio.com/e10e4c9c758ef2bdc4d50c99cf1f82ec/975c96f4-a240-42a4-88b2-904e409b3128_rw_3840.jpg?h=7aa14cefb262c99780bfc9a0ecddc5ba", caption="KFC (Kentucky Fried Chicken)")
        )
        list.add(
            CarouselItem("https://pbs.twimg.com/media/DT9Dx9IW4AUp4C8.jpg", caption="El Cervecero BAQ")
        )
        list.add(
            CarouselItem("https://menu.sluurpy.com/immagini/locali/thumbs/2221138.jpg", caption="Brisket Casa de Asados")
        )
        list.add(
            CarouselItem("https://servicios.elheraldo.co/sites/default/files/foto_portada/local/2017/04/11/quilla7.jpg", caption="Jardines de Confucio")
        )
        carousel.addData(list)

        carousel.carouselListener = object : CarouselListener {
            override fun onClick (position: Int, carouselItem: CarouselItem){
                Log.d("restaurante", "Restaurante ${carouselItem.caption}")
                Toast.makeText(this@MainActivity, "Restaurante ${carouselItem.caption}", Toast.LENGTH_SHORT).show()

            }
        }
        */
    }

    private fun addToList(title: String, description: String, image: Int){
        titlesList.add(title)
        descList.add(description)
        imagesList.add(image)
    }

    private fun postToList(){
        for (i in 1..5){
            addToList("Title $i", "Description $i", R.mipmap.ic_launcher_round)
        }
    }
}