package com.example.visitormanagmentapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LandingPage : AppCompatActivity() {
    lateinit var btn_login: Button
    lateinit var btn_signin:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing_page)
        btn_login = findViewById(R.id.LandingPage_login)

        btn_login.setOnClickListener{
            val i=Intent(this,Login::class.java)
                startActivity(i)
        }

        btn_signin = findViewById(R.id.LandingPage_signin)

        btn_signin.setOnClickListener{
            val i=Intent(this,SignUp::class.java)
                startActivity(i)
        }
    }
}