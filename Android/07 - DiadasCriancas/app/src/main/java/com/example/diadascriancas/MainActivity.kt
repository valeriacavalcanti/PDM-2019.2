package com.example.diadascriancas

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    val FORMULARIO = 1
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botao = findViewById(R.id.btMainAdd)
        this.botao.setOnClickListener({ clickForm(it) })
    }

    fun clickForm(view: View){
        val itForm = Intent(this, FormActivity::class.java)
        startActivityForResult(itForm, FORMULARIO)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == FORMULARIO){
                val nome = data?.getStringExtra("NOME")
                val presente = data?.getStringExtra("PRESENTE")
                val pedido = data?.getSerializableExtra("PEDIDO")

                Log.i("APP_DC", "${nome} - ${presente}")
                Log.i("APP_DC", pedido.toString())
            }
        }
    }
}
