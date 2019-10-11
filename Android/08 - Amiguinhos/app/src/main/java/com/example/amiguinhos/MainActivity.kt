package com.example.amiguinhos

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val FORMULARIO_ADD = 1
    val FORMULARIO_EDIT = 2
    var POSITION_EDIT = -1
    private lateinit var lista: ArrayList<Amigo>
    private lateinit var lvAmigos: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            val itForm = Intent(this, FormActivity::class.java)
            startActivityForResult(itForm, FORMULARIO_ADD)
        }

        this.lista = arrayListOf()
        this.lvAmigos = findViewById(R.id.lvMainAmiguinhos)
        this.lvAmigos.setOnItemClickListener(ClickList())
        this.lvAmigos.setOnItemLongClickListener(LongClickList())

        this.lista.add(Amigo("Teste 1", 1))
        this.lista.add(Amigo("Teste 2", 2))
        this.lista.add(Amigo("Teste 3", 3))
        this.lista.add(Amigo("Teste 4", 4))

        this.lvAmigos.adapter = ArrayAdapter<Amigo>(this, android.R.layout.simple_list_item_1, this.lista)
    }

    fun atualizaLista(){
        (this.lvAmigos.adapter as ArrayAdapter<Amigo>).notifyDataSetChanged()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == FORMULARIO_ADD){
                val amigo = data?.getSerializableExtra("AMIGO") as Amigo
                this.lista.add(amigo)
                this.atualizaLista() // avisa que a lista foi atualizada
                Log.i("APP_AMIGO", this.lista.toString())
            }else if (requestCode == FORMULARIO_EDIT){
                val amigo = data?.getSerializableExtra("AMIGO") as Amigo
                this.lista[this.POSITION_EDIT] = amigo
                this.atualizaLista()
            }
        }
    }

    inner class ClickList : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val amigo = this@MainActivity.lista[position]
            val itForm = Intent(this@MainActivity, FormActivity::class.java)
            //Toast.makeText(this@MainActivity, amigo.toString(), Toast.LENGTH_SHORT).show()
            itForm.putExtra("AMIGO", amigo)
            this@MainActivity.POSITION_EDIT = position
            startActivityForResult(itForm, FORMULARIO_EDIT)
        }
    }

    inner class LongClickList : AdapterView.OnItemLongClickListener{
        override fun onItemLongClick(
            parent: AdapterView<*>?,
            view: View?,
            position: Int,
            id: Long
        ): Boolean {
            this@MainActivity.lista.removeAt(position)
            this@MainActivity.atualizaLista()
            return true
        }

    }
}
