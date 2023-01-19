package com.example.kotlin_ed_dc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Hay que poner lateinit para decirle que no inicialice las variable
    lateinit var bSumar: Button;
    lateinit var tvContador: TextView;
    var contador = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Extraer Views
        bSumar = findViewById<Button>(R.id.bSumar);
        tvContador = findViewById<TextView>(R.id.tvMostrarValor);
        updateContadorText();

        // Eventos
        bSumar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                contador++; updateContadorText();
            }
        })
    }

    fun updateContadorText() {
        tvContador.text = "Contador: $contador";
    }


}