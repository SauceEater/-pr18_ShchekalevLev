package com.example.prakt18_var8

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import org.json.JSONObject


class MainActivity : AppCompatActivity() {
    private lateinit var passwordEditText: EditText
    private lateinit var namedEditText: EditText
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val prefs = getSharedPreferences("UserData", Context.MODE_PRIVATE)
        val savedName = prefs.getString("name", "")
        val savedEmail = prefs.getString("email", "")
        val savedPassword = prefs.getString("password", "")
        setContentView(R.layout.activity_main)
        passwordEditText = findViewById(R.id.password)
        namedEditText = findViewById(R.id.login)
        if (savedName?.isNotEmpty() == true && savedEmail?.isNotEmpty() == true && savedPassword?.isNotEmpty() == true) {
            showConfirmationDialog()
        }

        namedEditText.setText(savedName)
        passwordEditText.setText(savedPassword)
    }

    override fun onStop() {
        super.onStop()

        val prefs = getSharedPreferences("UserData", Context.MODE_PRIVATE).edit()
        prefs.putString("name", namedEditText.text.toString())
        prefs.putString("password", passwordEditText.text.toString())
        prefs.apply()
    }
    fun showConfirmationDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.apply {
            setMessage("Хотите использовать сохраненные данные пользователя?")
            setPositiveButton("Да") { dialog, id ->

            }
            setNegativeButton("Нет") { dialog, id ->
                namedEditText.setText("")
                passwordEditText.setText("")
            }
        }
        builder.create().show()
    }
    fun navigtosett(view: View) {
        passwordEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val password = passwordEditText.text.toString().trim()
                if (password.isEmpty()) {
                    passwordEditText.setError("Введите пароль")
                }
            }
        }
        namedEditText.setOnFocusChangeListener { view, hasFocus ->
            if (!hasFocus) {
                val name = namedEditText.text.toString().trim()
                if (name.isEmpty()) {
                    namedEditText.setError("Введите имя пользователя")
                }
            }
        }
        val password = passwordEditText.text.toString().trim()
        val name = namedEditText.text.toString().trim()

        if (password.isEmpty()) {
            passwordEditText.setError("Введите пароль")
        }  else if (name.isEmpty()) {
            namedEditText.setError("Введите имя пользователя")
        } else {
            val intent = Intent(this, MainScreen::class.java)
            startActivity(intent)

        }
    }
}