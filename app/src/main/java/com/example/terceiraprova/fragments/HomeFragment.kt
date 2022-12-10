package com.example.terceiraprova.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.terceiraprova.AppGlideModule
import com.example.terceiraprova.R
import com.example.terceiraprova.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        Glide.with(this).load("https://yt3.googleusercontent.com/ytc/AMLnZu8t-L46ThAbL3iA4h0HnmJWpkyTqTmCBz7Y4HvL=s900-c-k-c0x00ffffff-no-rj").into(binding.imageView)


        // Inflate the layout for this fragment
        return binding.root
    }

}