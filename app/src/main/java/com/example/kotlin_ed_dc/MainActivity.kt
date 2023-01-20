package com.example.kotlin_ed_dc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Hay que poner lateinit para decirle que no inicialice las variable
    lateinit var bAniadirElemento: Button;
    lateinit var bEliminarElemento: Button;
    lateinit var bSiguienteElemento: Button;

    lateinit var _listNumbers: List<Int>;
    lateinit var _mapNumbers: Map<Int,String>;
    lateinit var _setNumbers: Set<Int>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Extraer Views



        // Eventos

    }

}