package com.example.diadascriancas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etPresente: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etNome = findViewById(R.id.etFormNome)
        this.etPresente = findViewById(R.id.etFormPresente)

        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener({ clickSalvar(it) })
        this.btCancelar.setOnClickListener({ clickCancelar(it) })
    }

    fun clickSalvar(view: View){
        val nome = this.etNome.text.toString()
        val presente = this.etPresente.text.toString()

        val itResposta = Intent()
        itResposta.putExtra("NOME", nome)
        itResposta.putExtra("PRESENTE", presente)

        val pedido = Pedido(nome, presente)
        itResposta.putExtra("PEDIDO", pedido)

        setResult(Activity.RESULT_OK, itResposta)
        finish()
    }

    fun clickCancelar(view: View){
        finish()
    }
}
