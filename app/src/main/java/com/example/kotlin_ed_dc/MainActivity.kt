package com.example.kotlin_ed_dc

import android.annotation.SuppressLint
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

    lateinit var tvAutor: TextView;
    lateinit var tvText: TextView;

    lateinit var btnAdd: Button;

    lateinit var listMensajes: ArrayList<MensajeDC>;
//    lateinit var _mapNumbers: Map<Int,String>;
//    lateinit var _setNumbers: Set<Int>;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Extraer Views
        tvAutor = findViewById(R.id.etAutor);
        tvText  = findViewById(R.id.etMensaje);
        btnAdd  = findViewById(R.id.btAniadir);

        // Eventos
        btnAdd.setOnClickListener(View.OnClickListener { addMensaje(); });
    }


    fun addMensaje() {
        var c_msg  = Mensaje  (tvAutor.text.toString(), tvText.text.toString());
        var dc_msg = MensajeDC(tvAutor.text.toString(), tvText.text.toString());
//        listMensajes.add(msg);

        val TAG = "___DEBUGGING___";
        //? Class
        Log.i(TAG,"CLASS:     $c_msg");

        //? Data Class
        Log.i(TAG,"DATACLASS: $dc_msg")
    }


}