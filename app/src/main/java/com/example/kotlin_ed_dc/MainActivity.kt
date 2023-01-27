package com.example.kotlin_ed_dc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

// Dataclases
data class MensajeDC(
    var texto: String = "",
    var autor: String = "",
);

class MainActivity : AppCompatActivity() {
    // Hay que poner lateinit para decirle que no inicialice las variable
    lateinit var bAniadirElemento: Button;
    lateinit var bEliminarElemento: Button;
    lateinit var bSiguienteElemento: Button;

    lateinit var tvAutor: TextView;
    lateinit var tvText: TextView;

    lateinit var listMensajes: ArrayList<MensajeDC>;
//    lateinit var _mapNumbers: Map<Int,String>;
//    lateinit var _setNumbers: Set<Int>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Extraer Views



        // Eventos

    }


    fun addMensaje() {
        val msg = MensajeDC(tvAutor.text.toString(), tvText.text.toString());
        listMensajes.add(msg);
    }


}