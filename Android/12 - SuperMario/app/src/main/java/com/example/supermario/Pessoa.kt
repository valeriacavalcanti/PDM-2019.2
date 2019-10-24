package com.example.supermario

import java.io.Serializable

class Pessoa (var nome:String, var idade: Int)  {
    override fun toString(): String {
        return "${nome} - ${idade}"
    }
}