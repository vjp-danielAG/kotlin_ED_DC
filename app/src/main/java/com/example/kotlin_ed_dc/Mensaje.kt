package com.example.kotlin_ed_dc

data class MensajeDC(
    var autor: String = "",
    var texto: String = "",
);

class Mensaje {
    lateinit var texto: String;
    lateinit var autor: String;

    constructor(texto: String = "", autor: String = "") {
        this.texto = texto; this.autor = autor;
    }
}