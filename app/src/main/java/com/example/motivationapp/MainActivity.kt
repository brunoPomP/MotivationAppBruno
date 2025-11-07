package com.example.motivationapp

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val nomeUser = findViewById<TextView>(R.id.TextView_User)
        val txtFrase = findViewById<TextView>(R.id.TextView_Frase)
        val btnNovaFrase = findViewById<Button>(R.id.Button_NovaFrase)

        val sharedPref = getSharedPreferences("UserPrefs", Context.MODE_PRIVATE)
        val nomeUsuario = sharedPref.getString("nomeUsuario", "Kotlin")
        nomeUser.text = "Olá $nomeUsuario"


        val frases = listOf(
            "Riscos devem ser corridos, porque o maior perigo é não arriscarmos nada.",
            "Acredite em si mesmo e todo o resto virá naturalmente.",
            "Grandes conquistas exigem grandes esforços.",
            "Cada dia é uma nova chance de recomeçar.",
            "O sucesso é a soma de pequenos esforços repetidos diariamente.",
            "Não espere por oportunidades, crie-as.",
            "Seja a mudança que você quer ver no mundo.",
            "A persistência é o caminho do êxito."
        )


        btnNovaFrase.setOnClickListener {
            val fraseAleatoria = frases.random()
            txtFrase.text = fraseAleatoria
        }
    }
}

