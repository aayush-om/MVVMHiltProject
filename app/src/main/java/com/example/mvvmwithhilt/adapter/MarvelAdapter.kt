package com.example.mvvmwithhilt.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithhilt.databinding.RowMarvelListBinding
import com.example.mvvmwithhilt.model.MarvelModelItem

class MarvelAdapter(private val marvel: List<MarvelModelItem>) : RecyclerView.Adapter<MarvelAdapter.MarvelViewHolder>()  {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarvelViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: RowMarvelListBinding = RowMarvelListBinding.inflate(inflater, parent, false)
        return MarvelViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarvelViewHolder, position: Int) {
        val marvelModel = marvel[position]
        holder.binding.marvel = marvelModel
    }

    override fun getItemCount() = marvel.size

    class MarvelViewHolder(binding: RowMarvelListBinding) : RecyclerView.ViewHolder(binding.root) {
        val binding :RowMarvelListBinding = binding
    }
}