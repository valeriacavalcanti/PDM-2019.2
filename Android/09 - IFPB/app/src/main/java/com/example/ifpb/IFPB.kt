package com.example.ifpb

class IFPB {
    private lateinit var lista: ArrayList<Campus>

    init {
        this.lista = arrayListOf()
    }

    fun add(campus:Campus){
        this.lista.add(campus)
    }

    fun get(index: Int):Campus{
        return this.lista[index]
    }

    fun get():ArrayList<Campus>{
        return this.lista
    }

    fun del(index: Int){
        this.lista.removeAt(index)
    }

    fun update(index: Int, campus: Campus){
        this.lista[index] = campus
    }

    override fun toString(): String {
        return this.lista.toString()
    }
}