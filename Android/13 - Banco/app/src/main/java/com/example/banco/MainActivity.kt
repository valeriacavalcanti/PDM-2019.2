package com.example.banco

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
import android.widget.ListView
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val FORM_INSERIR = 1
    private lateinit var lvPessoas: ListView
    private lateinit var dao: PessoaDAO
    private lateinit var lista: ArrayList<Pessoa>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        this.dao = PessoaDAO(this)
        this.lista = this.dao.get()

        this.lvPessoas = findViewById(R.id.lvMainPessoas)
        this.lvPessoas.adapter = PessoaAdapter(this, this.lista)
        this.lvPessoas.setOnItemClickListener(ClickList())

        fab.setOnClickListener { view ->
            val itForm = Intent(this, FormActivity::class.java)
            startActivityForResult(itForm, FORM_INSERIR)
        }
    }

    fun atualizar(){
        this.lista.clear()
        this.lista.addAll(this.dao.get())
        (this.lvPessoas.adapter as PessoaAdapter).update()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == FORM_INSERIR){
                val p = data?.getSerializableExtra("PESSOA") as Pessoa
                Log.i("APP_BANCO", "Pessoa: ${p.nome}")

                this.dao.insert(p)
                Log.e("APP_BANCO", this.dao.get().toString())

                this.atualizar()
            }
        }
    }

    inner class ClickList : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val pessoa = this@MainActivity.lista.get(position) as Pessoa
            val msg = "${pessoa.id} - ${pessoa.nome} - ${pessoa.idade}"
            Toast.makeText(this@MainActivity, msg, Toast.LENGTH_SHORT).show()
        }
    }
}
