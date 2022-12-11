package com.example.terceiraprova.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.terceiraprova.databinding.PokemonViewBinding
import com.example.terceiraprova.model.Pokemon


class PokemonAdapter : ListAdapter<Pokemon, PokemonAdapter.PokemonViewHolder>(PokemonDiffUtilCallback()){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        return PokemonViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val remedio = getItem(position)
        holder.bind(remedio)
    }

    class PokemonViewHolder private constructor(var binding:PokemonViewBinding ) : RecyclerView.ViewHolder(binding.root){

        fun bind(pokemon: Pokemon) {
            binding.nomePersonagem.text = pokemon.name

            binding.nomePersonagem.setOnClickListener {
                Toast.makeText(binding.root.context, "CLicou no texto", Toast.LENGTH_SHORT).show()
            }
        }

        companion object {
            fun from(parent: ViewGroup): PokemonViewHolder {

                val inflater = LayoutInflater.from(parent.context)
                val binding = PokemonViewBinding.inflate(inflater, parent, false)
                return PokemonViewHolder(binding)
            }
        }
    }

    class PokemonDiffUtilCallback : DiffUtil.ItemCallback<Pokemon>(){
        override fun areItemsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.name.equals(newItem.name)
        }

        override fun areContentsTheSame(oldItem: Pokemon, newItem: Pokemon): Boolean {
            return oldItem.equals(newItem)
        }

    }
}