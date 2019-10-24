package com.example.supermario

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var lv: ListView
    private lateinit var cadastro: Cadastro

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.cadastro = Cadastro()
        this.addPessoas()

        this.lv = findViewById(R.id.lvPessoas)
        this.lv.adapter = PessoaAdapter(this.cadastro, this)
    }

    fun addPessoas(){
        this.cadastro.add(Pessoa("Um", 1))
        this.cadastro.add(Pessoa("Dois", 2))
        this.cadastro.add(Pessoa("Três", 3))
        this.cadastro.add(Pessoa("Quatro", 4))
    }
}
