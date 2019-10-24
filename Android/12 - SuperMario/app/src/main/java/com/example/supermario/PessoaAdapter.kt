package com.example.supermario

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class PessoaAdapter (var cadastro:Cadastro, var context: Context) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val pessoa = this.cadastro.get(position)
        val linha : View

        if (convertView == null){
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            linha = inflater.inflate(R.layout.listview_celula, null)
        }else{
            linha = convertView
        }

        val tv = linha.findViewById<TextView>(R.id.tvLvPessoa)
        tv.text = pessoa.nome

        return linha
    }

    override fun getItem(position: Int): Any {
        return this.cadastro.get(position)
    }

    override fun getItemId(position: Int): Long {
        return -1
    }

    override fun getCount(): Int {
        return this.cadastro.count()
    }
}