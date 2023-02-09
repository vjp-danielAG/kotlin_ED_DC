package com.example.kotlin_ed_dc

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Hay que poner lateinit para decirle que no inicialice las variables
    lateinit var tvAutor: TextView;
    lateinit var tvText: TextView;

    lateinit var btnAdd:    Button;
    lateinit var btnRemove: Button;
    lateinit var btnNext: Button;
    lateinit var btnPrev: Button;


    lateinit var rgroupDataStruct: RadioGroup;
    var listMensajes: ArrayList<MensajeDC>   = ArrayList();
    var setMensajes:  HashSet<MensajeDC>     = HashSet();
    var mapMensajes:  HashMap<Int,MensajeDC> = HashMap();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Extraer Views
        rgroupDataStruct = findViewById(R.id.rgroupDataStruct);
        btnAdd     = findViewById(R.id.btAniadir);
        btnRemove  = findViewById(R.id.btEliminar);
        btnNext    = findViewById(R.id.btSig);
        btnPrev    = findViewById(R.id.btAnt);

        tvAutor = findViewById(R.id.etAutor);
        tvText  = findViewById(R.id.etMensaje);

        // Eventos
        btnAdd.setOnClickListener { addMensaje() };
        rgroupDataStruct.setOnCheckedChangeListener { _, checkedId -> loadMensajes(checkedId) };
    }


    private fun addMensaje() {
        var msg = MensajeDC(tvAutor.text.toString(), tvText.text.toString());

        when (rgroupDataStruct.checkedRadioButtonId) {
            R.id.rbList -> listMensajes.add(msg)
            R.id.rbSet -> setMensajes.add(msg)
            R.id.rbMap -> mapMensajes.set(mapMensajes.size, msg)
            else -> Log.i("MainActivity.addMensaje()", "Not Supported")
        }
    }

    private fun loadMensajes(checkedId: Int) {
        // Reiniciar index
        when (checkedId) {
            R.id.rbList -> {
                Log.i("MainActivity.loadMensajes()", "LIST" )
            };
            R.id.rbSet -> {
                Log.i("MainActivity.loadMensajes()", "SET" )
            };
            R.id.rbMap -> {
                Log.i("MainActivity.loadMensajes()", "MAP" )
            };
            else -> { Log.i("MainActivity.loadMensajes()", "NONE" ) };
        }
    }


}

