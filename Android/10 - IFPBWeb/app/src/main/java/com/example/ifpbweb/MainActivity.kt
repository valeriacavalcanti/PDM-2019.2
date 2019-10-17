package com.example.ifpbweb

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val IFPB = 1
    private lateinit var btOlhe: Button
    private lateinit var wvIFPB: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btOlhe = findViewById(R.id.btOlhe)
        this.wvIFPB = findViewById(R.id.wvIFPB)

        this.btOlhe.setOnClickListener(OnClickBotao())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == IFPB){
                val url = data?.getStringExtra("URL")
                this.wvIFPB.loadUrl(url)
                Toast.makeText(this, url, Toast.LENGTH_SHORT).show()
            }
        }
    }

    inner class OnClickBotao : View.OnClickListener{
        override fun onClick(v: View?) {
            //val url = "http://www.ifpb.edu.br"
            //this@MainActivity.wvIFPB.loadUrl(url)
            val itIFPB = Intent("IFPB")
            startActivityForResult(itIFPB, IFPB)
        }
    }
}
