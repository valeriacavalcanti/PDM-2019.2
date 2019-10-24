package com.example.supermario

class Cadastro {
    private lateinit var lista: ArrayList<Pessoa>

    init {
        this.lista = arrayListOf()
    }

    fun add(pessoa: Pessoa){
        this.lista.add(pessoa)
    }

    fun get(index: Int) : Pessoa{
        return this.lista.get(index)
    }

    fun get(): ArrayList<Pessoa>{
        return this.lista
    }

    fun count(): Int{
        return this.lista.count()
    }
}