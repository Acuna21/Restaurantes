package com.restaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.TextView

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)

        val genderList = arrayOf("Masculino","Femenino","Otro")

        val gender=findViewById<Spinner>(R.id.gender)
        val adaptador1 = ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, genderList)
        gender.adapter = adaptador1

        val ihaveAccount = findViewById<TextView>(R.id.ihaveAccount)
        ihaveAccount.setOnClickListener {
            val intento1 = Intent(this, LoginActivity::class.java)
            startActivity(intento1)
            finish()
        }

    }
}