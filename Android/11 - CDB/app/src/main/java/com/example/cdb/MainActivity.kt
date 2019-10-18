package com.example.cdb

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    private lateinit var lvStatus : ListView
    private lateinit var telaReceiver: TelaReceiver
    private lateinit var carregadorReceiver: CarregadorReceiver
    private lateinit var aviaoReceiver: AviaoReceiver
    private lateinit var dados: ArrayList<String>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.lvStatus = findViewById(R.id.lvStatus)
        this.telaReceiver = TelaReceiver()
        this.carregadorReceiver = CarregadorReceiver()
        this.aviaoReceiver = AviaoReceiver()

        this.dados = arrayListOf()
        this.lvStatus.adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.dados)
    }

    override fun onResume() {
        super.onResume()

        val itfTela = IntentFilter()
        itfTela.addAction(Intent.ACTION_USER_PRESENT)
        registerReceiver(this.telaReceiver, itfTela)

        val itfCarregador = IntentFilter()
        itfCarregador.addAction(Intent.ACTION_POWER_CONNECTED)
        itfCarregador.addAction(Intent.ACTION_POWER_DISCONNECTED)
        registerReceiver(this.carregadorReceiver, itfCarregador)

        val itfAviao = IntentFilter()
        itfAviao.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(this.aviaoReceiver, itfAviao)
    }

    override fun onPause() {
        super.onPause()

        unregisterReceiver(this.telaReceiver)
        unregisterReceiver(this.carregadorReceiver)
        unregisterReceiver(this.aviaoReceiver)
    }

    fun atualiza(){
        (this.lvStatus.adapter as ArrayAdapter<String>).notifyDataSetChanged()
    }

    inner class CarregadorReceiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if (intent?.action == Intent.ACTION_POWER_CONNECTED){
                this@MainActivity.dados.add("Conectado")
            }else if (intent?.action == Intent.ACTION_POWER_DISCONNECTED){
                this@MainActivity.dados.add("Desconectado")
            }

            this@MainActivity.atualiza()
        }
    }
}
