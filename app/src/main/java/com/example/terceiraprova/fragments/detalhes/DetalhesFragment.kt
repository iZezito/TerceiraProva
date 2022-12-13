package com.example.terceiraprova.fragments.detalhes

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.terceiraprova.R
import com.example.terceiraprova.databinding.FragmentDetalhesBinding

class DetalhesFragment : Fragment() {

    lateinit var binding: FragmentDetalhesBinding
    lateinit var viewModel: DetalhesViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(DetalhesViewModel::class.java)
        binding = FragmentDetalhesBinding.inflate(inflater, container, false)
        val url = DetalhesFragmentArgs.fromBundle(requireArguments()).url
        //val id = url.replace("[^0-9]".toRegex(), "").replace("2","")
        viewModel.getPokemon(url)
        viewModel.pokemon.observe(viewLifecycleOwner) {
            Glide.with(this).load(it.imagemUrl).into(binding.imageView)
        }
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        return binding.root



    }
}