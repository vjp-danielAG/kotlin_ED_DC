package com.example.kotlin_ed_dc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    // Hay que poner lateinit para decirle que no inicialice las variables
    lateinit var tvAutor:   TextView
    lateinit var tvText:    TextView
    lateinit var tvMostrar: TextView

    lateinit var btnAdd:    Button
    lateinit var btnRemove: Button
    lateinit var btnNext:   Button
    lateinit var btnPrev:   Button

    lateinit var rgroupDataStruct: RadioGroup
    var listMensajes: ArrayList<MensajeDC>   = ArrayList()
    var setMensajes:  HashSet<MensajeDC>     = HashSet()
    var mapMensajes:  HashMap<Int,MensajeDC> = HashMap()

    var iMsg: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Extraer Views
        rgroupDataStruct = findViewById(R.id.rgroupDataStruct)
        btnAdd     = findViewById(R.id.btAniadir)
        btnRemove  = findViewById(R.id.btEliminar)
        btnNext    = findViewById(R.id.btSig)
        btnPrev    = findViewById(R.id.btAnt)

        tvAutor   = findViewById(R.id.etAutor)
        tvText    = findViewById(R.id.etMensaje)
        tvMostrar = findViewById(R.id.tvElementoMostrar)

        // Eventos
        btnAdd.setOnClickListener { addMensaje() }
        rgroupDataStruct.setOnCheckedChangeListener { _, checkedId -> loadMensajes(checkedId) }
    }

    private fun addMensaje() {
        var msg = MensajeDC(tvAutor.text.toString(), tvText.text.toString())
        clearFields() //

        when (rgroupDataStruct.checkedRadioButtonId) {
            R.id.rbList -> listMensajes.add(msg)
            R.id.rbSet -> setMensajes.add(msg)
            R.id.rbMap -> mapMensajes.set(mapMensajes.size, msg)
        }
    }

    private fun loadMensajes(checkedId: Int) {
        // Reiniciar indice mensajes
        iMsg = 0; var msg: MensajeDC? = null;
        // Cargar primer mensaje de la estructura de datos
        when (checkedId) {
            R.id.rbList -> msg = listMensajes.firstOrNull()
            R.id.rbSet -> msg = setMensajes.firstOrNull()
            R.id.rbMap -> {
                val key = mapMensajes.keys.firstOrNull()
                msg = mapMensajes.getOrDefault(key, null)
            }
        }

        tvMostrar.text = msg?.toString() ?: getString(R.string.elemento)
    }

    private fun clearFields() {
        tvAutor.text = ""
        tvText.text  = ""
    }


}

