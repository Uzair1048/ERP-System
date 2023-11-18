package com.example.erpsystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        val imgacadme = findViewById<ImageView>(R.id.imgacadme)
        imgacadme.setOnClickListener {
            val intent = Intent(this,CourseActivity::class.java)
            startActivity(intent)
        }

    }
}