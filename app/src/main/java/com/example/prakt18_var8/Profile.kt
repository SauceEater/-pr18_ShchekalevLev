package com.example.prakt18_var8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Profile : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
    }

    fun Back(view: View) {
        val intent = Intent(this, MainScreen::class.java)
        startActivity(intent)
    }
}