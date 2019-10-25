package com.example.banco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity() {
    private lateinit var etNome: EditText
    private lateinit var etIdade: EditText
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.etNome = findViewById(R.id.etFormNome)
        this.etIdade = findViewById(R.id.etFormIdade)
        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.btSalvar.setOnClickListener(OnClickBotao())
        this.btCancelar.setOnClickListener({
            finish()
        })
    }

    inner class OnClickBotao : View.OnClickListener{
        override fun onClick(v: View?) {
            val nome = this@FormActivity.etNome.text.toString()
            val idade = this@FormActivity.etIdade.text.toString().toInt()
            val pessoa = Pessoa(nome, idade)

            val itResp = Intent()
            itResp.putExtra("PESSOA", pessoa)
            setResult(Activity.RESULT_OK, itResp)
            finish()
        }
    }
}
