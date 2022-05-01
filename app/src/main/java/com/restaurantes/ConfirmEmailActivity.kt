package com.restaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ConfirmEmailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm_email)

        val confirm = findViewById<Button>(R.id.button_confirmEmail)

        confirm.setOnClickListener{
            val intento1 = Intent(this, NewPasswordActivity::class.java)
            startActivity(intento1)
        }
    }
}