package com.example.motivationapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class User : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_user)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val editNome = findViewById<EditText>(R.id.EditText_Nome)
        val btnSalvar = findViewById<Button>(R.id.Button_Salvar)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)


        btnSalvar.setOnClickListener {
            val nome = editNome.text.toString()

            if (nome.isNotEmpty()) {
                val editor = sharedPref.edit()
                editor.putString("nomeUsuario", nome)
                editor.apply()


                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)


                finish()
            } else {
                Toast.makeText(this, "Digite seu nome antes de salvar.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}


