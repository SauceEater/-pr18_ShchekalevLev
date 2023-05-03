package com.example.prakt18_var8

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)
    }

    fun ToLogin(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    fun ToProfile(view: View) {
        val intent = Intent(this, Profile::class.java)
        startActivity(intent)
    }

    fun ToFirstBook(view: View) {
        val intent = Intent(this, FirstBook::class.java)
        startActivity(intent)
    }

    fun ToSecondBook(view: View) {
        val intent = Intent(this, SecondBook::class.java)
        startActivity(intent)
    }
    fun ToThirdBook(view: View) {
        val intent = Intent(this, ThirdBook::class.java)
        startActivity(intent)
    }
    fun ToFourthBook(view: View) {
        val intent = Intent(this, FourthBook::class.java)
        startActivity(intent)
    }
    fun ToFifthBook(view: View) {
        val intent = Intent(this, FifthBook::class.java)
        startActivity(intent)
    }
    fun ToSixthBook(view: View) {
        val intent = Intent(this, SixthBook::class.java)
        startActivity(intent)
    }
}