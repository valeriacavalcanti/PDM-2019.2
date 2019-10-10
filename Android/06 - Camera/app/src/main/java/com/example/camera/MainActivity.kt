package com.example.camera

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView

class MainActivity : AppCompatActivity() {
    private lateinit var btFoto: Button
    private lateinit var ivFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btFoto = findViewById(R.id.btFoto)
        this.ivFoto = findViewById(R.id.ivFoto)

        this.btFoto.setOnClickListener({ onClick(it) })
    }

    fun onClick(view: View){
        val itFoto = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        startActivityForResult(itFoto, 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK){
            if (requestCode == 1){
                val imagem = data?.extras?.get("data") as Bitmap
                this.ivFoto.setImageBitmap(imagem)
            }
        }
    }
}
