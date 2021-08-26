package com.sarikaya.weatherforecastapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.sarikaya.weatherforecastapp.R
import com.sarikaya.weatherforecastapp.model.Sehir
import com.sarikaya.weatherforecastapp.view.BackFragment
import com.sarikaya.weatherforecastapp.view.MainActivity

class MyAdapter(val sehirList: ArrayList<Sehir>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview,parent,false)

        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: MyAdapter.ViewHolder, position: Int) {
        var sehirPos = sehirList[position]
        holder.sehir.text = sehirPos.sehir
        holder.saat.text = sehirPos.saat
        holder.derece.text = sehirPos.derece
        holder.image.setImageResource(sehirPos.iconImage)
        holder.itemView.setOnClickListener {
            val context = holder.image.context
            val fragment = BackFragment(sehirPos)
            context as MainActivity
            context.supportFragmentManager.beginTransaction().apply {
                replace(R.id.fragment,fragment)
                commit()
            }
        }

    }

    override fun getItemCount(): Int {
        return sehirList.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var sehir : TextView
        var saat : TextView
        var derece : TextView
        var image: ImageView

        init {
            sehir = itemView.findViewById(R.id.sehir)
            saat = itemView.findViewById(R.id.saat)
            derece = itemView.findViewById(R.id.derece)
            image = itemView.findViewById(R.id.iconImage)
        }
    }
}