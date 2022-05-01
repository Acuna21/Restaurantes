package com.restaurantes

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class AllowlocationActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var map:GoogleMap
    /*
    companion object{
        const val REQUEST_CODE_LOCATION = 0
    }
    */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.allowlocation)

        createFragment()

        val confirmAL = findViewById<Button>(R.id.confirmAL)

        confirmAL.setOnClickListener{
            val intento1 = Intent(this, ContentActivity::class.java)
            startActivity(intento1)
            finish()
        }

    }

    private fun createFragment() {
        val mapFragment = supportFragmentManager.findFragmentById(R.id.initialMap) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(googleMap: GoogleMap) {
        map = googleMap
        createMarker()
    }

    private fun createMarker() {
        val coordinates = LatLng(28.043893, -16.539329)
        val marker = MarkerOptions().position(coordinates).title("Mi playa favorita")
        map.addMarker(marker)
        map.animateCamera(
            CameraUpdateFactory.newLatLngZoom(coordinates, 18f),
            4000,
            null
        )
    }
    /*
    private fun isLocationPermissionGranted() = ContextCompat.checkSelfPermission(
        this,
        Manifest.permission.ACCESS_FINE_LOCATION
    ) == PackageManager.PERMISSION_GRANTED

    private fun enableLocation(){
        if (!::map.isInitialized) return
        if (isLocationPermissionGranted()){
            map.isMyLocationEnabled = true
        } else {
            requestLocationPermission()

        }
    }

    private fun requestLocationPermission(){
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.ACCESS_FINE_LOCATION)){
            Toast.makeText(this, "Por favor, active su ubicación en ajustes", Toast.LENGTH_SHORT).show()
        } else{
            ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
            REQUEST_CODE_LOCATION
            )
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when(requestCode){
           REQUEST_CODE_LOCATION -> if (grantResults.isNotEmpty() && grantResults[0]==PackageManager.PERMISSION_GRANTED){
               map.isMyLocationEnabled = true
           }else{
               Toast.makeText(this, "Para activar la ubicación dirigase a ajustes y acepte los permisos", Toast.LENGTH_SHORT).show()
           }
           else ->{}
       }
    }*/
}