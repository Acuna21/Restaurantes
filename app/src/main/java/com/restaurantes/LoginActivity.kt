package com.restaurantes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        val withoutAccount = findViewById<TextView>(R.id.withoutAccount)
        val forgetPassword = findViewById<TextView>(R.id.forgetPassword)
        val login = findViewById<Button>(R.id.button_confirmEmail)

        login.setOnClickListener{
            val intento1 = Intent(this, AllowlocationActivity::class.java)
            startActivity(intento1)
        }

        withoutAccount.setOnClickListener {
            val intento1 = Intent(this, RegisterActivity::class.java)
            startActivity(intento1)
            finish()
        }

        forgetPassword.setOnClickListener {
            val intento1 = Intent(this, ConfirmEmailActivity::class.java)
            startActivity(intento1)
        }
    }
}