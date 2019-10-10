package com.example.vaievolta

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var botao: Button
    val OUTRA = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.botao = findViewById(R.id.btMainNavegacao)
        this.botao.setOnClickListener({ onClick(it) })

        Log.i("APP_VV", "Main - OnCreate")
    }

    fun onClick(view: View){
        Log.i("APP_VV", "Clicou no botão Vai")
        val mensagem = "Funciona!!"
        val intent = Intent(this, OutraActivity::class.java)
        intent.putExtra("MSG_IDA", mensagem)
        //startActivity(intent)
        startActivityForResult(intent, OUTRA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == OUTRA){
                val mensagem = data?.getStringExtra("MSG_VOLTA")
                Toast.makeText(this, mensagem, Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(this, "Voltou pelo dispositivo", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i("APP_VV", "Main - OnStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_VV", "Main - OnResume")
    }

    override fun onRestart() {
        super.onRestart()
        Log.i("APP_VV", "Main - OnRestart")
    }

    override fun onPause() {
        super.onPause()
        Log.i("APP_VV", "Main - OnPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_VV", "Main - OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i("APP_VV", "Main - OnDestroy")
    }
}
