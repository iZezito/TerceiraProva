package com.example.terceiraprova.fragments.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.example.terceiraprova.AppGlideModule
import com.example.terceiraprova.R
import com.example.terceiraprova.adapter.PokemonAdapter
import com.example.terceiraprova.databinding.FragmentHomeBinding
import com.example.terceiraprova.model.Pokemon
import com.example.terceiraprova.retrofit.Endpoint
import com.example.terceiraprova.retrofit.NetworkUtils
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.log


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding
    lateinit var viewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = this

        // Inflate the layout for this fragment


        val adapter = PokemonAdapter()
        viewModel.getData()

        viewModel.listPokemons.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerView.addOnItemTouchListener(
            RecyclerViewClickListener(binding.recyclerView, object : RecyclerViewClickListener.OnItemClickListener{
                override fun onItemClick(view: View, position: Int) {
                    Toast.makeText(requireContext(), "Toque simples", Toast.LENGTH_SHORT).show()
                }

                override fun onItemLongClick(view: View, position: Int) {
                    Toast.makeText(requireContext(), "Toque longo", Toast.LENGTH_SHORT).show()
                }

            }))

        return binding.root
    }








}