package com.example.amiguinhos

import java.io.Serializable

class Amigo (var nome:String, var grau:Int) : Serializable {
    override fun toString(): String {
        return "${nome} - ${grau}"
    }
}