package com.example.ifpb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var texto: TextView
    private lateinit var botao: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.texto = findViewById(R.id.tvInstituicao)
        this.botao = findViewById(R.id.btAperte)

        this.botao.setOnClickListener( { clica(it) })

        this.texto.setOnClickListener({
            this.texto.text = ""
            Log.i("APP_IFPB", "Clicou no texto!")
        })
    }

    fun clica(view: View){
        this.texto.text = "IFPB"
        Log.e("APP_IFPB", "Clicou no botão")
    }
}
