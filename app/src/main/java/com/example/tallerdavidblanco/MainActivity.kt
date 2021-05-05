package com.example.tallerdavidblanco

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Toast.makeText(this,"onCreate", Toast.LENGTH_LONG).show()

        // Encontrar boton
        val btnHello: Button = findViewById(R.id.btnHello)

        // al hacerle click al boton
        btnHello.setOnClickListener{
            // Codigo para pasar a la siguiente pantalla
            val intent: Intent = Intent(this, Calculadora::class.java)

            // Se inicia la actividad que esta aqui arriba
            startActivity(intent)
            // Matar esta actividad
            finish()
        }
    }
}