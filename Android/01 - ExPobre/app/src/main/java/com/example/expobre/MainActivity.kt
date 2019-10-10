package com.example.expobre

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var tvNumeros: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvNumeros = findViewById(R.id.tvNumeros)
        this.tvNumeros.text = this.megasena().toString()
    }

    fun onClick(view: View){
        this.tvNumeros.text = this.megasena().toString()
    }

    fun megasena(): List<Int>{
        var lista = mutableSetOf<Int>()
        val random = Random()

        while (lista.size < 6){
            lista.add(random.nextInt(60) + 1)
        }

        return lista.toList()
    }
}
