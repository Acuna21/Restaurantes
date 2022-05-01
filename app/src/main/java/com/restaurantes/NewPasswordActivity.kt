package com.restaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class NewPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.new_password)

        val passwordConfirm = findViewById<Button>(R.id.button_confirmEmail)

        passwordConfirm.setOnClickListener{
            val intento1 = Intent(this, ContentActivity::class.java)
            startActivity(intento1)
        }
    }
}