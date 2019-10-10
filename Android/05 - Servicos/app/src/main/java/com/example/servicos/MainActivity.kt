package com.example.servicos

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    private lateinit var btHtml: Button
    private lateinit var btDiscar: Button
    private lateinit var btLigar: Button
    private lateinit var btEmail: Button
    private lateinit var btSMS: Button
    private lateinit var btCompartilhar: Button
    private lateinit var btPonto: Button
    private lateinit var btRota: Button
    private lateinit var btYoutube: Button
    private lateinit var btFoto: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btHtml = findViewById(R.id.btHtml)
        this.btDiscar = findViewById(R.id.btDiscar)
        this.btLigar = findViewById(R.id.btLigar)
        this.btEmail = findViewById(R.id.btEmail)
        this.btSMS = findViewById(R.id.btSMS)
        this.btCompartilhar = findViewById(R.id.btCompartilhar)
        this.btPonto = findViewById(R.id.btPonto)
        this.btRota = findViewById(R.id.btRota)
        this.btYoutube = findViewById(R.id.btYoutube)
        this.btFoto = findViewById(R.id.btFoto)

        this.btHtml.setOnClickListener({ onClickHtml(it) })
        this.btDiscar.setOnClickListener({ onClickDiscar(it) })
        this.btLigar.setOnClickListener({ onClickLigar(it) })
        this.btEmail.setOnClickListener({ onClickEmail(it) })
        this.btSMS.setOnClickListener({ onClickSMS(it) })
        this.btCompartilhar.setOnClickListener({ onClickCompartilhar(it) })
        this.btPonto.setOnClickListener({ onClickPonto(it) })
        this.btRota.setOnClickListener({ onClickRota(it) })
        this.btYoutube.setOnClickListener({ onClickYoutube(it) })
        this.btFoto.setOnClickListener({ onClickFoto(it) })
    }

    fun onClickHtml(view: View){
        val uri = Uri.parse("http://pdm.valeriacavalcanti.com.br")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun onClickDiscar(view: View){
        val uri = Uri.parse("tel:36121392")
        val it = Intent(Intent.ACTION_DIAL, uri)
        startActivity(it)
    }

    fun onClickLigar(view: View){
        val uri = Uri.parse("tel:36121392")
        val it = Intent(Intent.ACTION_CALL, uri)
        val call = Manifest.permission.CALL_PHONE
        val granted = PackageManager.PERMISSION_GRANTED

        if (ContextCompat.checkSelfPermission(this, call) == granted){
            startActivity(it)
        }
    }

    fun onClickEmail(view: View){
        val uri = Uri.parse("mailto:valeria.cavalcanti@ifpb.edu.br")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra(Intent.EXTRA_SUBJECT, "Assunto")
        it.putExtra(Intent.EXTRA_TEXT, "Texto")
        startActivity(it)
    }

    fun onClickSMS(view: View){
        val uri = Uri.parse("sms:36121392")
        val it = Intent(Intent.ACTION_SENDTO, uri)
        it.putExtra("sms_body", "Mensagem")
        startActivity(it)
    }

    fun onClickCompartilhar(view: View){
        val it = Intent(Intent.ACTION_SEND)

        it.setType("text/plain")
        it.putExtra(Intent.EXTRA_TEXT, "Texto para compartilhar")
        //it.setPackage("com.whatsapp")
        startActivity(Intent.createChooser(it, "Compartilhar"))
    }

    fun onClickPonto(view: View){
        val uri = Uri.parse("geo:-7.1356496,-34.8760932")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun onClickRota(view: View){
        val origem = "-7.1356496,-34.8760932"
        val destino = "-7.1181836,-34.8730402"
        val url = "http://maps.google.com/maps"
        val uri = Uri.parse("${url}?f=&saddr=${origem}+&daddr=${destino}")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun onClickYoutube(view: View){
        val uri = Uri.parse("vnd.youtube://H0Z7ewOXCKw")
        val it = Intent(Intent.ACTION_VIEW, uri)
        startActivity(it)
    }

    fun onClickFoto(view: View){
        val it = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivity(it)
    }
}
