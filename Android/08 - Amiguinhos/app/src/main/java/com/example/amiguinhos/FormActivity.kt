package com.example.amiguinhos

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView

class FormActivity : AppCompatActivity() {
    private lateinit var btSalvar: Button
    private lateinit var btCancelar: Button
    private lateinit var tvGrau: TextView
    private lateinit var sbGrau: SeekBar
    private lateinit var etNome: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        this.btSalvar = findViewById(R.id.btFormSalvar)
        this.btCancelar = findViewById(R.id.btFormCancelar)

        this.etNome = findViewById(R.id.etFormNome)
        this.sbGrau = findViewById(R.id.sbFormGrau)
        this.tvGrau = findViewById(R.id.tvFormGrau)

        this.btSalvar.setOnClickListener({ clickSalvar(it) })

        this.btCancelar.setOnClickListener({
            finish()
        })

        this.sbGrau.setOnSeekBarChangeListener(ChangeSeekBar())

        this.tvGrau.text = this.sbGrau.progress.toString()

        var amigo = intent.getSerializableExtra("AMIGO")
        if (amigo != null){
            // veio amigo, ou seja, é edição
            this.etNome.text.append((amigo as Amigo).nome)
            this.sbGrau.progress = (amigo as Amigo).grau
        }
    }

    fun clickSalvar(view: View){
        val nome = this.etNome.text.toString()
        val grau = this.sbGrau.progress

        val amigo = Amigo(nome, grau)

        val itVolta = Intent()
        itVolta.putExtra("AMIGO", amigo)
        setResult(Activity.RESULT_OK, itVolta)
        finish()
    }

    inner class ChangeSeekBar : SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
            this@FormActivity.tvGrau.text = progress.toString()
        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
        }

    }
}
