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
    var mapIndex: Int = 0

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
        btnNext.setOnClickListener { desplazar(+1) }
        btnPrev.setOnClickListener { desplazar(-1) }
        rgroupDataStruct.setOnCheckedChangeListener { _, _ -> loadMensajes() }
    }

    private fun addMensaje() {
        var msg = MensajeDC(tvAutor.text.toString(), tvText.text.toString())
        clearFields() //

        when (rgroupDataStruct.checkedRadioButtonId) {
            R.id.rbList -> listMensajes.add(msg)
            R.id.rbSet  -> setMensajes.add(msg)
            R.id.rbMap  -> mapMensajes[mapIndex++] = msg
        }

        mostrarMsg()
    }

    private fun loadMensajes() {
        // Reiniciar indice mensajes y mostrar primero
        this.iMsg = 0; mostrarMsg()
    }

    private fun desplazar(inc: Int) {
        iMsg += inc; // Puede ser +1 (derecha) o -1 (izquierda)
        // Sacar la longitud
        val size = when (rgroupDataStruct.checkedRadioButtonId) {
            R.id.rbList -> listMensajes.size
            R.id.rbSet  -> setMensajes.size
            R.id.rbMap  -> mapMensajes.size
            else        -> 0
        }

        // Loopear iMsg a la longitud del
        try {
            iMsg %= size;
            if (iMsg < 0) iMsg += size; // Si es negativo, vamos "por el final"
        } catch (e:ArithmeticException) { iMsg = 0; }

        // Mostrar mensaje correspondiente
        mostrarMsg()
    }

    private fun mostrarMsg() {
        var msg: MensajeDC? = null;
        // Cargar primer mensaje de la estructura de datos
        when (rgroupDataStruct.checkedRadioButtonId) {
            R.id.rbList -> msg = listMensajes.getOrNull(iMsg)
            R.id.rbSet -> msg = setMensajes.elementAtOrNull(iMsg)
            R.id.rbMap -> {
                val key = mapMensajes.keys.elementAtOrNull(iMsg)
                msg = mapMensajes.getOrDefault(key, null)
            }
        }
        Log.i("MainActivity.mostrarMsg()", "i: $iMsg")
        tvMostrar.text = msg?.toString() ?: getString(R.string.elemento)
    }

    private fun clearFields() {
        tvAutor.text = ""
        tvText.text  = ""
    }


}

