package com.example.kotlin_ed_dc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    val bSumar = findViewById<Button>(R.id.bSumar);
    val tvContador = findViewById<TextView>(R.id.tvMostrarValor);

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvContador.text = "Contador: 0";

        bSumar.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                Log.d("CLICKS:","PRUEBA")
            }
        })
    }
}