package com.example.ifpb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var lvCampi: ListView
    private lateinit var ifpb: IFPB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.ifpb = IFPB()
        this.cadastraCampiIFPB()

        this.lvCampi = findViewById(R.id.lvCampi)
        this.lvCampi.adapter = ArrayAdapter<Campus>(this, android.R.layout.simple_list_item_1, this.ifpb.get())
        this.lvCampi.setOnItemClickListener(OnClickLista())
    }

    fun cadastraCampiIFPB(){
        this.ifpb.add(Campus("João Pessoa", "http://www.ifpb.edu.br/joaopessoa"))
        this.ifpb.add(Campus("Campina Grande", "http://www.ifpb.edu.br/campinagrande"))
        this.ifpb.add(Campus("Cajazeiras", "http://www.ifpb.edu.br/cajazeiras"))
        this.ifpb.add(Campus("Cabedelo", "http://www.ifpb.edu.br/cabedelo"))
    }

    inner class OnClickLista : AdapterView.OnItemClickListener{
        override fun onItemClick(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
            val campus = this@MainActivity.ifpb.get(position)
            //Toast.makeText(this@MainActivity, campus.url, Toast.LENGTH_SHORT).show()
            val itResposta = Intent()
            itResposta.putExtra("URL", campus.url)
            setResult(Activity.RESULT_OK, itResposta)
            finish()
        }

    }
}
